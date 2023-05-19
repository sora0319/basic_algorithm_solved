package basic_codeII.code;
import java.io.*;

public class No_9498 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(n >= 90) {
            bw.write("A");
        }
        else if(n >= 80) {
            bw.write("B");
        }
        else if(n >= 70) {
            bw.write("C");
        }
        else if(n >= 60) {
            bw.write("D");
        }
        else{
            bw.write("F");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
