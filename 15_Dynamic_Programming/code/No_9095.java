package code;

import java.io.*;
public class No_9095 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] counts = new int[11];
        counts[0] = 1;
        counts[1] = 1;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for(int j = 2; j <= n; j++){
                if(j == 2) {
                    counts[j] = counts[0] + counts[1];
                    continue;
                }
                counts[j] = counts[j-1] + counts[j-2] + counts[j-3];
            }
            bw.write(String.valueOf(counts[n]));
            bw.newLine();
        }




        br.close();
        bw.flush();
        bw.close();
    }
}


/*
0   1   2   3   4   5   6   7   8   9
1   1   2   4   7   13  24  44

5가 만들어지는 경우
1+1+1+1+1
1+1+1+2
1+1+2+1
1+2+1+1
2+1+1+1
1+2+2
2+1+2
2+2+1
1+1+3
1+3+1
3+1+1
2+3
3+2
 */