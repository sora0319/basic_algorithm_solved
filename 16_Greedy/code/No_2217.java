package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> rope = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            rope.add(Integer.parseInt(br.readLine()));
        }

        rope.sort(Comparator.reverseOrder());

        int k = 0;
        int max_weight = 0;
        for (int i = 0; i < N; i++) {
            ++k;
            max_weight = Math.max(max_weight, rope.get(i) * k);
        }

        bw.write(String.valueOf(max_weight));
        br.close();
        bw.flush();
        bw.close();
    }

}
