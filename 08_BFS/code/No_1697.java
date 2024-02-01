package code;

import java.io.*;
import java.util.*;
public class No_1697 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int[]space = new int[150000];

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        queue.offer(N);
        space[N] = 1;
        if (N != K) {
            while (!queue.isEmpty()) {
                int spot = queue.poll();
                for (int cal : new int[]{spot - 1, spot + 1, 2 * spot}) {
                    if (cal >= 150000 || cal < 0) continue;
                    if (space[cal] > 0) continue;
                    space[cal] = space[spot] + 1;
                    if (cal == K) break;
                    queue.offer(cal);
                }
                if (space[K] > 0) break;
            }
        }
        bw.write(String.valueOf(space[K] - 1));

        br.close();
        bw.flush();
        bw.close();
    }
}