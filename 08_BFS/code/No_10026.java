package code;

import java.io.*;
import java.util.*;
public class No_10026 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> nQueue = new LinkedList<>();
        Queue<Pair> cQueue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        char[][] nColor = new char[N][N]; // color-blind
        char[][] cColor = new char[N][N]; // color
        int[][] nVis = new int[N][N]; // color-blind
        int[][] cVis = new int[N][N]; // color

        for (int i = 0; i < N; i++) {
            String inputs = br.readLine();
            for(int j = 0; j < N; j++){
                char input = inputs.charAt(j);
                if(input == 'R' || input == 'G'){
                    nColor[i][j] = 'R';
                }
                cColor[i][j] = input;
            }
        }

        int nCount = 0, cCount = 0;
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if(nVis[i][j] != 1){
                    nQueue.offer(new Pair(i, j));
                    bfs(nColor, nVis, nQueue);
                    nCount++;
                }
                if(cVis[i][j] != 1){
                    cQueue.offer(new Pair(i, j));
                    bfs(cColor, cVis, cQueue);
                    cCount++;
                }
            }
        }
        bw.write(String.valueOf(cCount));
        bw.write(" ");
        bw.write(String.valueOf(nCount));

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(char[][] color, int[][] vis, Queue<Pair> queue){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            Pair c = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = c.x + dx[i];
                int moveY = c.y + dy[i];
                if(moveX < 0 || moveY < 0|| moveX >= color.length || moveY >= color.length) continue;
                if(vis[moveX][moveY] == 1 || color[c.x][c.y] != color[moveX][moveY]) continue;
                queue.offer(new Pair(moveX, moveY));
                vis[moveX][moveY] = 1;
            }
        }
    }

    static class Pair{
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}