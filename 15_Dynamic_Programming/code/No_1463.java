package code;

import java.io.*;
public class No_1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int[] counts = new int[X + 1];
        counts[1] = 0;

        for (int i = 2; i <= X; i++) {
            int minCount = 1000001;
            if (i % 3 == 0) {
                minCount =  1 + counts[i/3];
            }
            if (i % 2 == 0) {
                if(minCount > 1 + counts[i/2]){
                    minCount = 1 + counts[i/2];
                }
            }
            if(minCount > 1 + counts[i-1]){
                minCount = 1 + counts[i-1];
            }
            counts[i] = minCount;
        }

        bw.write(Integer.toString(counts[X]));

        br.close();
        bw.flush();
        bw.close();
    }
}
