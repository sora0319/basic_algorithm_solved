package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class No_2003 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] numbers = new int[N+1];

        inputs = br.readLine().split(" ");

        for(int i = 1; i < N+1; i++){
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        int start  = 0, end = 0;
        int total = 0;
        int count = 0;
        while(start <= end){
            if(end > N || start > N) break;
            if(start == end){

            }

        }


        br.close();
        bw.flush();
        bw.close();

    }


}
