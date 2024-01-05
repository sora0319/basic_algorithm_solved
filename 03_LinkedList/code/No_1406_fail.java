package code;

import java.io.*;
import java.util.*;

public class No_1406_fail {
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> words = new LinkedList<>();

        String temp = br.readLine();
        for(int i = 0; i < temp.length(); i++){
            words.add(String.valueOf(temp.charAt(i)));
        }

        int cursor = words.size();
        String[] command;
        int repeat = Integer.parseInt(br.readLine());
        for(int i = 0; i < repeat; i++){
            command = br.readLine().split(" ");

            if(command[0].equals("L")){
                if(cursor > 0){
                    cursor--;
                }
            }
            else if(command[0].equals("D")){
                if(cursor < words.size()){
                    cursor++;
                }
            }
            else if(command[0].equals("B")){
                if(cursor > 0){
                    words.remove(cursor-1);
                    cursor--;
                }
            }
            else if(command[0].equals("P")){
                words.add(cursor, command[1]);
                cursor++;
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
