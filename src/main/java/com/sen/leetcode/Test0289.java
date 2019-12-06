package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/12/5 02:55
 * @Description: 生命游戏
 * 1——保持1
 * -1——1转0
 * 0——保持0
 * -2——0转1
 */
public class Test0289 {

    public static void main(String[] args) {
        gameOfLife(new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        });
    }

    public static void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = checkLoc(board, i, j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }
        System.out.println("wait");
    }

    public static int checkLoc(int[][] board, int i, int j){
        int count = 0;
        int left = Math.max(j - 1, 0);
        int right = Math.min(j + 1, board[i].length - 1);
        int top = Math.max(i - 1, 0);
        int bottom = Math.min(i + 1, board.length - 1);
        for(int x = top; x <= bottom; x++){
            for(int y = left; y <= right; y++){
                if(x == i && y == j) continue;
                count = board[x][y] == 1 || board[x][y] == -1 ? count + 1 : count;
            }
        }
        return board[i][j] == 1 ? (count == 2 || count == 3 ? 1 : -1) : (count == 3 ? -2 : 0);
    }
}
