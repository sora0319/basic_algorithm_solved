package code;

import java.io.*;
import java.util.*;

public class No_6603 {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int k;
	private static int[] numbers;
	private static int[] lotto = new int[6];

	public static void main(String[] args) throws IOException{
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			numbers = new int[k];
			for(int i = 0; i < k; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			createLotto(0,0);
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	private static void createLotto(int order, int start) throws IOException{
		if(order == 6) {
			for(int n : lotto) {
				bw.write(String.valueOf(n));
				bw.write(" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = start; i < k; i++) {
			lotto[order] = numbers[i];
			createLotto(order + 1, i + 1);
		}
	}
}