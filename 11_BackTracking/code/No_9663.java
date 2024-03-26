package code;

import java.io.*;
public class No_9663 {
    private static boolean[] col, left_Diagonal, right_Diagonal;
    private static int N;
    private static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        left_Diagonal = new boolean[N*2-1];
        right_Diagonal = new boolean[N * 2 - 1];

        seqeunce(0);
        bw.write(Integer.toString(count));

        br.close();
        bw.flush();
        bw.close();
    }
    private static void seqeunce(int k){
        if(k == N){
            count++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(col[i] || left_Diagonal[k+i] || right_Diagonal[k-i+N-1]) continue;
            col[i] = true;
            left_Diagonal[k+i] = true;
            right_Diagonal[k-i+N-1] = true;
            seqeunce(k+1);
            col[i] = false;
            left_Diagonal[k+i] = false;
            right_Diagonal[k-i+N-1] = false;
        }
    }
}
