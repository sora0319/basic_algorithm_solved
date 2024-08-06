package code;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No_10814 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Member> memberList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            memberList.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(memberList);
        for (Member person : memberList) {
            bw.write(String.valueOf(person.age) + " " + person.name);
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Member implements Comparable<Member>{
        private final int age;
        private final String name;

        public Member(int age, String name){
            this.age = age;
            this.name = name;
        }


        @Override
        public int compareTo(Member o) {
            return Integer.compare(this.age , o.age);
        }
    }
}
