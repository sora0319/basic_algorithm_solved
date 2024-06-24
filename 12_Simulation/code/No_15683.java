package code;
import java.io.*;
import java.util.*;

public class No_15683 {
    private static Pair[][] cctv = new Pair[6][64];
    private static int[] cctvCount = new int[6];
    private static final int[] moveX = {-1,0,1,0}; // 상좌하우
    private static final int[] moveY = {0,-1,0,1}; // 상좌하우
    private static int[][] eyesight;

    private static int N, M, blindSpotCount;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        eyesight = new int[N][M];
        blindSpotCount = N*M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                eyesight[i][j] = n;
                if(n == 0) continue;
                blindSpotCount--;
                if(n == 6) continue;
                cctv[n][cctvCount[n]++] = new Pair(i,j);
            }
        }
        int[] order = {5,4,1,2,3};
        for(int i : order){
            for (int j = 0; j < cctvCount[i]; j++) {
                Pair pair = cctv[i][j];
                boolean[] directions = countEyesight(i,pair);
                countingBlindSpot(directions, pair);
            }
        }
        bw.write(String.valueOf(blindSpotCount));

        br.close();
        bw.flush();
        bw.close();
    }
    private static void countingBlindSpot(boolean[] directions, Pair pair){
        for(int i = 0; i < 4; i++){
            if(directions[i]){
                int x = pair.x;
                int y = pair.y;
                while(x >= 0 && x < N && y >= 0 && y < M){
                    if(eyesight[x][y] == 6) break;
                    if(eyesight[x][y] == 0) {
                        eyesight[x][y] = -1;
                        blindSpotCount--;
                    }
                    x += moveX[i];
                    y += moveY[i];
                }
            }
        }
    }

    private static boolean[] countEyesight(int cctvType, Pair pair) {
        int[] directionCount = new int[4];
        boolean[] directions = new boolean[4];
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
            int maxIndex = 0;
            for (int i = 0; i < 4; i++) {
                if(maxEyesight < directionCount[i]){
                    maxEyesight = directionCount[i];
                    maxIndex = i;
                }
            }
            directions[maxIndex] = true;
        }
        if (cctvType == 2) {
            int maxIndex = 0;
            for (int i = 0; i < 2; i++) {
                int sight = directionCount[i] + directionCount[i+2];
                if (maxEyesight < sight) {
                    maxEyesight = sight;
                    maxIndex = i;
                }
            }
            directions[maxIndex] = true;
            directions[maxIndex+2] = true;
        }
        if (cctvType == 3) {
            int maxIndex1 = 0;
            int maxIndex2 = 0;
            int sight = 0;
            int d2 = 0;
            for (int i = 0; i < 4; i++) {
                if(i != 3){
                    sight = directionCount[i] + directionCount[i + 1];
                    d2 = i+1;
                }
                if (i == 3) {
                    sight = directionCount[i] + directionCount[i - 3];
                    d2 = 0;
                }
                if (maxEyesight < sight) {
                    maxEyesight = sight;
                    maxIndex1 = i;
                    maxIndex2 = d2;
                }
            }
            directions[maxIndex1] = true;
            directions[maxIndex2] = true;
        }
        if (cctvType == 4) {
            maxEyesight = directionCount[0] + directionCount[1] + directionCount[2];
            int sight = maxEyesight;
            int[] maxIndex = {0,1,2};
            int indexCount = 0;

            for (int i = 1; i < 4; i++) {
                sight -= directionCount[i-1];
                if(i +2 > 3) {
                    sight += directionCount[i+2-4];
                }
                else {
                    sight += directionCount[i+2];
                }
                if(maxEyesight < sight){
                    maxEyesight = sight;
                    int c = i;
                    indexCount = 0;
                    while(indexCount != 3){
                        if(c > 3){
                            c = 0;
                        }
                        maxIndex[indexCount++] = c;
                        c++;
                    }
                }
            }
            for (int index : maxIndex) {
                directions[index] = true;
            }
        }
        if (cctvType == 5) {
            for (int i = 0; i < 4; i++) {
                directions[i] = true;
            }
        }


        return directions;
    }

    private static int countDirectionEyesight(int d, int x, int y){
        int countE = 0;
        if(d == 0){ // 상
            for(int i = 0; i < x; i++){
                if(eyesight[i][y] == 0) countE++;
                if(eyesight[i][y] == 6) countE = 0;
            }
        }
        if (d == 1) { // 좌
            for (int i = 0; i < y; i++) {
                if(eyesight[x][i] == 0) countE++;
                if(eyesight[x][i] == 6) countE = 0;
            }
        }
        if(d == 2){ // 하
            for (int i = N - 1; i > x; i--) {
                if(eyesight[i][y] == 0) countE++;
                if(eyesight[i][y] == 6) countE = 0;
            }
        }

        if (d == 3) { // 우
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
