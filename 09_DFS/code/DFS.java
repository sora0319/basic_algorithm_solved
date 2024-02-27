package code;

import java.util.*;

public class DFS {
    static int[][] board = {
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    }; // 파란색은 1, 빨간색은 0으로 표시한 보드

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Stack<Pair> stack = new Stack<>();
        int row = board.length;
        int col = board[0].length;
        int[][] vis = new int[row][col];

        // 0,0에서 시작하는 dfs 구하는 코드
        stack.push(new Pair(0,0));
        vis[0][0] = 1;

        while (!stack.isEmpty()) {
            int x = stack.peek().x;
            int y = stack.peek().y;
            stack.pop();

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];
                if(moveX < 0 || moveY < 0 || moveX >= row || moveY >= col) continue;
                if(vis[moveX][moveY] > 0 || board[moveX][moveY] == 0) continue;
                stack.push(new Pair(moveX, moveY));
                vis[moveX][moveY] = vis[x][y] + 1;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(vis[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Pair{
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
