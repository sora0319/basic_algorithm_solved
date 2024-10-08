package code;

import java.io.*;
import java.util.*;
public class No_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            List<Integer>A = new ArrayList<>();
            List<Integer>B = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(A);
            Collections.sort(B);

            bw.write(String.valueOf(compareGroup(A,B,N,M)));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int compareGroup(List<Integer> A, List<Integer> B, int N, int M) {
        int count = 0;
        int a = 0;
        int b = 0;

        while (a < N && b < M) {
            if(A.get(a) > B.get(b)){
                count += (N-a);
                b++;
            }
            else if (A.get(a) <= B.get(b)) {
                a++;
            }
        }
        return count;
    }
}
