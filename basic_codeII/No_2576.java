package basic_codeII;

import java.io.*;

public class No_2576 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int odd = 101;
        int sum = 0;

        for(int i = 0; i < 7; i++){
            int n = Integer.parseInt(br.readLine());
            if(n % 2 != 0){
                sum += n;
                if(n < odd){
                    odd = n;
                }
            }
        }

        if(sum == 0){
            bw.write("-1");
        }
        else{
            bw.write(String.valueOf(sum));
            bw.write("\n");
            bw.write(String.valueOf(odd));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
