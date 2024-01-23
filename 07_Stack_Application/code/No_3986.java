package code;

import java.io.*;
import java.util.*;
public class No_3986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character>goodWord = new Stack<>();
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (goodWord.isEmpty() || goodWord.peek() != input.charAt(j)) {
                    goodWord.push(input.charAt(j));
                } else if (goodWord.peek() == input.charAt(j)) {
                    goodWord.pop();
                }
            }
            if (goodWord.isEmpty()) {
                count++;
            }
            goodWord.clear();
        }
        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }
}