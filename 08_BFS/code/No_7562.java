package code;

import java.io.*;
import java.util.*;
public class No_7562 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int I = Integer.parseInt(br.readLine());
            int[][] moveCount = new int[I][I];

            String[] inputs = br.readLine().split(" ");
            int X = Integer.parseInt(inputs[0]);
            int Y = Integer.parseInt(inputs[1]);
            queue.offer(new Pair(X,Y));
            moveCount[X][Y] = 1;
            inputs = br.readLine().split(" ");
            Pair endPoint = new Pair(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));

            int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
            int[] dy = {1, -1, -2, -2, -1, 1, 2, 2};
            while (!queue.isEmpty()) {
                Pair point = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int moveX = point.x + dx[i];
                    int moveY = point.y + dy[i];
                    if (moveX < 0 || moveY < 0 || moveX >= I || moveY >= I) continue;
                    if (moveCount[moveX][moveY] > 0) continue;
                    queue.offer(new Pair(moveX, moveY));
                    moveCount[moveX][moveY] = moveCount[point.x][point.y] + 1;
                    if(moveX == endPoint.x && moveY == endPoint.y){
                        queue.clear();
                        break;
                    }
                }
            }
            bw.write(String.valueOf(moveCount[endPoint.x][endPoint.y] - 1));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Pair{
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}