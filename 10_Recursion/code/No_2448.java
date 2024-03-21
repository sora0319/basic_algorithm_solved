package code;

import java.io.*;
public class No_2448 {
    private static String[][] stars;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        stars = new String[N][2*N];

        br.close();
        bw.flush();
        bw.close();
    }
    private static void drawing() {

    }
}
