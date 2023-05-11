package basic_codeII;
import java.io.*;

public class No_10869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int[] numbers = new int[temp.length];
        for (int i = 0; i < 2; i++){
            numbers[i] = Integer.parseInt(temp[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(numbers[0] + numbers[1]));
        bw.write("\n");
        bw.write(String.valueOf(numbers[0] - numbers[1]));
        bw.write("\n");
        bw.write(String.valueOf(numbers[0] * numbers[1]));
        bw.write("\n");
        bw.write(String.valueOf(numbers[0] / numbers[1]));
        bw.write("\n");
        bw.write(String.valueOf(numbers[0] % numbers[1]));

        bw.flush();
        bw.close();
        br.close();
    }
}
