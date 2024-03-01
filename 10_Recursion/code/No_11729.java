package code;

import java.io.*;
import java.util.*;

public class No_11729 {
    private static int MAX = 6;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int K = Integer.parseInt(br.readLine());
        int moving = (1 << K) - 1;
        bw.write(String.valueOf(moving));
        bw.newLine();
        hanoi(K, 1, 3);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void hanoi(int turn, int start, int end) throws IOException {
        if(turn == 0) return;
        hanoi(turn - 1, start, MAX - start - end);
        bw.write(String.valueOf(start));
        bw.write(" ");
        bw.write(String.valueOf(end));
        bw.newLine();
        hanoi(turn - 1, MAX - start - end, end);
    }
}