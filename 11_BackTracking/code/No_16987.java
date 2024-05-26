package code;

import java.io.*;
import java.util.*;

public class No_16987 {
	private static int count = 0;
	private static Egg[] eggs;
	private static boolean[] crack;

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private class Egg{
		int durability;
		int weight;
		
		public Egg(int durability, int weight) {
			this.durability = durability;
			this.weight = weight;
		}
	}

}




/*
무게를 기준으로 깰 것인지, 내구도를 기준으로 깰 것인지 정하는 것?
기준을 정하지 말고 무턱대도 백트래킹으로 풀어도 될까?
무조건 오른쪽에 있는 계란을 부셔야 하니 모든 경우의 수를 해서 count가 가장 큰 값을 저장 후
결과 값으로 보여주면 ?
*/