package code;

import java.io.*;
import java.util.*;
public class No_11931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> numbers = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            numbers.add(Integer.parseInt(br.readLine()));
        }

        numbers.sort(Collections.reverseOrder());

        for (int n : numbers) {
            bw.write(String.valueOf(n));
            bw.newLine();
        }


        br.close();
        bw.flush();
        bw.close();
    }

}
