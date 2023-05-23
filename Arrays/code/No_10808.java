package Arrays.code;

import java.io.*;

public class No_10808 {
    public static void main(String[] args)throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] words = br.readLine().toCharArray();

        int[] alphabet = new int[26];

        int space;
        for(char w : words){
            space = (int)w - 97;
            alphabet[space] += 1;
        }

        for(int n : alphabet){
            bw.write(String.valueOf(n));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
