package code;

import java.io.*;
import java.util.*;

public class No_18809 {
	private static int count = 0, maxCount = 0;
	private static int N, M, G, R, totalWater;
	private static int[][] board;
	private static Ground[] canGround = new Ground[10];
	private static char[] water;
	private static char[] combination;
	private static boolean[] used;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		water = new char[R+G];
		
		totalWater = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) canGround[totalWater++] = new Ground(i, j);
			}
		}
		
		for(int i = 0; i < G; i++) {
			water[i] = 'g';
		}
		for(int i = G; i < G+R; i++) {
			water[i] = 'r';
		}
		
		combination = new char[totalWater];
		used = new boolean[totalWater];
		System.out.println(totalWater);
		
		makeFlower(0, 0);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void makeFlower(int order, int start) {
		if(order == totalWater) {
			for(char c : combination) {
				System.out.print(c + " ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i = start; i < totalWater; i++) {
			sysout
			if(combination[order] == water[i] || used[i]) continue;
			combination[order] = water[i];
			used[i] = true;
			makeFlower(order + 1, start + 1);
			used[i] = false;
		}
		combination[order] = ' ';
	}
	
	private static class Ground {
		int x, y;
		public Ground(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}


/*
꽃의 개수 저장 count
최대 꽃의 개수 저장 MaxCo0unt
N, M, R, G , totalWater(water 저장된 크기)


배양액을 심을 수 있는 위치를 저장하는 배열 : canGround => 10개로 고정
x, y를 관리할 ground 클래스
전 땅을 저장할 배열 : board
배양액 초록색과 빨간색 개수만큼 저장할 배열(g, r) : water
water를 조합 할 

중복 원소들이 있는 중복 허용하지 않은 백트래킹 먼저 만들기

bfs를 이요하는 것은 일단 나중에 


gggrr
ggrgr
ggrrg
grggr
grgrg
grrgg
rgggr
rggrg
rgrgg
rrggg


*/