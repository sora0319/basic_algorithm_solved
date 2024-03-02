package code;

import java.io.*;
import java.util.StringTokenizer;

public class No_1074 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());




        br.close();
        bw.flush();
        bw.close();
    }

    private static int grid(int n, int r, int c) {
        int middle = 1 << (n-1);
        if(n == 0) return 0;
        if(middle > r && middle > c) return grid(n - 1, r, c);
        if(middle > r && 1 << (n-1) <= c) return  + grid(n-1, r, c);
        if(middle <= r && 1 << (n-1) > c);
        if(middle <= r && 1<< (n-1) <= c);
        return 0;
    }
}
