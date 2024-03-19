package code;

import java.io.*;
public class No_2477 {
    private static char[][] stars;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N];

        drawing(0,0,N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(stars[i][j]);
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
    private static void drawing(int row, int col, int size){
        if(size == 3){
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    if (i == row + 1 && j == col + 1) {
                        spacing(row + 1, col + 1, 1);
                    } else{
                        stars[i][j] = '*';
                    }
                }
            }
        }
        if(size > 3){
            int nSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        spacing(row + i * nSize, col + j * nSize, nSize);
                    } else {
                        drawing(row + i * nSize, col + j * nSize, nSize);
                    }

                }
            }
        }
    }

    private static void spacing(int row, int col, int size){
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                stars[i][j] = ' ';
            }
        }
    }
}