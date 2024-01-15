package code;

import java.io.*;
public class No_10866 {
    static int MX = 10000;
    static int[] deque = new int[2*MX + 1];
    static int head = MX, tail = MX;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] inputs = br.readLine().split(" ");
            switch (inputs[0]) {
                case "push_front":
                    int n = Integer.parseInt(inputs[1]);
                    push_front(n);
                    break;
                case "push_back":
                    int num = Integer.parseInt(inputs[1]);
                    push_back(num);
                    break;
                case "pop_front":
                    bw.write(String.valueOf(pop_front()));
                    break;
                case "pop_back":
                    bw.write(String.valueOf(pop_back()));
                    break;
                case "size":
                    bw.write(String.valueOf(size()));
                    break;
                case "empty":
                    if(empty()){
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                    break;
                case "front":
                    bw.write(String.valueOf(front()));
                    break;
                case "back":
                    bw.write(String.valueOf(back()));
                    break;
            }
            if(!inputs[0].contains("push")){
                bw.newLine();
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void push_front(int n){
        deque[--head] = n;
    }

    public static void push_back(int n) {
        deque[tail++] = n;
    }

    public static int pop_front(){
        if(empty()){
            return -1;
        }
        return deque[head++];
    }

    public static int pop_back() {
        if(empty()){
            return -1;
        }
        return deque[--tail];
    }

    public static int size() {
        return tail - head;
    }

    public static boolean empty() {
        return size() == 0;
    }

    public static int front() {
        if(empty()){
            return -1;
        }
        return deque[head];
    }

    public static int back() {
        if(empty()){
            return -1;
        }
        return deque[tail-1];
    }
}