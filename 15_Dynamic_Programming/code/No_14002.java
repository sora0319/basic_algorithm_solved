package code;

import java.util.*;
import java.io.*;

public class No_14002 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> linkedCount = new HashMap<>();
        Map<Integer, Integer> subsequence = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(inputs[i]);

            int maxLinkedValue = 0;
            int maxLinkedKey = 0;
            for (int k : linkedCount.keySet()) {
                if (n > k && maxLinkedValue < linkedCount.get(k)) {
                    maxLinkedKey = k;
                    maxLinkedValue = linkedCount.get(k);
                }
            }

            linkedCount.put(n, maxLinkedValue + 1);
            subsequence.put(n, maxLinkedKey);
        }

        int maxLinked = 0;
        int maxKey = 0;
        for (int k : linkedCount.keySet()) {
            if (maxLinked < linkedCount.get(k)) {
                maxLinked = linkedCount.get(k);
                maxKey = k;
            }
        }
        bw.write(String.valueOf(maxLinked));
        bw.newLine();

        Stack<Integer> stack = new Stack<>();
        while (maxKey != 0) {
            stack.push(maxKey);
            maxKey = subsequence.get(maxKey);
        }

        while (!stack.isEmpty()) {
            bw.write(String.valueOf(stack.pop()));
            bw.write(" ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
