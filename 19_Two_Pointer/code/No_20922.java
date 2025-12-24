package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numberCounts = new int[100001];

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int[] numbers = new int[N+1];
        int start = 1, end = 1;

        inputs = br.readLine().split(" ");
        for (int i = 1; i < N + 1; i++) {
            numbers[i] = Integer.parseInt(inputs[i - 1]);
        }

        int maxLength = 0;
        while( end <= N){
            numberCounts[numbers[end]]++;

            while(numberCounts[numbers[end]] > K){
                numberCounts[numbers[start++]]--;
            }
            if(end - start + 1 > maxLength){
                maxLength = end - start + 1;
            }
            end++;
        }

        bw.write(String.valueOf(maxLength));
        br.close();
        bw.flush();
        bw.close();
    }

}
