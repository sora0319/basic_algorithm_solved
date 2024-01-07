package code;

import java.io.*;
import java.util.*;
public class No_1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> numbers = new LinkedList<>();

        String[] orders = br.readLine().split((" "));
        int totalNum = Integer.parseInt(orders[0]);
        int targetNum = Integer.parseInt(orders[1]);

        for(int i = 1; i <= totalNum; i++){
            numbers.add(i);
        }

        ListIterator<Integer> iter = numbers.listIterator();;
        int target = 0;
        bw.write("<");
        while (!numbers.isEmpty()) {
            for(int i = 0; i < targetNum; i++){
                if (iter.hasNext()) {
                    target = iter.next();
                }
                else{
                    iter = numbers.listIterator();
                    target = iter.next();
                }
                if (i == targetNum - 1) {
                    iter.remove();
                }
            }
            bw.write(String.valueOf(target));
            if(!numbers.isEmpty()){
                bw.write(", ");
            }
        }
        bw.write(">");

        br.close();
        bw.flush();
        bw.close();
    }
}
