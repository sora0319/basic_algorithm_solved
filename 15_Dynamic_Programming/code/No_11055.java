package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class No_11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer,Integer> sums = new HashMap<>();
        int maxSum = 0;

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(inputs[i]);

            sums.put(n, n);
            int maxSubValue = 0;
            for (int k : sums.keySet()) {
                if (n > k && maxSubValue < sums.get(k)) {
                    maxSubValue = sums.get(k);
                }
            }

            if (maxSubValue != 0) {
                sums.put(n, maxSubValue + n);
            }
        }

        for (int k : sums.keySet()) {
            maxSum = Math.max(maxSum, sums.get(k));
        }

        bw.write(String.valueOf(maxSum));

        br.close();
        bw.flush();
        bw.close();
    }

}
