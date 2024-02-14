package code;

import java.io.*;
import java.util.*;
public class No_2573 {
    static String[] inputs;
    static Queue<Pair> queue = new LinkedList<>();
    static Queue<Pair> stateIce = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[][] iceberg = new int[N][M];

        // 현재 빙산 상태 입력
        for(int i = 0; i < N; i++){
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(inputs[j]);
                if (iceberg[i][j] > 0) {
                    stateIce.offer(new Pair(i, j));
                }
            }
        }

        int year = 0;
        int state = -1;
        while(state <= 1){
            melt(iceberg);
            state = checkIceberg(iceberg);
            if(state == 0){
                year = 0;
                break;
            }
            year++;
        }

        bw.write(String.valueOf(year));

        br.close();
        bw.flush();
        bw.close();
    }

    static void melt(int[][] iceberg){
        int row = iceberg.length;
        int col = iceberg[0].length;
        int[][] visit = new int[row][col];

        while (!stateIce.isEmpty()) {
            Pair ice = stateIce.poll();
            for (int i = 0; i < 4; i++) {
                if(iceberg[ice.x][ice.y] == 0) break;
                int aroundIceX = ice.x + dx[i];
                int aroundIceY = ice.y + dy[i];

                if(aroundIceX < 0 || aroundIceY < 0 || aroundIceX >= row || aroundIceY >= col) continue;
                if(iceberg[aroundIceX][aroundIceY] == 0 & visit[aroundIceX][aroundIceY] == 0){
                    iceberg[ice.x][ice.y]--;
                }
            }
            visit[ice.x][ice.y] = 1;
        }
    }

    static int checkIceberg(int[][] iceberg) {
        int count = 0;
        int row = iceberg.length;
        int col = iceberg[0].length;
        int[][] visit = new int[row][col];

        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if(iceberg[i][j] > 0 && visit[i][j] == 0){
                    count++;
                    if(count > 1) return count;
                    queue.offer(new Pair(i, j));
                    stateIce.offer(new Pair(i, j));
                    visit[i][j] = 1;
                    while (!queue.isEmpty()) {
                        Pair ice = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int moveX = ice.x + dx[k];
                            int moveY = ice.y + dy[k];

                            if(moveX < 0 || moveY < 0 || moveX >= row || moveY >= col) continue;
                            if(iceberg[moveX][moveY] == 0 || visit[moveX][moveY] == 1) continue;
                            queue.offer(new Pair(moveX, moveY));
                            stateIce.offer(new Pair(moveX, moveY));
                            visit[moveX][moveY] = 1;
                        }
                    }
                }
            }
        }
        return count;
    }

    static class Pair{
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}