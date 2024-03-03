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

        bw.write(String.valueOf(grid(N, r, c)));


        br.close();
        bw.flush();
        bw.close();
    }

    private static int grid(int n, int r, int c) {
        if(n == 0) return 0;
        int middle = 1 << (n-1);
        if(middle > r && middle > c) return grid(n - 1, r, c); // 현재 크기보다 작은 사각형에서의 위치
        if(middle > r && middle <= c) return middle * middle + grid(n-1, r, c - middle); // 1사분면값 + 현재 크기보다 작은 사각형에서의 위치
        if(middle <= r && middle > c) return 2 * middle * middle + grid(n-1, r - middle, c); // 1,2사분면값 + 현재 크기보다 작은 사각형에서의 위치
        if(middle <= r && middle <= c)return 3 * middle * middle + grid(n-1, r - middle, c - middle); // 1,2,3사분면값 + 현재 크기보다 작은 사각형에서의 위치
        return 0;
    }
}
