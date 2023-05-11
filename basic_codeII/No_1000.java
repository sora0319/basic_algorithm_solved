package basic_codeII;

import java.io.*;

public class No_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int result = 0;
        for (String t : temp){
            result += Integer.parseInt(t);
        }

        //System.out.println(result);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
