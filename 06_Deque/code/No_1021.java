package code;

import java.io.*;
public class No_1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int MX = 2500;
        int[] deque = new int[MX];

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        String[] cards = br.readLine().split(" ");

        int head = MX/2+1, tail = head + N;
        for(int i = 1; i <= N; i++){
            deque[head+i-1] = i;
        }

        int target = 0;
        int count = 0;

        for(int i = 0; i < M; i++){
            int n = Integer.parseInt(cards[i]);
            for(int j = head; j < tail; j++){
                if (deque[j] == n) {
                    target = j;
                    break;
                }
            }
            if(tail - target >= target - head){
                while(target > head){ //2번 방식
                    deque[tail++] = deque[head];
                    head++;
                    count++;
                }
            } else{ // 3번 방식
                while (target < tail) {
                    deque[--head] = deque[tail-1];
                    tail--;
                    count++;
                }
            }
            head++;
        }

        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
}
