package basic_codeII;

import java.io.*;
import java.util.*;

public class No_2309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] men = new int[9];

        int tot_sum = 0;
        for(int i = 0; i < 9; i++){
            men[i] = Integer.parseInt(br.readLine());
            tot_sum += men[i];
        }

        Arrays.sort(men);

        int[] f = new int[2];
        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++){
                if(tot_sum - men[i] - men[j] == 100){
                    f[0] = i;
                    f[1] = j;
                    break;
                }
            }
        }

        boolean same = false;
        for(int i = 0; i < 9; i++){
            for(int false_men : f){
                if(men[false_men] == men[i]){
                    same = true;
                    break;
                }
            }
            if(!same){
                bw.write(String.valueOf(men[i]));
                bw.write("\n");
            }
            same = false;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
