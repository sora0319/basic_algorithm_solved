package code;

import java.io.*;
import java.util.*;
public class No_11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Pointer> pointers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pointers.add(new Pointer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(pointers);

        for (Pointer pointer : pointers) {
            bw.write(String.valueOf(pointer.x));
            bw.write(" ");
            bw.write(String.valueOf(pointer.y));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Pointer implements Comparable<Pointer> {
        private final int x;
        private final int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pointer other) {
            if(this.x > other.x) return  1;
            if(this.x == other.x){
                if(this.y > other.y) return 1;
                if(this.y == other.y) return 0;
                return -1;
            }
            return -1;
        }
    }
}
