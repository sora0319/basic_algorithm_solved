package code;

import java.io.*;
import java.util.*;

public class No_13549 {
    static int[] dx = {-1, 1};
    static int MAX = 100_000 + 10;
    static int[] time = new int[MAX];
    static int[] vis = new int[MAX];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);

        time[start] = 1;
        vis[start] = 2;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int target = queue.poll();
            int teleport = target * 2;
            while (0 < teleport && teleport < MAX) {
                if(vis[teleport] == 2) break; // 이전에 순간이동을 한 장소일 경우
                if(vis[teleport] != 1){
                    time[teleport] = time[target];
                    vis[teleport] = 2;
                } // 한번도 방문하지 않은 위치인 경우
                if(teleport == end){
                    queue.clear();
                    break;
                }
                queue.offer(teleport);
                teleport = teleport * 2;
            }

            for (int i = 0; i < 2; i++) {
                int move = target + dx[i];
                if(0 > move || move >= MAX) continue;
                if(vis[move] != 0) continue;
                time[move] = time[target] + 1;
                vis[move] = 1; // 1칸 이동했을때 표시 값
                queue.offer(move);
                if(teleport == end){
                    queue.clear();
                    break;
                }
            }
        }

        bw.write(String.valueOf(time[end] - 1));

        br.close();
        bw.flush();
        bw.close();
    }
}
