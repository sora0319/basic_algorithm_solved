package code;

import java.io.*;
import java.util.*;

public class No_1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            queue.offer(n);

            int calledSize = queue.size();
            if(calledSize == 1){
                bw.write(String.valueOf(queue.peek()));
                bw.newLine();
                continue;
            }

            Iterator<Integer> copied = queue.iterator();
            int count = calledSize / 2;
            if(calledSize % 2 == 1){
                count += 1;
            }
            while(copied.hasNext()){
                int middle = copied.next();
                if(count == 1){
                    bw.write(String.valueOf(middle));
                    bw.newLine();
                    break;
                }
                count--;
            }
        }



        br.close();
        bw.flush();
        bw.close();
    }
}
