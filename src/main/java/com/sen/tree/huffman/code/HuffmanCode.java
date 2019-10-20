package com.sen.tree.huffman.code;

import java.io.*;
import java.util.*;

/**
 * @Auther: Sen
 * @Date: 2019/10/20 01:49
 * @Description: 代码实现赫夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //赫夫曼编码
        // String msg = "can you can a can as a can canner can a can.";
        // byte[] bytes = msg.getBytes();
        // byte[] huffmanZip = huffmanZip(bytes);
        // byte[] decode = huffmanUnzip(huffmanZip);
        // System.out.println(new String(decode));

        //压缩文件
        // String src = "1.bmp";
        // String target = "2.zip";
        // zipFile(src, target);

        //解压文件
        unzipFile("2.zip", "3.bmp");
    }

    /**
     * 利用赫夫曼编码解压文件
     * @param src
     * @param target
     */
    private static void unzipFile(String src, String target) throws IOException, ClassNotFoundException {
        //获取输入流
        InputStream in = new FileInputStream(src);
        //用对象流包装输入流
        ObjectInputStream objectIn = new ObjectInputStream(in);
        //读取压缩后的文件数据
        byte[] bytes = (byte[]) objectIn.readObject();
        //读取赫夫曼编码
        Map<Byte,String> huffmanCodes = (Map<Byte, String>) objectIn.readObject();
        in.close();
        objectIn.close();
        //解压
        byte[] data = huffmanUnzip(huffmanCodes,bytes);
        //创建输出流
        OutputStream out = new FileOutputStream(target);
        out.write(data);
        out.close();
    }

    /**
     * 用赫夫曼编码表压缩文件
     * @param src 源文件路径
     * @param target 压缩后文件存放路径
     */
    private static void zipFile(String src, String target) throws IOException {
        //创建输入流
        InputStream in = new FileInputStream(src);
        //创捷字节数组用于存放读取的内容
        byte[] bytes = new byte[in.available()];
        //把输入流写入字节数组
        in.read(bytes);
        in.close();
        //创建赫夫曼编码表,并编码
        byte[] encode = huffmanZip(bytes);
        OutputStream out = new FileOutputStream(target);
        ObjectOutputStream object = new ObjectOutputStream(out);
        object.writeObject(encode);
        object.writeObject(codes);
        out.close();
        object.close();
    }

    /**
     * 解码赫夫曼压缩的数据
     *
     * @param huffmanZip
     * @return
     */
    private static byte[] huffmanUnzip(Map<Byte, String> codes, byte[] huffmanZip) {
        //将十进制的字节数组转换成二进制字符串
        String binStr = byteToDECStr(huffmanZip);
        //对照赫夫曼编码表解压
        //把赫曼编码表的键值调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : codes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建用于保存解压的数据
        List<Byte> list = new ArrayList<>();
        //对照赫夫曼表解压
        for (int i = 0; i < binStr.length(); ) {
            //循环标记
            boolean falg = true;
            Byte encode = null;
            int count = 1;
            while (falg) {
                String key = binStr.substring(i, i + count);
                encode = map.get(key);
                //不存在的编码
                if (encode == null) {
                    count++;
                } else {
                    falg = false;
                }
            }
            i += count;
            list.add(encode);
        }
        //把集合转换成数组
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    /**
     * 补全十进制转二进制的高位
     * @param huffmanZip 压缩的字节数组
     * @return
     */
    private static String byteToDECStr(byte[] huffmanZip) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanZip.length; i++) {
            boolean flag = true;
            if (huffmanZip.length - i == 1) {
                flag = false;
            }
            if (flag) {
                int temp = huffmanZip[i];
                temp |= 256;
                String str = Integer.toBinaryString(temp);
                stringBuilder.append(str.substring(str.length() - 8));
            } else {
                String str = Integer.toBinaryString(huffmanZip[i]);
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 构建赫夫曼编码表并压缩
     * @param bytes 信息
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //统计每个字符出现的次数，并创建若干个二叉树
        List<Node> nodes = createBinaryTree(bytes);
        //构建赫夫曼树
        Node node = createHuffmanTree(nodes);
        //创建赫夫曼编码表
        Map<Byte, String> huffCodes = getCodes(node);
        //编码(压缩)
        byte[] zip = zip(bytes,huffCodes);
        return zip;
    }

    /**
     * 进行赫夫曼编码
     * @param bytes 编码前的内容
     * @param huffCodes 赫夫曼编码表
     * @return 返回压缩后内容
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder str = new StringBuilder();
        //把编码前的内容编码成二进制字符串
        for (byte b : bytes) {
            String s = huffCodes.get(b);
            str.append(s);
        }
        //确定压缩后的byte[]的长度
        int length;
        if (str.length() % 8 == 0) {
            length = str.length() / 8;
        } else {
            length = str.length() / 8 + 1;
        }
        byte[] encode = new byte[length];
        int index = 0;
        //将二进制字符串切割成比特数组
        for (int i = 0; i < str.length(); i += 8) {
            String sub = null;
            //不能完整切割时
            if (str.length() - i < 8) {
                sub = str.substring(i);
            } else {
                sub = str.substring(i, i + 8);
            }
            //将切割后的二进制字符串转换成十进制，接着转换成byte
            byte temp = (byte) Integer.parseInt(sub, 2);
            encode[index] = temp;
            index++;
        }
        return encode;
    }

    //用于临时存储路径，即赫夫曼编码
    static StringBuilder sb = new StringBuilder();
    //用于临时存储赫夫曼编码和对应的字符
    static Map<Byte,String> codes = new HashMap<>();
    /**
     * 创建赫夫曼编码表
     * @param node
     * @return
     */
    private static Map<Byte, String> getCodes(Node node) {
        if (node == null) {
            return null;
        }
        getCodes(node.getLeft(),"0",sb);
        getCodes(node.getRight(), "1", sb);
        return codes;
    }

    private static void getCodes(Node node, String s, StringBuilder stringBuilder) {
        StringBuilder sb2 = new StringBuilder(stringBuilder);
        sb2.append(s);
        //非叶子节点，递归查找
        if (node.getData() == null) {
            getCodes(node.getLeft(), "0", sb2);
            getCodes(node.getRight(), "1", sb2);
        //找到目标节点
        } else {
            codes.put(node.getData(), sb2.toString());
        }
    }

    /**
     * 构建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出最小的连个二叉树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            //创建新的树
            Node parent = new Node(null, left.getWeight() + right.getWeight());
            //把取出来的两个二叉树作为新树的子树
            parent.setLeft(left);
            parent.setRight(right);
            //把两个子树删除
            nodes.remove(left);
            nodes.remove(right);
            //把新树加到集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 统计每个字符出现的次数，并创建若干个二叉树
     * @param bytes
     * @return
     */
    private static List<Node> createBinaryTree(byte[] bytes) {
        //创建集合存储二叉树
        List<Node> nodes = new ArrayList<>();
        //统计每个字符出现的次数
        Map<Byte,Integer> map = new HashMap<>();
        for (byte b : bytes) {
            //获取每个字符的数量
            Integer count = map.get(b);
            //集合中没有相应的字符
            if (count == null) {
                map.put(b, 1);
            //集合中已经存在
            } else {
                map.put(b, count + 1);
            }
        }
        //初始化二叉树
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
}
