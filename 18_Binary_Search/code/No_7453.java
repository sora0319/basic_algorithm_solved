package code;

import java.util.*;
import java.io.*;

public class No_7453 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        int[] numbers = new int[4];
        int totalCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        long numberSum = 0;
        for(int a = 0; a < N; a++){
            numberSum += A[a];
            for (int b = 0; b < N; b++) {
                numberSum += B[b];
                for(int c = 0; c < N; c++){
                    numberSum += C[c];

                    int target = (int)(- numberSum);
                    if(Arrays.binarySearch(D, target) >= 0){
                        totalCount++;
                    }

                    numberSum -= C[c];
                }
                numberSum -= B[b];
            }
            numberSum -= A[a];
        }





        br.close();
        bw.flush();
        bw.close();
    }

    private static int founded(int a, int b, int c, int d){

        return  0;
    }
}
