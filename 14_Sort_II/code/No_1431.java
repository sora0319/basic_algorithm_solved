package code;

import java.io.*;
import java.util.*;
public class No_1431 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] serial = new String[N];

        for (int i = 0; i < N; i++) {
            serial[i] = br.readLine();
        }

        Arrays.sort(serial);
        System.out.println(Arrays.toString(serial));

        br.close();
        bw.flush();
        bw.close();
    }
    private static class Number implements Comparable<Number>{
        String serial;
        int length;

        Number(String serial, int length) {
            this.serial = serial;
            this.length = length;
        }

        @Override
        public int compareTo(Number o) {
            if(this.length < o.length){
                return -1;
            }

        }
    }
}
