package code;

import java.io.*;
import java.util.*;
public class No_15650 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] sequence;
    private static int N, M;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequence = new int[M];

        createSequence(0,1);

        br.close();
        bw.flush();
        bw.close();
    }
    private static void createSequence(int total, int start) throws IOException{
        if(total == M){
            for (int i : sequence) {
                bw.write(String.valueOf(i));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }
        for (int i = start; i <= N; i++) {
            sequence[total] = i;
            createSequence(total+1, i+1);
        }
    }
}
