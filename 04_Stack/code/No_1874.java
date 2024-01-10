package code;

import java.io.*;
import java.util.*;
public class No_1874 {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> sequence = new Stack<>();
        List<String> ans = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int pushNumber = 1;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            while(true){
                if(sequence.isEmpty() || sequence.peek() < number){
                    sequence.push(pushNumber++);
                    ans.add("+");
                }
                else if(sequence.peek() == number){
                    sequence.pop();
                    ans.add("-");
                    break;
                }
                else if(sequence.peek() > number){
                    pushNumber = -1;
                    break;
                }
            }
            if(pushNumber == -1) {
                break;
            }
        }

        if(pushNumber == -1){
            bw.write("NO");
        }
        else{
            for(String s : ans){
                bw.write(s);
                bw.write(System.lineSeparator());
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
