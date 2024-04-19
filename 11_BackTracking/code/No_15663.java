package code;

import java.io.*;
import java.util.*;
public class No_15663 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[] numbers, sequence;
    private static boolean[] used;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        sequence = new int[M];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        createSeq(0);

        br.close();
        bw.flush();
        bw.close();
    }
    private static void createSeq(int order) throws IOException{
        if (order == M) {
            for (int i : sequence) {
                bw.write(String.valueOf(i));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!used[i] && sequence[order] != numbers[i]){
                used[i] = true;
                sequence[order] = numbers[i];
                createSeq(order + 1);
                used[i] = false;
            }
        }
        sequence[order] = 0;
    }
}