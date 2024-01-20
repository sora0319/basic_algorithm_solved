package code;
import java.io.*;
import java.util.*;
public class No_5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer>deque = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());
        int n;

        while(T-- > 0){
            String order = br.readLine();
            n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            if(n >0) {
                String[] inputs = input.replaceAll("[^0-9,]", "").split(",");
                for (String s : inputs) {
                    deque.offer(Integer.parseInt(s));
                }
            }

            boolean forward = true;
            boolean error = false;
            for (int i = 0; i < order.length(); i++) {
                if (order.charAt(i) == 'R') {
                    forward = !forward;
                } else if (order.charAt(i) == 'D') {
                    if(deque.peek() == null){
                        error = true;
                        break;
                    }
                    if(forward){
                        deque.pollFirst();
                    }
                    else{
                        deque.pollLast();
                    }
                }
            }

            if (!error) {
                bw.write("[");
                while(deque.size() >1 ) {
                    if (forward) {
                        bw.write(String.valueOf(deque.pollFirst()));
                    } else {
                        bw.write(String.valueOf(deque.pollLast()));
                    }
                    bw.write(",");
                }
                if (!deque.isEmpty()) {
                    bw.write(String.valueOf(deque.poll()));
                }

                bw.write("]");
                bw.newLine();
            } else {
                bw.write("error");
                bw.newLine();
            }


            deque.clear();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
