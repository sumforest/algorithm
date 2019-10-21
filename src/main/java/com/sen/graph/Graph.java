package com.sen.graph;

import com.sen.stack.StackDemo;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/22 00:10
 * @Description: 图
 */
public class Graph {

    private Vertex[] vertices;

    /**
     * 描述顶点间关系的邻接矩阵
     * 1 相通，2 不通
     */
    private int[][] adjmat;

    /**
     * 当前vertices的下标
     */
    private int currentIndex;


    /**
     * 当前邻接矩阵的行列坐标
     */
    private int currentAdjmatIndex;

    /**
     * 自定义的栈结构
     */
    private StackDemo stack;

    public Graph() {
    }

    public Graph(int size) {
        this.vertices = new Vertex[size];
        this.adjmat = new int[size][size];
        //初始化顶点到它本身是通的
        for (int i = 0; i < size; i++) {
            adjmat[i][i] = 1;
        }
    }

    public int[][] getAdjmat() {
        return adjmat;
    }

    /**
     * 添加顶点
     * @param vertex
     */
    public void addVertex(Vertex vertex) {
        vertices[currentIndex++] = vertex;
    }

    /**
     * 添加边
     * @param value1 顶点1
     * @param value2 顶点2
     */
    public void addEdge(String value1, String value2) {
        //找到两个顶点的下标
        int index1 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (value1.equals(vertices[i].getValue())) {
                index1 = i;
                break;
            }
        }
        int index2 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (value2.equals(vertices[i].getValue())) {
                index2 = i;
                break;
            }
        }
        //标记顶点和顶点之间的关系
        adjmat[index1][index2] = 1;
        adjmat[index2][index1] = 1;
    }

    /**
     * 图的遍历（深度优先搜索算法）
     */
    public void show() {
        //已第一个顶点开始
        Vertex vertex = vertices[0];
        stack = new StackDemo();
        //入栈
        stack.push(0);
        //标记为已遍历
        vertex.setVisited(true);
        System.out.println(vertex.getValue());
        //循环查找
        while (!stack.isEmpty()) {
            for (int i = currentAdjmatIndex + 1; i < vertices.length; i++) {
                if (adjmat[currentAdjmatIndex][i] == 1 && vertices[i].isVisited() == false) {
                    System.out.println(vertices[i].getValue());
                    vertices[i].setVisited(true);
                    //入栈
                    stack.push(i);
                }
            }
            //弹出栈顶元素
            stack.pop();
            //修改当前的坐标为栈顶元素
            if (!stack.isEmpty()) {
                currentAdjmatIndex = stack.peek();
            }
        }
    }
    @Override
    public String toString() {
        return "vertices=" + Arrays.toString(vertices);
    }
}
