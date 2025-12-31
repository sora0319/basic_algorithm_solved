package code;
//
//import java.io.*;
//import java.util.*;
//
//public class No_6603 {
//	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	private static int k;
//	private static int[] numbers;
//	private static int[] lotto = new int[6];
//
//	public static void main(String[] args) throws IOException{
//		StringTokenizer st;
//
//		while(true) {
//			st = new StringTokenizer(br.readLine());
//			k = Integer.parseInt(st.nextToken());
//			if(k == 0) break;
//
//			numbers = new int[k];
//			for(int i = 0; i < k; i++) {
//				numbers[i] = Integer.parseInt(st.nextToken());
//			}
//			createLotto(0,0);
//			bw.newLine();
//		}
//
//		br.close();
//		bw.flush();
//		bw.close();
//	}
//	private static void createLotto(int order, int start) throws IOException{
//		if(order == 6) {
//			for(int n : lotto) {
//				bw.write(String.valueOf(n));
//				bw.write(" ");
//			}
//			bw.newLine();
//			return;
//		}
//
//		for(int i = start; i < k; i++) {
//			lotto[order] = numbers[i];
//			createLotto(order + 1, i + 1);
//		}
//	}
//}

import java.io.*;
import java.util.*;

public class No_6603 {

    private static int[] numbers;
    private static int[] lotto = new int[7];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        while (true) {
            String[] inputs = br.readLine().split(" ");
            if(inputs[0] == "0") break;

            int K = Integer.parseInt(inputs[0]);
            numbers = new int[K];

            for (int i = 0; i < K; i++) {
                numbers[i] = Integer.parseInt(inputs[i+1]);
            }

            for (int i = 0; i <= K - 6; i++) {
                lotto[i] = numbers[i];
                printNumbers(i,1);
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }

    private static void printNumbers(int start, int count) throws IOException{
        if(count == 6){
            for (int i = 0; i < 6; i++) {
                bw.write(String.valueOf(lotto[i]));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }

        for (int i = start + 1; i < numbers.length; i++) {
            lotto[++count] = numbers[i];
            printNumbers(i, count);
        }
    }
}