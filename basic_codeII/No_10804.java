package basic_codeII;

import java.io.*;

public class No_10804 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] card = new int[21];
        for(int i = 1; i < 21; i++){
            card[i] = i;
        }

        for(int i = 0; i < 10; i++){
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);

            int tmp;
            while(start < end){
                tmp = card[end];
                card[end] = card[start];
                card[start] = tmp;

                end--;
                start++;
            }
        }
        for(int i = 1; i < 21; i++){
            bw.write(String.valueOf(card[i]));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
