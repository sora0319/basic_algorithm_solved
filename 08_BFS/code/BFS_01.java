package code;

import java.util.*;
public class BFS_01 {
    static int[][] board = {
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    }; // 파란색은 1, 빨간색은 0으로 표시한 보드
    static boolean[][] vis = new boolean[502][502]; // 방문기록을 저장하는 코드
    static int n = 7, m = 10; //  n = 행의 수, m = 열의 수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동 값 저장

    public static void main(String[] args) {
        Queue<Pair> queue = new LinkedList<>();
        vis[0][0] = true;
        queue.offer(new Pair(0, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = pair.x + dx[i];
                int moveY = pair.y + dy[i];
                if(moveX < 0 || moveY < 0 || moveX >= n || moveY >= m){
                    continue;
                }
                if(vis[moveX][moveY] || board[moveX][moveY] == 0){
                    continue;
                }
                queue.offer(new Pair(moveX, moveY));
                vis[moveX][moveY] = true;
            }
        }


    }
    static class Pair{
        private int x, y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
