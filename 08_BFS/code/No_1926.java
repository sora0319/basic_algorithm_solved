package code;

import java.io.*;
import java.util.*;
public class No_1926 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for (int x = 0; x < n; x++) {
            inputs = br.readLine().split(" ");
            for (int y = 0; y < m; y++) {
                board[x][y] = Integer.parseInt(inputs[y]);
            }
        }

        int maxSize = 0;
        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                if(vis[x][y] || board[x][y] == 0) continue;
                int size = 1;
                queue.offer(new Pair(x, y));
                vis[x][y] = true;

                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int moveX = pair.x + dx[i];
                        int moveY = pair.y + dy[i];
                        if (moveX < 0 || moveY < 0 || moveX >= n || moveY >= m) continue;
                        if(vis[moveX][moveY] || board[moveX][moveY] == 0) continue;
                        queue.offer(new Pair(moveX, moveY));
                        vis[moveX][moveY] = true;
                        size++;
                    }
                }
                if(maxSize < size) maxSize = size;
                count++;
            }
        }


        bw.write(String.valueOf(count));
        bw.newLine();
        bw.write(String.valueOf(maxSize));

        br.close();
        bw.flush();
        bw.close();
    }

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
