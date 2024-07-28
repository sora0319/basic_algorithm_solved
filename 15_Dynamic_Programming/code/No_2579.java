package code;

import java.io.*;

public class No_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[] jumping = new int[N + 1];
        int[] walk = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        jumping[1] = stairs[1];
        walk[1] = stairs[1];

        for (int i = 2; i <= N; i++) {
            walk[i] = jumping[i-1] + stairs[i];
            jumping[i] = Math.max(walk[i - 2] + stairs[i], jumping[i - 2] + stairs[i]);
        }

        bw.write(String.valueOf(Math.max(walk[N], jumping[N])));

        br.close();
        bw.flush();
        bw.close();
    }
}
/*
메인
0   1   2   3   4   5   6
0   10  20  15  25  10  20

뛰기
0   1   2   3   4   5   6
0   10   20  25

연속
0   1   2   3   4   5   6
0   10  30  35

1번째 칸
연속 : 10 => [연속-1]+[메인]
뛰기 : 10 없음

2번째 칸
연속 : 10+20=30 => [뛰기-1]+[메인]
뛰기 : 20 최대값 [연속-2], [뛰기-2]

3번째
연속 : 20+15=35 => [뛰기-1]+[메인]
뛰기 : 10+15=25 => [뛰기-2]+[메인] 또는 [연속-2]+[뛰기]

4번째
연속 : 25+25=50 => [뛰기-1]+[메인]
뛰기 : 30+25=55 => [뛰기-2]+[메인] 또는 [연속-2]+[뛰기]

 */