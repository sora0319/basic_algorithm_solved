package code;

import java.io.*;
import java.util.StringTokenizer;

public class No_11728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num1 = new int[N];
        int[] num2 = new int[M];
        int[] conquerNumbers = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            num2[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0, k = 0;
        while(l < N && r < M){
            if(num1[l] <= num2[r]){
                conquerNumbers[k++] = num1[l++];
            }
            else {
                conquerNumbers[k++] = num2[r++];
            }
        }

        while(l < N) {
            conquerNumbers[k++] = num1[l++];

        }

        while(r < M) {
            conquerNumbers[k++] = num2[r++];

        }

        for (int n : conquerNumbers) {
            bw.write(String.valueOf(n));
            bw.write(" ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
