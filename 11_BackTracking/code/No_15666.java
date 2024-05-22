package code;

import java.io. *;
import java.util.*;

public class No_15666 {
	private static int N, M;
	private static int[] numbers, seqeunce;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		seqeunce = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		createSeq(0, 0);
		
		br.close();
		bw.flush();
		bw.close();
	}
	private static void createSeq(int order, int start) throws IOException{
		if(order == M) {
			for(int n : seqeunce) {
				bw.write(String.valueOf(n));
				bw.write(" ");
			}
			bw.newLine();
			return;
		}
		for(int i = start; i < N; i++) {
			if(seqeunce[order] != numbers[i]) {
				seqeunce[order] = numbers[i];
				createSeq(order + 1, i);
			}
		}
		seqeunce[order] = 0;
	}

}
