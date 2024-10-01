package code;

import java.io.*;
import java.util.*;
public class No_11656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int end = input.length();
        List<String> prefix = new ArrayList<>(end);

        for (int i = 0; i < input.length(); i++) {
            prefix.add(input.substring(i));
        }

        Collections.sort(prefix);

        for (String s : prefix) {
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
