package code;

import java.io.*;
import java.util.*;

public class No_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer>tower = new Stack<>();
        Stack<Integer>space = new Stack<>();

        int repeat = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < repeat; i++) {
            int t = Integer.parseInt(inputs[i]);

            while(!tower.isEmpty()){
                if(tower.peek() >= t){
                    bw.write(String.valueOf(space.peek()) + " ");
                    tower.push(t);
                    space.push(i+1);
                    break;
                }
                else{
                    tower.pop();
                    space.pop();
                }
            }
            if(tower.isEmpty()){
                tower.push(t);
                space.push(i+1);
                bw.write("0" + " ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
