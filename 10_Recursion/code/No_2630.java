package code;

import java.io.*;
import java.util.StringTokenizer;

public class No_2630 {
    private static int[][] paper;
    private static int[] answer = new int[2]; // white : 0, blue : 1
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutting(0,0,N);

        for (int i : answer) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void cutting(int row, int col, int size) {
        boolean same = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[row][col] != paper[i][j]) {
                    same = false;
                    break;
                }
            }
            if(!same) break;
        }

        if (!same) {
            int nSize = size / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    cutting(row + i * nSize, col + j * nSize, nSize);
                }
            }
        } else {
            answer[paper[row][col]]++;
        }
    }
}
