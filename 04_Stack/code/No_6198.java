package code;

import java.io.*;
import java.util.*;
public class No_6198 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer>height = new Stack<>();

        int repeat = Integer.parseInt(br.readLine());
        long count = 0;

        for(int i = 0; i < repeat; i++){
            int garden = Integer.parseInt(br.readLine());
            while(!height.isEmpty() && height.peek() <= garden){
                height.pop();
            }
            count += height.size();
            height.push(garden);
        }
        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
}
