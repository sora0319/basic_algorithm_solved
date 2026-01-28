package code;

import java.io.*;
import java.util.*;

public class No_3151 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] students = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        int count = 0;
        for(int i = 0; i < N-2; i++){
            for (int j = i + 1; j < N-1; j++) {
                int x = - (students[i] + students[j]);
                if(Arrays.binarySearch(students, j+1, N, x) >= 0){
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
}
