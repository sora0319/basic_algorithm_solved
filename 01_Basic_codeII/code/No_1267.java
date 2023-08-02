package basic_codeII.code;

import java.io.*;
public class No_1267 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        int[] time = new int[N];
        for(int i = 0; i < N; i++){
            time[i] = Integer.parseInt(temp[i]);
        }

        int[] pay = new int[2];
        for(int i = 0; i < N; i++){
            pay[0] += time[i] / 30 + 1;
            pay[1] += time[i] / 60 + 1;
        }

        if(pay[0] * 10 < pay[1] * 15){
            bw.write("Y ");
            bw.write(String.valueOf(pay[0] * 10));
        }
        else if(pay[0] * 10 > pay[1] * 15){
            bw.write("M ");
            bw.write(String.valueOf(pay[1] * 15));
        }
        else{
            bw.write("Y M ");
            bw.write(String.valueOf(pay[0] * 10));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
