package code;
import java.io.*;
import java.util.*;
public class No_1182 {
    private static int N, S;
    private static int sum = 0, count = 0;
    private static int[] numbers;
    private static boolean[] used;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        subsequence(0);
        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }
    private static void subsequence(int k) {
        if(k == N){
            return;
        }
        for(int i = k; i < N; i++){
            if (!used[i]) {
                sum += numbers[i];
                if(sum == S) count++;
                used[i] = true;
                subsequence(i+1);
                used[i] = false;
                sum -= numbers[i];
            }
        }
    }
}
