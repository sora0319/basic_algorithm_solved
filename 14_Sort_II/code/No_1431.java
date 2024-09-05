package code;

import java.io.*;
import java.util.*;
public class No_1431 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Number[] numbers = new Number[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = new Number(br.readLine());
        }

        Arrays.sort(numbers);
        for (Number n : numbers) {
            bw.write(n.serial);
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
    private static class Number implements Comparable<Number>{
        String serial;
        int length;
        int sum;

        Number(String serial) {
            this.serial = serial;
            this.length = serial.length();
            this.sum = calculate(serial);
        }

        private int calculate(String serial) {
            int sum = 0;
            for (int i = 0; i < serial.length(); i++) {
                int parseNumber = serial.charAt(i) - '0';
                if (parseNumber >= 0 && parseNumber < 10) {
                    sum += parseNumber;
                }
            }
            return sum;
        }

        @Override
        public int compareTo(Number o) {
            if(this.length < o.length) return -1;
            if (this.length == o.length) {
                if (this.sum < o.sum) return -1;
                if (this.sum > o.sum) return 1;
                for (int i = 0; i < this.length; i++) {
                    if (this.serial.charAt(i) < o.serial.charAt(i)) return -1;
                    if (this.serial.charAt(i) > o.serial.charAt(i)) return 1;
                }
                return 0;
            }
            return 1;
        }

    }
}
