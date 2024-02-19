package code;

import java.io.*;
import java.util.*;

public class No_13549 {
    static int[] dx = {-1, 1};
    static int s, target;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        int MAX = end * 2;
        int[] time = new int[MAX];

        queue.offer(start);
        time[start] = 1;
        while (!queue.isEmpty()) {
            s = queue.poll();
            if(s == end) break;

            target = s * 2;

            while (0 < target && target < MAX) {
                if(time[target] <= 0) {
                    queue.offer(target);
                    time[target] = time[s];
                }
                if(target == end) {
                    queue.clear();
                    break;
                }
                target = target * 2;
            }

            for (int i = 0; i < 2; i++) {
                target = s + dx[i];
                if(target >= MAX || target < 0) continue;
                if(time[target] > 0) continue;
                queue.offer(target);
                time[target] = time[s] + 1;
                if(target == end){
                    queue.clear();
                    break;
                }
            }
        }
        bw.write(String.valueOf(time[end] - 1));

        br.close();
        bw.flush();
        bw.close();
    }
}
