package code;

import java.io.*;

public class No_10989 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] countArray = new int[10000+1];

        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(br.readLine());
            countArray[number]++;
        }

        for (int i = 1; i < 10001; i++) {
            if(countArray[i] != 0){
                for(int j = 0; j < countArray[i]; j++){
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
