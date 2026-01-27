package code;

import java.io.*;
import java.util.*;

public class No_2467 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] liquids = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1, end = N;
        int middleStatus = Integer.MAX_VALUE;
        int[] choosen = new int[2];
        int mixed = 0;
        while (start < end) {
            mixed = liquids[start] + liquids[end];

            if (Math.abs(middleStatus) > Math.abs(mixed)) {
                middleStatus = mixed;
                choosen[0] = liquids[start];
                choosen[1] = liquids[end];
            }

            if(mixed == 0){
                break;
            }

            if(mixed < 0){
                start++;
                continue;
            }

            end--;
        }

        bw.write(String.valueOf(choosen[0]));
        bw.write(" " + String.valueOf(choosen[1]));

        br.close();
        bw.flush();
        bw.close();
    }
}
