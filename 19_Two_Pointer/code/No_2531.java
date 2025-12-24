package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class No_2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> combination;

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int d = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);
        int c = Integer.parseInt(inputs[3]);

        int[] dishes = new int[N + 1];

        for (int i = 0; i < N; i++) {
            dishes[i + 1] = Integer.parseInt(br.readLine());
        }

        int start = 1, end = start + k;
        int max_Count = 0;

        LinkedList<Integer> paid = new LinkedList<>();
        for (int i = start; i < end; i++) {
            paid.add(dishes[i]);
        }

        while (start <= N) {
            combination = new HashSet<>(paid);
            combination.add(c);

            if(combination.size() > max_Count){
                max_Count = combination.size();
            }

            paid.removeFirst();
            paid.add(dishes[end]);

            start++;
            end++;
            if(end == N+1) end = 1;
        }

        bw.write(String.valueOf(max_Count));
        br.close();
        bw.flush();
        bw.close();
    }

}
