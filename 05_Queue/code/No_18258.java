package code;

import java.util.*;
import java.io.*;
public class No_18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new ArrayDeque<>();

        int repeat = Integer.parseInt(br.readLine());
        for (int i = 0; i < repeat; i++) {
            String[] inputs = br.readLine().split(" ");
            if(inputs[0].equals("push")){
                int num = Integer.parseInt(inputs[1]);
                queue.offer(num);
            } else if (inputs[0].equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(queue.poll()));
                }
            } else if (inputs[0].equals("size")) {
                bw.write(String.valueOf(queue.size()));
            } else if (inputs[0].equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
            } else if (inputs[0].equals("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1");
                } else{
                    bw.write(String.valueOf(queue.peek()));
                }
            } else if (inputs[0].equals("back")) {
                if (queue.isEmpty()) {
                    bw.write("-1");
                } else{
                    bw.write(String.valueOf(queue.peekLast()));
                }
            }
            if (!inputs[0].equals("push")) {
                bw.write(System.lineSeparator());
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}