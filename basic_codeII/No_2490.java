package basic_codeII;

import java.io.*;
import java.util.*;

public class No_2490 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 3; i++){
            String[] temp = br.readLine().split(" ");
            int[] game = new int[4];

            for(int j = 0; j < 4; j++){
                game[j] = Integer.parseInt(temp[j]);
            }
            Arrays.sort(game);

            int zeroCnt = 0;
            for(int j = 0; j < 4; j++){
                if(game[j] == 0){
                    zeroCnt += 1;
                }
                else{
                    break;
                }
            }

            if(zeroCnt == 0){
                bw.write("E");
            }
            else if(zeroCnt == 1){
                bw.write("A");
            }
            else if(zeroCnt == 2){
                bw.write("B");
            }
            else if(zeroCnt == 3){
                bw.write("C");
            }
            else{
                bw.write("D");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
