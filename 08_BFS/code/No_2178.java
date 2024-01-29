package code;

import java.io.*;
import java.util.*;
public class No_2178 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[][] board = new int[N][M];
        int[][] dis = new int[N][M];
        boolean[][] vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        queue.offer(new Pair(0,0));
        vis[0][0] = true;
        dis[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair cross = queue.poll();
            if(cross.x == N-1 && cross.y == M-1) break;

            for (int i = 0; i < 4; i++) {
                int moveX = cross.x + dx[i];
                int moveY = cross.y + dy[i];
                if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) continue;
                if(vis[moveX][moveY] || board[moveX][moveY] == 0) continue;
                queue.offer(new Pair(moveX, moveY));
                vis[moveX][moveY] = true;
                dis[moveX][moveY] = dis[cross.x][cross.y] + 1;
            }
        }

        bw.write(String.valueOf(dis[N-1][M-1]));

        br.close();
        bw.flush();
        bw.close();
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
