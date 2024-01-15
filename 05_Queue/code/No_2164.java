package code;
import java.io.*;
import java.util.*;
public class No_2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> card = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            card.offer(i);
        }

        while (card.size() > 1) {
            card.poll();
            card.offer(card.poll());
        }

        bw.write(String.valueOf(card.peek()));

        br.close();
        bw.flush();
        bw.close();
    }
}