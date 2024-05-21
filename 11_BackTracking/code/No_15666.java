package code;
import java.io.*;
import java.util.*;
public class No_15666 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[] numbers, sequence;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        sequence = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        createSeq(0,0);

        br.close();
        bw.flush();
        bw.close();
    }
    private static void createSeq(int order, int start) throws IOException{
        if(order == M){
            for (int n : sequence) {
                bw.write(String.valueOf(n));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }

        for(int i = start; i < N; i++) {
            if (sequence[order] != numbers[i]) {
                sequence[order] = numbers[i];
                createSeq(order + 1, i);
            }
        }
    }
}
