package basic_codeII.code;

import java.io.*;

public class No_2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = N; i >= 1; i--){
            for(int j = 1; j <= N-i; j++){
                bw.write(" ");
            }
            for(int j = 1; j <= i*2-1; j++){
                bw.write("*");
            }
            bw.write("\n");
        }

        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= N-i; j++){
                bw.write(" ");
            }
            for(int j = 1; j <= i*2-1; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

