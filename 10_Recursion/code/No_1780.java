package code;

import java.io.*;
import java.util.StringTokenizer;

public class No_1780 {
    private static int zero = 0;
    private static int one = 0;
    private static int minusOne = 0;
    private static int[][] paper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        counting(1, N, 1, N);
        bw.write(String.valueOf(minusOne));
        bw.newLine();
        bw.write(String.valueOf(zero));
        bw.newLine();
        bw.write(String.valueOf(one));
        bw.newLine();


        br.close();
        bw.flush();
        bw.close();
    }
    private static void counting(int row_S, int row_E, int col_S, int col_E) {
        boolean same = true;
        for (int i = row_S; i <= row_E; i++) {
            for (int j = col_S; j < col_E; j++) {
                if (paper[i][j] != paper[i][j + 1]) {
                    same = false;
                    break;
                }
            }
            if(!same) break;
        }

        if(!same){
            int gap = (row_E - row_S + 1) / 3;
            for (int i = row_S - 1; i < row_E; i += gap) {
                for (int j = col_S - 1; j < col_E; j += gap) {
                    counting(i+1, i+gap, j+1, j+gap);
                }
            }
        }
        if (same) {
            if (paper[row_S][col_S] == 0) {
                zero++;
            }
            if (paper[row_S][col_S] == 1) {
                one++;
            }
            if (paper[row_S][col_S] == -1) {
                minusOne++;
            }
        }
    }
}
