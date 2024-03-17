package code;

import java.io.*;

public class No_1992 {
    private static int[][] video;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        String temp;
        for (int i = 0; i < N; i++) {
           temp = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
        compression(0,0,N);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void compression(int row, int col, int size) throws IOException{
        boolean same = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (video[row][col] != video[i][j]) {
                    same = false;
                    break;
                }
            }
            if(!same) break;
        }

        if (!same) {
            bw.write("(");
            int nSize = size / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    compression(row + i * nSize, col + j * nSize, nSize);
                }
            }
            bw.write(")");
        } else {
            bw.write(String.valueOf(video[row][col]));
        }
    }
}
