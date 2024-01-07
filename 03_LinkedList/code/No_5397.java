package code;

import java.io.*;
import java.util.*;
public class No_5397 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> password = new LinkedList<>();
        ListIterator<String> iter;

        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0; i < repeat; i++){
            iter = password.listIterator();
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '<'){
                    if(iter.hasPrevious()) iter.previous();
                } else if (str.charAt(j) == '>') {
                    if(iter.hasNext()) iter.next();
                } else if (str.charAt(j) == '-') {
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(String.valueOf(str.charAt(j)));
                }
            }
            for(String s : password){
                bw.write(s);
            }
            bw.newLine();
            password.clear();
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
