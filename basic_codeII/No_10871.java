package basic_codeII;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_10871{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // input string
        String[] input = br.readLine().split(" ");
        int[] n = new int[input.length];

        for (int i = 0; i < 2; i++){
            n[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        int[] number = new int[input.length];
        for (int i = 0; i < n[0]; i++){
            number[i] = Integer.parseInt(input[i]);
        }

        // compare number
        for (int i = 0; i < n[0]; i++){
            if (n[1] > number[i]) {
                bw.write(String.valueOf(number[i]));
                bw.write(" ");
            }
        }

        // close all
        br.close();
        bw.close();
    }
}
