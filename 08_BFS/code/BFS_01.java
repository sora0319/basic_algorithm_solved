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
        Queue<Pair> queue = new LinkedList<>(); // 방문을 관리할 큐
        vis[0][0] = true; // 방문을 저정할 배열
        queue.offer(new Pair(0, 0)); // 첫 시작 부분인 0,0을 큐에 저장

        while(!queue.isEmpty()){
            Pair pair = queue.poll(); // 시작 부분을 큐에서 빼서 사용
            for (int i = 0; i < 4; i++) { // 상하좌우로 확인
                int moveX = pair.x + dx[i];
                int moveY = pair.y + dy[i];
                if(moveX < 0 || moveY < 0 || moveX >= n || moveY >= m){
                    continue; // board의 범위보다 작거나 크면 넘어감
                }
                if(vis[moveX][moveY] || board[moveX][moveY] == 0){
                    continue; // 방문했던 위치이거나 board에서 빨간색 위치이면 넘어감
                }
                queue.offer(new Pair(moveX, moveY)); // 새로운 파란색 위치를 큐에 저장
                vis[moveX][moveY] = true; // 방문했다고 표시
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
