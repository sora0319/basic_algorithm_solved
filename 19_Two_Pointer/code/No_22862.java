package code;

import java.util.*;
import java.io.*;
public class No_22862 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int[] numbers = new int[N];
        int[] visitedOdd = new int[N];

        inputs = br.readLine().split(" ");
        int oddCount = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
            if(numbers[i] % 2 == 0){
                visitedOdd[i] = oddCount;
                continue;
            }
            oddCount++;
        }

        int start = 0, end = 0;
        int evenCount = 0;
        int maxSubLength = 0;
        while (end < N && start < N) {
            if (numbers[start] % 2 != 0) {
                start++;
                continue;
            }

            if(end < start){
                end = start;
            }
            if(numbers[end] % 2 == 0){
                if(visitedOdd[end] - visitedOdd[start] > K){
                    start++;
                    continue;
                }
                evenCount = end - start + 1 - (visitedOdd[end] - visitedOdd[start]);
                if(maxSubLength < evenCount){
                    maxSubLength = evenCount;
                }
            }
            end++;
        }

        bw.write(String.valueOf(maxSubLength));
        br.close();
        bw.flush();
        bw.close();
    }
}
