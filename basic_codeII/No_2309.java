package basic_codeII;

import java.io.*;
import java.util.*;

public class No_2309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] men = new int[10];
        int[] tot_sum = new int[11];

        for(int i = 0; i < 10; i++){
            men[i] = Integer.parseInt(br.readLine());
            tot_sum[i] = men[i];
        }
        Arrays.sort(men);
        bw.write("\n");
        bw.close();
        br.close();
    }
}
