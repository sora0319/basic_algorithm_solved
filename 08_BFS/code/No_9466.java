package code;

import java.io.*;
import java.util.*;
public class No_9466 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Pair> queue = new LinkedList<>();

        int T = Integer.parseInt(br.readLine());
        int n, count;
        int[] student, visit, group;
        String[] inputs;

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            student = new int[n+1];
            group = new int[n+1];
            count = 0;

            inputs = br.readLine().split(" ");
            for(int i = 1; i < n+1; i++){
                student[i] = Integer.parseInt(inputs[i-1]);
            }

            for(int i = 1; i< n+1; i++){
                queue.offer(new Pair(i, student[i]));
                visit = new int[n+1];
                visit[i] = 1;
                while (!queue.isEmpty()) {
                    Pair connection = queue.poll();
                    int start = connection.start;
                    int nextPoint = connection.point;

                    if(group[nextPoint] == -1){
                        group[start] = -1;
                        break;
                    }
                    if(start == nextPoint){
                        group[start] = 1;
                        group[nextPoint] = 1;
                        break;
                    }
                    if(visit[nextPoint] == 1){
                        group[start] = -1 ;
                        break;
                    }

                    visit[nextPoint] = 1;
                    queue.offer(new Pair(start, student[nextPoint]));
                }
            }
            for(int i : group){
                if(i == -1){
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
    static class Pair{
        int start, point;
        Pair(int start, int point) {
            this.start = start;
            this.point = point;
        }
    }
}
