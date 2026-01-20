package code;

import java.util.*;
import java.io.*;

public class No_1715 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Long> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());
            queue.offer(card);
        }

        long totalCompare = 0;
        while(queue.size() >= 2){
            long comparedCard = queue.poll() + queue.poll();
            totalCompare += comparedCard;
            queue.offer(comparedCard);
        }

        bw.write(String.valueOf(totalCompare));
        br.close();
        bw.flush();
        bw.close();
    }
}
