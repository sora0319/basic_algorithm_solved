package code;

import java.io.*;
public class No_1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int[] dpArray = new int[X+1];

        dpArray[1] = 1;



        br.close();
        bw.flush();
        bw.close();
    }
}
