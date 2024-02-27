package code;

import java.io.*;
import java.util.*;
public class No_1600 {
    static int[] dxM = {-1, 1, 0, 0};
    static int[] dyM = {0, 0, -1, 1};
    static int[] dxH = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dyH = {1, -1, -2, -2, -1, 1, 2, 2};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Position> queue = new LinkedList<>();

        int K = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int W = Integer.parseInt(inputs[0]);
        int H = Integer.parseInt(inputs[1]);

        int[][] board = new int[H][W];
        int[][][] dist = new int[K+1][H][W];
        queue.offer(new Position(0, 0, 0));
        dist[0][0][0] = 1;

        for (int i = 0; i < H; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int end = 0;
        while (!queue.isEmpty()) {
            int k = queue.peek().k;
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();

            if (x == H - 1 && y == W - 1) {
                end = dist[k][x][y];
                queue.clear();
                break;
            }

            for (int i = 0; i < 4; i++) {
                int Mx = x + dxM[i];
                int My = y + dyM[i];
                if(0 > Mx || 0 > My || Mx >= H || My >= W) continue;
                if(board[Mx][My] == 1) continue;
                if(dist[k][Mx][My] > 0) continue;
                dist[k][Mx][My] = dist[k][x][y] + 1;
                if(Mx == W-1 && My == H-1){
                    end = dist[k][Mx][My];
                    queue.clear();
                    break;
                }
                queue.offer(new Position(k, Mx, My));
            }

            if(k+1 < K+1){
                for (int i = 0; i < 8; i++) {
                    int Hk = k + 1;
                    int Hx = x + dxH[i];
                    int Hy = y + dyH[i];

                    if (Hx < 0 || Hy < 0 || Hx >= H || Hy >= W) continue;
                    if (board[Hx][Hy] == 1) continue;
                    if (dist[Hk][Hx][Hy] > 0) continue;
                    dist[Hk][Hx][Hy] = dist[k][x][y] + 1;
                    if (Hx == H - 1 && Hy == W - 1) {
                        end = dist[Hk][Hx][Hy];
                        queue.clear();
                        break;
                    }
                    queue.offer(new Position(Hk, Hx, Hy));
                }
            }
        }

        bw.write(String.valueOf(end-1));

        br.close();
        bw.flush();
        bw.close();
    }

    static class Position{
        int k, x, y;

        Position(int k, int x, int y) {
            this.k = k;
            this.x = x;
            this.y = y;
        }
    }
}
