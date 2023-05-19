package basic_codeII.code;

import java.io.*;
import java.util.*;

public class No_10093 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");

        long[] gap = new long[2];
        for(int i = 0; i < 2; i++){
            gap[i] = Long.parseLong(temp[i]);
        }

        Arrays.sort(gap);
        if (gap[1] - gap[0] - 1 <= 0){
            bw.write("0");
            bw.write("\n");
        }
        else{
            bw.write(String.valueOf(gap[1] - gap[0] - 1));
            bw.write("\n");

            for(long i = gap[0]+1; i < gap[1]; i++){
                bw.write(String.valueOf(i));
                bw.write(" ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
