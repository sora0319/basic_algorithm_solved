package code;

import java.io.*;
import java.util.*;
public class No_5427 {
    static int w, h;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int moveX, moveY, time;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> fQueue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        String[] inputs;
        String input;

        while (N-- > 0) {
            inputs = br.readLine().split(" ");
            w = Integer.parseInt(inputs[0]);
            h = Integer.parseInt(inputs[1]);

            char[][] space = new char[h][w];
            int[][] fireTime = new int[h][w];
            int[][] escapeTime = new int[h][w];
            queue.clear();
            fQueue.clear();

            for (int i = 0; i < h; i++) {
                input = br.readLine();
                for (int j = 0; j < w; j++) {
                    space[i][j] = input.charAt(j);
                    fireTime[i][j] = -1;
                    escapeTime[i][j] = -1;
                    if(space[i][j] == '*'){
                        fQueue.offer(new Pair(i, j));
                        fireTime[i][j] = 0;
                    }
                    if(space[i][j] == '@'){
                        queue.offer(new Pair(i, j));
                        escapeTime[i][j] = 0;
                    }
                }
            }

            while(!fQueue.isEmpty()){
                Pair fire = fQueue.poll();
                for (int i = 0; i < 4; i++) {
                    moveX = fire.h + dx[i];
                    moveY = fire.w + dy[i];
                    if(moveX < 0 || moveY < 0 || moveX >= h || moveY >= w) continue;
                    if(space[moveX][moveY] == '#' || fireTime[moveX][moveY] >-1) continue;
                    fQueue.offer(new Pair(moveX, moveY));
                    fireTime[moveX][moveY] = fireTime[fire.h][fire.w] + 1;
                }
            }

            time = -1;
            while (!queue.isEmpty()) {
                Pair human = queue.poll();
                for (int i = 0; i < 4; i++) {
                    moveX = human.h + dx[i];
                    moveY = human.w + dy[i];
                    if(moveX < 0 || moveY < 0 || moveX >= h || moveY >= w){
                        time = escapeTime[human.h][human.w] + 1;
                        queue.clear();
                        break;
                    }
                    if(space[moveX][moveY] == '#' || escapeTime[moveX][moveY] >-1) continue;
                    if(fireTime[moveX][moveY] != -1 && escapeTime[human.h][human.w] + 1 >= fireTime[moveX][moveY]) continue;
                    queue.offer(new Pair(moveX, moveY));
                    escapeTime[moveX][moveY] = escapeTime[human.h][human.w] + 1;
                }
            }

            if (time == -1) {
                bw.write("IMPOSSIBLE");
            } else{
                bw.write(String.valueOf(time));
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
    static class Pair{
        int h, w;

        Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}