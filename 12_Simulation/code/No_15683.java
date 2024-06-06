package code;
import java.io.*;
import java.util.*;

public class No_15683 {
    private static Pair[][] cctv = new Pair[6][8];
    private static int[] cctvCount = new int[6];
    private static boolean[] directions = new boolean[4];
    private static int[] moveX = {-1,0,1,0}; // 상좌하우
    private static int[] moveY = {0,-1,0,1}; // 상좌하우
    private static int[][]  board, eyesight;

    private static int N, M, countBlindSpot;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        eyesight = new int[N][M];
        countBlindSpot = N*M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                board[i][j] = n;
                cctv[n][cctvCount[n]++] = new Pair(i,j);
                if(n != 0) countBlindSpot--;
            }
        }

        for(int i = 5; i > 0; i--){
            for (int j = 0; j < cctvCount[i]; j++) {
                Pair pair = cctv[i][j];
                //
            }
        }

        // directions 초기화


        br.close();
        bw.flush();
        bw.close();
    }

    private static int countEyesight(int cctvType, Pair pair) {
        int[] directionCount = new int[4];
        int maxEyesight = 0;
        int x = pair.x;
        int y = pair.y;

        for(int d = 0; d < 4; d++){
            int newX = x + moveX[d];
            int newY = y + moveY[d];
            if(newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
            directionCount[d] = countDirectionEyesight(d, x, y);
        }

        if(cctvType == 1) {
            for (int i = 0; i < 4; i++) {
                if(maxEyesight < directionCount[i]){
                    maxEyesight = directionCount[i];
                    directions[i] = true;
                }

            }
        }
        if (cctvType == 2) {
            for (int i = 0; i < 2; i++) {
                int sight = directionCount[i] + directionCount[i+2];
                if (maxEyesight < sight) {
                    maxEyesight = sight;
                    directions[i] = true;
                    directions[i+2] = true;
                }
            }
        }
        if (cctvType == 3) {
            for (int i = 0; i < 4; i++) {
                if(i != 3){
                    int sight = directionCount[i] + directionCount[i + 1];
                }
                if (i == 3) {
                    int sight = directionCount[i] + directionCount[i - 3];
                }

            }
        }

        return maxEyesight;
    }

    private static int countDirectionEyesight(int d, int x, int y){
        int countE = 0;
        if(d == 0){
            for(int i = 0; i < x; i++){
                if(eyesight[i][y] == 0) countE++;
                if(eyesight[i][y] == 6) countE = 0;
            }
        }
        if(d == 1){
            for (int i = N - 1; i > x; i--) {
                if(eyesight[i][y] == 0) countE++;
                if(eyesight[i][y] == 6) countE = 0;
            }
        }
        if (d == 2) {
            for (int i = 0; i < y; i++) {
                if(eyesight[x][i] == 0) countE++;
                if(eyesight[x][i] == 6) countE = 0;
            }
        }
        if (d == 2) {
            for (int i = M - 1; i > y; i--) {
                if(eyesight[x][i] == 0) countE++;
                if(eyesight[x][i] == 6) countE = 0;
            }
        }

        return countE;
    }

    private static class Pair {
        int x,y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
