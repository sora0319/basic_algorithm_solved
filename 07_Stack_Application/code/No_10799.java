package code;

import java.io.*;
import java.util.*;
public class No_10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character>raser = new Stack<>();
        int count = 0, steal = 0;

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            raser.push(input.charAt(i));
        }

        while (!raser.isEmpty()) {
            char top = raser.pop();
            if(top == ')'){
                if(raser.peek() == ')'){
                    steal++;
                } else {
                    count += steal;
                    raser.pop();
                }
            } else if (top == '(') {
                count++;
                steal--;
            }
        }
        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }
}