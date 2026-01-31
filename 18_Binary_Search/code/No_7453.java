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

        long[] AB = new long[N * N];
        long[] CD = new long[N * N];
        long totalCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int n = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[n] = (long) (A[i] + B[j]);
                CD[n] = (long) (C[i] + D[j]);
                n++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);


        for(int i = 0; i < N*N; i++) {
            long target = -AB[i];
            int upper = upperBound(target, CD);
            int lower = lowerBound(target, CD);

            if(upper >= 0 && lower >= 0){
                totalCount += (upper - lower + 1);
            }
        }

        bw.write(String.valueOf(totalCount));
        br.close();
        bw.flush();
        bw.close();
    }

    private static int lowerBound(long target, long[] sums){
        int start = 0, end = sums.length -1;
        int mid = 0;
        int lowerPosition = -1;

        while(start <= end){
            mid = (start + end) / 2;
            if(sums[mid] == target){
                lowerPosition = mid;
                end = mid -1;
            }

            if(sums[mid] > target){
                end = mid-1;
            }

            if (sums[mid] < target) {
                start = mid + 1;
            }

        }
        return  lowerPosition;
    }

    private static int upperBound(long target, long[] sums){
        int start = 0, end = sums.length -1;
        int mid = 0;
        int upperPosition = -1;

        while(start <= end){
            mid = (start + end) / 2;
            if(sums[mid] == target){
                upperPosition = mid;
                start = mid + 1;
            }

            if(sums[mid] > target){
                end = mid - 1;
            }

            if (sums[mid] < target) {
                start = mid + 1;
            }

        }
        return upperPosition;
    }
}
