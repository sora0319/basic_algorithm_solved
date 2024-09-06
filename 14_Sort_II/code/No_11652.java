package code;

import java.io.*;
import java.util.*;
public class No_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] numbers = new long[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(numbers);


        long min = numbers[0];
        long answer = min;
        int answerCount = 1;
        int count = 1;
        for (int i = 1; i < N; i++) {
            if(min == numbers[i]) count++;
            if (min < numbers[i]) {
                if(answerCount < count){
                    answerCount = count;
                    answer = min;
                }
                count = 1;
                min = numbers[i];
            }
        }

        if(answer < min && answerCount < count){
            answer = min;
        }

        bw.write(String.valueOf(answer));


        br.close();
        bw.flush();
        bw.close();
    }
}
