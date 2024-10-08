package code;

import java.io.*;
import java.util.*;
public class No_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Student> mans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mans.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(mans);
        for (Student s : mans) {
            bw.write(s.name);
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
   }
    private static class Student implements Comparable<Student>{
        String name;
        int k;
        int e;
        int m;
        Student(String name, int k, int e, int m) {
            this.name = name;
            this.k= k;
            this.e = e;
            this.m = m;
        }

        @Override
        public int compareTo(Student o) {
            if(this.k < o.k) return 1;
            if (this.k == o.k ) {
                if(this.e > o.e) return 1;
                if(this.e == o.e){
                    if(this.m < o.m) return 1;
                    if(this.m == o.m){
                        return this.name.compareTo(o.name);
                    }
                }
            }
            return -1;
        }


    }
}
