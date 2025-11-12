package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class No_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] coins;
        int usedCoin = 0;
        int count = 0;

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());

            if (coins[i] <= K) {
                usedCoin = i;
            }
        }

        int money = K;
        while (money > 0) {
            count += money / coins[usedCoin];
            money %= coins[usedCoin--];
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }
}
