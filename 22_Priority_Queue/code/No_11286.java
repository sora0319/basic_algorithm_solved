package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class No_11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> {
            int c = Integer.compare(Math.abs(n1), Math.abs(n2));
            return c != 0 ? c : Integer.compare(n1, n2);
        });

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                if(queue.isEmpty()){
                    bw.write("0");
                    bw.newLine();
                    continue;
                }
                bw.write(String.valueOf(queue.poll()));
                bw.newLine();
                continue;
            }

            queue.offer(n);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
