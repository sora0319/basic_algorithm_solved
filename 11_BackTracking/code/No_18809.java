package code;

import java.io.*;
import java.util.*;

public class No_18809 {
	private static final char GREEN ='g';
	private static final char RED = 'r';
	private static final char SPACE = '0';
	private static int maxCount = 0;
	private static Ground[] canGround = new Ground[10];
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	
	private static int N, M, G, R, totalWater;
	private static int[][] board;
	private static char[] water;
	private static char[] combination;
	private static boolean[] waterUsed;
	private static WaterState[][] groundUsed;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		totalWater = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) canGround[totalWater++] = new Ground(i, j);
			}
		}
		
		water = new char[totalWater];
		combination = new char[totalWater];
		waterUsed = new boolean[totalWater];
		
		for(int i = 0; i < G; i++) {
			water[i] = GREEN;
		}
		for(int i = G; i < G+R; i++) {
			water[i] = RED;
		}
		for(int i = G+R; i < totalWater; i++) {
			water[i] = SPACE;
		}
		
		makeFlower(0);
		System.out.println(String.valueOf(maxCount));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void makeFlower(int order) {
		if(order == totalWater) {
			int count = bfs();
			if(maxCount < count) maxCount = count;
			return;
		}
		
		for(int i = 0; i < totalWater; i++) {
			if(combination[order] == water[i] || waterUsed[i]) continue;
			combination[order] = water[i];
			waterUsed[i] = true;
			
			makeFlower(order + 1);
			waterUsed[i] = false;
		}
		combination[order] = ' ';
	}
	
	private static int bfs() {
		groundUsed = new WaterState[N][M];
		Queue<Ground> queue = new LinkedList<Ground>();
		int count = 0;
		
		for(int i = 0; i < combination.length; i++) {
			int x = canGround[i].x;
			int y = canGround[i].y;
			if(combination[i] != SPACE) {
				groundUsed[x][y] = new WaterState(combination[i], 0);
				queue.offer(canGround[i]);
			}
		}
		
		while(!queue.isEmpty()) {
			Ground g = queue.poll();
			int x = g.x;
			int y = g.y;
			char waterType = groundUsed[x][y].waterType;
			int time = groundUsed[x][y].time;
			
			if(time == -1) continue;
			
			for(int i =0; i< 4; i++) {
				int newX = x + moveX[i];
				int newY = y + moveY[i];
				if(newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
				if(board[newX][newY] == 0) continue;
				if(groundUsed[newX][newY] == null) {
					queue.offer(new Ground(newX, newY));
					groundUsed[newX][newY] = new WaterState(waterType, time+1);
					continue;
				}
				if(groundUsed[newX][newY].waterType != waterType && groundUsed[newX][newY].time == time+1) {
					groundUsed[newX][newY].time = -1;
					count++;
				}
				
			}
		}
		
		return count;
	}
	
	private static class Ground {
		int x, y;
		public Ground(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static class WaterState {
		char waterType;
		int time;
		public WaterState(char waterType, int time) {
			this.waterType = waterType;
			this.time = time;
		}
	}

}


/*
최대 꽃의 개수 저장 MaxCo0unt
N, M, R, G , totalWater(water 저장된 크기)


배양액을 심을 수 있는 위치를 저장하는 배열 : canGround => 10개로 고정
x, y를 관리할 ground 클래스
전 땅을 저장할 배열 : board
배양액 초록색과 빨간색 개수만큼 저장할 배열(g, r) : water
water를 조합 할 배열 combination
=> 배양액을 뿌릴 수 있는 땅이 배양액 수보다 크거나 같으므로 배양액에 토양 차이만큼 빈 공간을 더해준다


중복 원소들이 있는 중복 허용하지 않은 백트래킹 먼저 만들기 => 성공

bfs
상하좌우로 움직이게 하는 moveX, moveY 배열
꽃의 개수 저장 count

큐를 생성
combination(어느 위치에 배양액을 뿌릴지 저장한 배열)에 저장되어있는 배양액의 종류에 맞추어 위치를 큐에 push
groundUsed(땅을 사용했는지 아닌지 확인하고 정보를 저장하는 배열)에 waterType(배양액의 종류)와 time(시간) 0을 저장함

while 큐가 빌때까지
	큐를 pop에서 x, y 값 저장
	for문 4번 (상하좌우)
		newX, newY를 생성
		만약 board의 범위를 벗어나거나 board 값이 0이면 continue
		만약 groundUsed 값이 null이라면
			queue.push newX, newY
			groundUsed newx, newY에 new WaterState를 해서 저장
			continue;
		newX, newY의 groundUsed.WaterState.waterType이 
				현재 groundUsed.WaterState.waterType과 다르고 time이 같다면 
				count++, waterType을 flower로 수정

count값을 리턴
			
		







*/