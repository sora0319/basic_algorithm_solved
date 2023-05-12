package basic_codeII;
import java.io.*;
import java.util.*;
public class No_2587 {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[5];
        int sum = 0;
        for(int i = 0; i < 5; i++){
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }
        Arrays.sort(numbers);

        bw.write(String.valueOf(sum/5));
        bw.write("\n");
        bw.write(String.valueOf(numbers[2]));

        bw.flush();
        bw.close();
        br.close();
    }
}
