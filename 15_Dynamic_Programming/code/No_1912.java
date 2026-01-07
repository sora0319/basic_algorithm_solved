package code;

import java.io.*;
import java.util.*;

public class No_1912 {

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] linkedSum;

        int N = Integer.parseInt(br.readLine());
        linkedSum = new int[N];
        String[] inputs = br.readLine().split(" ");
        int maxLinkedSum = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(inputs[i]);
            if(i == 0){
                linkedSum[i] = n;
                maxLinkedSum = n;
                continue;
            }

            linkedSum[i] = Math.max(n, n + linkedSum[i - 1]);
            maxLinkedSum = Math.max(maxLinkedSum, linkedSum[i]);
        }

        bw.write(String.valueOf(maxLinkedSum));
        br.close();
        bw.flush();
        bw.close();
    }
}
