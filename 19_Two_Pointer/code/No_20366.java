package code;

import java.io.*;
import java.util.*;

public class No_20366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<int[]> snowMan = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[] snowballs = new int[N];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            snowballs[i] = Integer.parseInt(inputs[i]);
        }


        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int[] balls = new int[2];
                balls[0] = i;
                balls[1] = j;
                snowMan.add(balls);
            }
        }

        /*
            하나하나씩 비교를 하는데,
            같은 위치의 눈덩이가 눈사람에 있으면 넘어간다
         */
        int minHiehgt = 1200;
        for (int first = 0; first < snowMan.size(); first++) {
            for (int second = first + 1; second < snowMan.size(); second++) {
                int[] firstSnowMan = snowMan.get(first);
                int[] secondSnowMan = snowMan.get(second);

                int firstHeight = firstSnowMan[0] + firstSnowMan[1];
                int secondHeight = secondSnowMan[0] + secondSnowMan[1];

                if (minHiehgt > Math.abs(firstHeight - secondHeight)) {
                    if(firstSnowMan[0] == secondSnowMan[0] || firstSnowMan[0] == secondSnowMan[1]) break;
                }
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }

}
