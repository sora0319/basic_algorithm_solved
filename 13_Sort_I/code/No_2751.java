package code;

import java.io.*;
import java.util.*;
public class No_2751 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        for(int n : numbers){
            bw.write(String.valueOf(n));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
