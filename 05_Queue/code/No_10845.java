package code;

import java.io.*;
import java.util.*;
public class No_10845 {
    static int [] queue = new int[10001];
    static int head, tail = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0; i < repeat; i++){
            String[] inputs = br.readLine().split(" ");
            if(inputs[0].equals("push")){
                int num = Integer.parseInt(inputs[1]);
                push(num);
            } else if (inputs[0].equals("pop")) {
                bw.write(String.valueOf(pop()));
            } else if (inputs[0].equals("size")) {
                bw.write(String.valueOf(size()));
            } else if (inputs[0].equals("empty")) {
                bw.write(String.valueOf(empty()));
            } else if (inputs[0].equals("front")) {
                bw.write(String.valueOf(front()));
            } else if (inputs[0].equals("back")) {
                bw.write(String.valueOf(back()));
            }
            if (!inputs[0].equals("push")) {
                bw.write(System.lineSeparator());
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void push(int num){
        queue[tail++] = num;
    }
    public static int pop(){
        if(size() > 0){
            return queue[head++];
        }
        return -1;
    }
    public static int size(){
        return tail - head;
    }
    public static int empty(){
        if(size() > 0){
            return 0;
        }
        return 1;
    }
    public static int front(){
        if(size() > 0){
            return queue[head];
        }
        return -1;
    }

    public static int back() {
        if(size() > 0){
            return queue[tail-1];
        }
        return -1;
    }
}