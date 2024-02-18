package code;

import java.io.*;
import java.util.*;
public class No_2146 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int MAX = 100;
    static String[] inputs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] dis = new int[N][N];

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                dis[i][j] = MAX;
            }
        }

        


        br.close();
        bw.flush();
        bw.close();
    }

    static class Pair{
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
