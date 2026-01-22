package code;

import java.io.*;
import java.util.*;

public class No_13975 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                long chapter = Long.parseLong(st.nextToken());
                queue.offer(chapter);
            }

            long totalCost = 0;
            while (queue.size() >= 2) {
                long cost = queue.poll() + queue.poll();
                totalCost += cost;
                queue.offer(cost);
            }

            bw.write(String.valueOf(totalCost));
            bw.newLine();
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
