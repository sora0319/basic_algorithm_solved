package Arrays.code;

import java.io.*;

public class No_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numbers = new int[10];

        String temp = br.readLine();

        int inputLength = temp.length();
        int set = 0;
        for (int i = 0; i < inputLength; i++){
            int n = temp.charAt(i) - '0';

            if(n == 6 || n == 9){
                if(numbers[6] > numbers[9]){
                    numbers[9]++;
                }
                else if(numbers[6] < numbers[9]){
                    numbers[6]++;
                }
                else{
                    numbers[n]++;
                }
            }
            else{
                numbers[n]++;
            }

            if (set < numbers[n]){
                set = numbers[n];
            }
        }

        bw.write(String.valueOf(set));
        bw.flush();
        br.close();
        bw.close();

    }
}
