package code;

import java.io.*;
import java.util.*;
public class No_1406 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> words = new LinkedList<>();
        ListIterator<String> iter = words.listIterator();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            iter.add(String.valueOf(str.charAt(i)));
        }

        int repeat = Integer.parseInt(br.readLine());
        String [] order;
        for(int i = 0; i < repeat; i++){
            order = br.readLine().split(" ");
            switch (order[0]) {
                case "L":
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case "D":
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case "B":
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P":
                    iter.add(order[1]);
                    break;
            }
        }
        for(String s : words){
            bw.write(s);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
