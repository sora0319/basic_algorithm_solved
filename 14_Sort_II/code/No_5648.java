package code;

import java.io.*;
import java.util.*;

public class No_5648 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Long> numbers = new ArrayList<>();

        while(N-- > 0){
            if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            if(st.hasMoreTokens()){
                String original = st.nextToken();
                int length = original.length();
                long reverseCnt = 0;
                for (int i = length-1; i >= 0; i--) {
                    reverseCnt += (long) ((original.charAt(i) - '0') * Math.pow(10, i));
                }
                numbers.add(reverseCnt);
            }
        }

        Collections.sort(numbers);

        for (long i : numbers) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}