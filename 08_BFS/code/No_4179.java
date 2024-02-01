package code;

import java.io.*;
import java.util.*;
public class No_4179 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> fireQueue = new LinkedList<>();
        Queue<Pair> moveQueue = new LinkedList<>();

        String[] inputs = br.readLine().split(" ");
        int R = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        char[][]space = new char[R][C];
        int[][] fireTime = new int[R][C];
        int[][] escapeTime = new int[R][C];

        for(int i = 0; i < R; i++){
            String input = br.readLine();
            for(int j = 0; j < C; j++){
                space[i][j] = input.charAt(j);
                if(space[i][j] == 'J'){
                    moveQueue.offer(new Pair(i,j));
                    escapeTime[i][j] = 1;
                }
                if(space[i][j] == 'F'){
                    fireQueue.offer(new Pair(i, j));
                    fireTime[i][j] = 1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!fireQueue.isEmpty()){
            Pair target = fireQueue.poll();
            for(int i = 0; i < 4; i++) {
                int moveX = target.x + dx[i];
                int moveY = target.y + dy[i];
                if(moveX < 0 || moveX >= R || moveY < 0 || moveY >=C) continue;
                if(fireTime[moveX][moveY] > 0 || space[moveX][moveY] == '#') continue;
                fireQueue.offer(new Pair(moveX, moveY));
                fireTime[moveX][moveY] = fireTime[target.x][target.y] + 1;
            }
        }

        int escape = 0;
        while(!moveQueue.isEmpty()){
            Pair target = moveQueue.poll();
            for(int i = 0; i < 4; i++) {
                int moveX = target.x + dx[i];
                int moveY = target.y + dy[i];
                if (moveX < 0 || moveX >= R || moveY < 0 || moveY >= C) {
                    escape = escapeTime[target.x][target.y];
                    break;
                }
                if(fireTime[moveX][moveY] > 0 && fireTime[moveX][moveY] <= escapeTime[target.x][target.y] + 1) continue;
                if(escapeTime[moveX][moveY] > 0 || space[moveX][moveY] == '#') continue;
                moveQueue.offer(new Pair(moveX, moveY));
                escapeTime[moveX][moveY] = escapeTime[target.x][target.y] + 1;
            }
            if(escape>0) break;
        }

        if (escape > 0) {
            bw.write(String.valueOf(escape));
        } else {
            bw.write("IMPOSSIBLE");
        }


        br.close();
        bw.flush();
        bw.close();
    }

    static  class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
