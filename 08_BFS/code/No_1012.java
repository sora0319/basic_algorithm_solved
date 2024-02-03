package code;

import java.io.*;
import java.util.*;
public class No_1012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> findQueue = new LinkedList<>();

        int T = Integer.parseInt(br.readLine());

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        while(T-- > 0){
            String[] inputs = br.readLine().split(" ");
            int M = Integer.parseInt(inputs[0]);
            int N = Integer.parseInt(inputs[1]);
            int K = Integer.parseInt(inputs[2]);

            int[][] space = new int[N][M];
            int[][] vis = new int[N][M];
            for(int i = 0; i < K; i++){
                inputs = br.readLine().split(" ");
                int X = Integer.parseInt(inputs[0]);
                int Y = Integer.parseInt(inputs[1]);
                space[Y][X] = 1;
                queue.offer(new Pair(Y, X));
            }

            Pair cabbage;
            int count = 0;
            while (!queue.isEmpty()) {
                if(!findQueue.isEmpty()){
                    cabbage = findQueue.poll();
                } else{
                    cabbage = queue.poll();
                    if(vis[cabbage.y][cabbage.x] == 1)continue;
                    count++;
                }

                for(int i = 0; i < 4; i++){
                    int moveY = cabbage.y + dy[i];
                    int moveX = cabbage.x + dx[i];
                    if(moveY < 0 || moveY >= N || moveX < 0 || moveX >= M) continue;
                    if(space[moveY][moveX] == 0 || vis[moveY][moveX] == 1) continue;
                    findQueue.offer(new Pair(moveY, moveX));
                    vis[moveY][moveX] = 1;
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Pair{
        int x,y;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}