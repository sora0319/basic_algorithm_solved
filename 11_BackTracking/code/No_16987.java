package code;

import java.io.*;
import java.util.*;

public class No_16987 {
	private static int count = 0, maxCount = 0;
	private static int[] eggs;
	private static int[] crack;
	private static int N;

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		eggs = new int[N];
		crack = new int[N]; 
		
		// 내구도 값으로 초기화 => 깨진 것을 확인하기 위해
		for(int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			eggs[i] = weight;
			crack[i] = durability;
		}
		
		breakEgg(0);
		bw.write(String.valueOf(maxCount));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void breakEgg(int handEgg) {
		if(handEgg == N) {
			if(maxCount < count) maxCount = count;
			return;
		}
		
		if(crack[handEgg] < 1 || count == N-1) {
			breakEgg(handEgg + 1);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(handEgg == i || crack[i] < 1) continue;
			crack[handEgg] -= eggs[i];
			crack[i] -= eggs[handEgg];
			
			if(crack[handEgg] < 1) count++;
			if(crack[i] < 1) count++;
			breakEgg(handEgg + 1);
			
			if(crack[handEgg] < 1) count--;
			if(crack[i] < 1) count--;
			crack[handEgg] += eggs[i];
			crack[i] += eggs[handEgg];
			
		}
	}
}

/*
무게를 기준으로 깰 것인지, 내구도를 기준으로 깰 것인지 정하는 것?
기준을 정하지 말고 무턱대도 백트래킹으로 풀어도 될까?
무조건 오른쪽에 있는 계란을 부셔야 하니 모든 경우의 수를 해서 count가 가장 큰 값을 저장 후
결과 값으로 보여주면 ?

만약 handEgg == N
	for문 반복 0부터 N-1
		crack이 1보다 작은 것의 계란 수 세기
		count에 저장
		maxCount에 저장
		
==> 이렇게 하면 만약 마지막 계란 빼고 나머지 계란이 다 깨졌을 때 
위의 조건문에 들어오지 못하고 빠져나가게 된다
그러므로 count를 깨는 도중에 같이 세는 것으로 수정한다 (코드 참조)

손에 1
손에 계란이 깨져있다면
	breakEgg(handEgg+1)
	return
		
for문 반복 0부터 N-1까지
	2의 crack이 1보다 크거나 같은지 확인한다
		2를 깬다 => crack에 각각의 값을 저장한다
		breakEgg( handEgg+1)
		crack의 값을 이전으로 복원한다
		### 추가 => 계란이 깨졌다면 각각의 계란에 대해 count++을 하고 돌아올 때 다시 count--로 복원한다

*/