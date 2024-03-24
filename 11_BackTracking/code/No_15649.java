package code;

import java.io.*;
import java.util.*;
public class No_15649 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] printArr;
    private static boolean[] isUsed;
    private static int N, M;


    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        printArr = new int[M];
        isUsed = new boolean[N+1];

        sequence(0);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sequence(int k) throws IOException{
        if(k == M){
            for(int i : printArr){
                bw.write(Integer.toString(i));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!isUsed[i]){
                printArr[k] = i;
                isUsed[i] = true;
                sequence(k+1);
                isUsed[i] = false;
            }
        }
    }
}
