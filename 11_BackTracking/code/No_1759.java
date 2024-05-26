package code;

import java.io.*;
import java.util.*;

public class No_1759 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static char[] alphabet, password;
	private static int L, C;
	private static char[] vowel = {'a','e','i','o','u'};
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		password = new char[L];
		alphabet = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet);
		createLotto(0, 0);
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	private static void createLotto(int order, int start) throws IOException{
		if(order == L && checkCondition()) {
			for(char c : password) {
				bw.write(String.valueOf(c));
			}
			bw.newLine();
			return;
		}
		if(order == L) return;
		
		for(int i = start; i < C; i++) {
			password[order] = alphabet[i];
			createLotto(order + 1, i + 1);
		}
	}
	
	private static boolean checkCondition() {
		int vowelCount = 0;
		int consonantCount = 0;
		
		boolean wordState = false;
		
		for(char c : password) {
			for(char word : vowel) {
				if(c == word) {
					vowelCount++;
					wordState = true;
					break;
				}
			}
			if(!wordState) consonantCount++;
			wordState = false;
		}
		
		if(vowelCount > 0 && consonantCount >= 2) return true;
		return false;
	}
}