package code;

import java.io.*;
public class No_15688 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] negativeInt = new int[1_000_001];
        int[] positiveInt = new int[1_000_001];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n <= 0) {
                negativeInt[-n]++;
            }
            else{
                positiveInt[n]++;
            }
        }

        for (int i = 1_000_000; i >= 0; i--) {
            if (negativeInt[i] != 0) {
                for (int j = 0; j < negativeInt[i]; j++) {
                    bw.write(String.valueOf(-i));
                    bw.newLine();
                }
            }
        }

        for (int i = 1; i < 1_000_001; i++) {
            if (positiveInt[i] != 0) {
                for (int j = 0; j < positiveInt[i]; j++) {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
