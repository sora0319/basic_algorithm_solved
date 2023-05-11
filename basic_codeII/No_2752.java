package basic_codeII;

import java.io.*;
import java.util.*;

public class No_2752 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++){
            numbers[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(numbers);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int n : numbers){
            bw.write(String.valueOf(n));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
