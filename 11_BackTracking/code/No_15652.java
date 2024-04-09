package code;

import java.io.*;
import java.util.*;
public class No_15652 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[] sequence;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequence = new int[M];

        createSubSeq(0,1);

        br.close();
        bw.flush();
        bw.close();
    }
    private static void createSubSeq(int order, int start) throws IOException{
        if (order == M) {
            for (int i : sequence) {
                bw.write(String.valueOf(i));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }
        for (int i = start; i <= N; i++) {
            sequence[order] = i;
            createSubSeq(order + 1, i);
        }
    }
}
