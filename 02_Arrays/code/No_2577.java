package Arrays.code;

import java.io.*;

public class No_2577 {
    public static void main(String[] args)throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[10];

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int result = A * B * C;
        char[] changeNumber = String.valueOf(result).toCharArray();

        for(char c : changeNumber){
            numbers[c - '0'] += 1;
        }

        for(int n : numbers){
            bw.write(String.valueOf(n));
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
