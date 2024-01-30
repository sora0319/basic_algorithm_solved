package code;

import java.io.*;
import java.util.*;
public class No_7576 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();

        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);

        int[][] box = new int[N][M];
        int[][] dis = new int[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(inputs[j]);
                if(box[i][j] == 1){
                    queue.offer(new Pair(i,j));
                    dis[i][j] = 1;
                }
                if(box[i][j] == -1){
                    dis[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            Pair tomato = queue.poll();
            for(int i = 0; i < 4; i++){
                int moveX = tomato.x + dx[i];
                int moveY = tomato.y + dy[i];
                if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) continue;
                if(dis[moveX][moveY] > 0 || box[moveX][moveY] == -1) continue;
                dis[moveX][moveY] = dis[tomato.x][tomato.y] + 1;
                queue.offer(new Pair(moveX, moveY));
            }
        }

        int maxDis = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(dis[i][j] == 0){
                    maxDis = -1;
                    break;
                }
                if(maxDis < dis[i][j]){
                    maxDis = dis[i][j] - 1;
                }
            }
            if(maxDis == -1) break;
        }

        bw.write(String.valueOf(maxDis));

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
