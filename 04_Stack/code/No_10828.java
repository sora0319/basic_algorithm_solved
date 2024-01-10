package code;

import java.io.*;

public class No_10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int MX = 10000;
        int[] stack = new int[MX];
        int pos = 0;

        int repeat = Integer.parseInt(br.readLine());
        for (int i = 0; i < repeat; i++) {
            String[] orders = br.readLine().split(" ");

            if (orders[0].equals("push")) {
                stack[pos++] = Integer.parseInt(orders[1]);
            } else if (orders[0].equals("pop")) {
                if (pos > 0) {
                    bw.write(String.valueOf(stack[pos-1]));
                    bw.write(System.lineSeparator());
                    pos--;
                } else {
                    bw.write("-1");
                    bw.write(System.lineSeparator());
                }
            } else if (orders[0].equals("size")) {
                bw.write(String.valueOf(pos));
                bw.write(System.lineSeparator());
            } else if (orders[0].equals("empty")) {
                if (pos > 0) {
                    bw.write("0");
                    bw.write(System.lineSeparator());
                } else {
                    bw.write("1");
                    bw.write(System.lineSeparator());
                }
            } else if (orders[0].equals("top")) {
                if (pos > 0) {
                    bw.write(String.valueOf(stack[pos-1]));
                    bw.write(System.lineSeparator());
                } else {
                    bw.write("-1");
                    bw.write(System.lineSeparator());
                }
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
