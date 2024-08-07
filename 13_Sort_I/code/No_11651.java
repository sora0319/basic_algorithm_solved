package code;

import java.io.*;
import java.util.*;

public class No_11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Pointer> pointerList = new ArrayList<>();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pointerList.add(new Pointer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(pointerList);

        for (Pointer p : pointerList) {
            bw.write(String.valueOf(p.x));
            bw.write(" ");
            bw.write(String.valueOf(p.y));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Pointer implements Comparable<Pointer>{
        private int x;
        private int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pointer other) {
            if(this.y > other.y) return 1;
            if(this.y == other.y){
                if(this.x > other.x) return 1;
                if(this.x == other.x) return 0;
                return -1;
            }
            return -1;
        }
    }
}
