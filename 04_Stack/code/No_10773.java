package code;

import java.io.*;
import java.util.*;
public class No_10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> money = new Stack<>();
        int totalMoney = 0;

        int repeat = Integer.parseInt(br.readLine());
        for (int i = 0; i < repeat; i++) {
            int m = Integer.parseInt(br.readLine());
            if(m >0){
                money.push(m);
            }
            else{
                money.pop();
            }
        }

        if (!money.isEmpty()) {
            for (int c : money) {
                totalMoney += c;
            }
        }
        bw.write(String.valueOf(totalMoney));

        br.close();
        bw.flush();
        bw.close();
    }
}
