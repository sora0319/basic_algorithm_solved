package code;

import java.io.*;
import java.util.*;

public class No_1781 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> lamens = new PriorityQueue<>();
        PriorityQueue<Problem> queue = new PriorityQueue<>((p1, p2) -> {
            if(p1.deadline != p2.deadline){
                return Integer.compare(p1.deadline, p2.deadline);
            }
            else{
                return Integer.compare(p2.count, p1.count);
            }
        });

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Problem problem = new Problem(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            queue.offer(problem);
        }

        int time = 1;
        int totalCount = 0;
        while (time <= N && !queue.isEmpty()) {
            Problem p = queue.poll();
            if (time <= p.deadline) {
                totalCount += p.count;
                lamens.offer(p.count);
                time++;
                continue;
            }

            if(p.count > lamens.peek()){
                totalCount -= lamens.poll();
                totalCount += p.count;
                lamens.offer(p.count);
            }
        }

        bw.write(String.valueOf(totalCount));
        br.close();
        bw.flush();
        bw.close();
    }

    private static class Problem{
        int number;
        int deadline;
        int count;

        Problem(int number, int deadline, int count) {
            this.number = number;
            this.deadline = deadline;
            this.count = count;
        }
    }
}
