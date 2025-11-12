package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No_1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        String[] inputs = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            A[j] = Integer.parseInt(inputs[j]);
        }

        inputs = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            B[j] = Integer.parseInt(inputs[j]);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += A[i] * B[N - 1 - i];
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.flush();
        bw.close();
    }

}
