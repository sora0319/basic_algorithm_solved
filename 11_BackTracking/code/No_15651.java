package code;

import java.io.*;
import java.util.*;
public class No_15651 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[] sequence;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequence = new int[M];

        createSubSeq(0);

        br.close();
        bw.flush();
        bw.close();
    }
    private static void createSubSeq(int repeat) throws IOException{
        if(repeat == M){
            for (int i : sequence) {
                bw.write(String.valueOf(i));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }
        for (int i = 1; i <= N; i++) {
            sequence[repeat] = i;
            createSubSeq(repeat+1);
        }
    }
}