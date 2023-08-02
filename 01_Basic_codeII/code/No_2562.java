package basic_codeII.code;

import java.io.*;

public class No_2562 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int order = 0;

        for(int i = 1; i < 10; i++){
            int n = Integer.parseInt(br.readLine());
            if(max < n){
                max = n;
                order = i;
            }
        }

        bw.write(String.valueOf(max));
        bw.write("\n");
        bw.write(String.valueOf(order));

        bw.flush();
        bw.close();
        br.close();
    }
}
