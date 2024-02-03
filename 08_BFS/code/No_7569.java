package code;

import java.io.*;
import java.util.*;
public class No_7569 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();

        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        int H = Integer.parseInt(inputs[2]);

        int[][][] boxes = new int[H][N][M];
        int[][][] vis = new int[H][N][M];
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dh = {0, 0, 0, 0, 1, -1}; // 상, 하, 좌, 우, 위층, 아래층
        int blueTomato = 0;

        for(int z = 0; z < H; z++){
            for (int x = 0; x < N; x++) {
                inputs = br.readLine().split(" ");
                for (int y = 0; y < M; y++) {
                    int status = Integer.parseInt(inputs[y]);
                    boxes[z][x][y] = status;
                    if(status == 1){
                        queue.offer(new Pair(z, x, y));
                        vis[z][x][y] = 1;
                    }
                    if(status == 0) blueTomato++;
                }
            }
        }

        while(!queue.isEmpty()){
            Pair tomato = queue.poll();
            for(int i = 0; i < 6; i++){
                int moveH = tomato.h + dh[i];
                int moveX = tomato.x + dx[i];
                int moveY = tomato.y + dy[i];
                if(moveH < 0 || moveX < 0 || moveY < 0 || moveH >= H || moveX >= N || moveY >= M) continue;
                if(boxes[moveH][moveX][moveY] == -1 || boxes[moveH][moveX][moveY] == 1 || vis[moveH][moveX][moveY] > 0) continue;
                queue.offer(new Pair(moveH, moveX, moveY));
                vis[moveH][moveX][moveY] = vis[tomato.h][tomato.x][tomato.y] + 1;
                boxes[moveH][moveX][moveY] = 1;
                blueTomato--;
            }
        }

        int day = 0;
        if(blueTomato != 0){
            day = -1;
        }
        else{
            for(int z = 0; z < H; z++){
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < M; y++) {
                        if(vis[z][x][y] - 1 > day){
                            day = vis[z][x][y] - 1;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(day));

        br.close();
        bw.flush();
        bw.close();
    }

    static class Pair{
        int x, y, h;
        Pair(int h, int x, int y){
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
}
