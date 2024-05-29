package code;

import java.io.*;
import java.util.*;

public class No_1799 {
	private static int maxCount = -1;
	private static boolean maxCheck = false;
	private static int[] piece = {1,2}; // 1 - 비숍, 2- 빈칸
	private static Pair[] possible = new Pair[100];
	private static int[] moveX = {-1, 1, -1, 1};
	private static int[] moveY = {-1, -1, 1, 1};
	private static int[][] board;
	private static int[] combination;
	private static int N, possibleCount = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					possible[possibleCount++] = new Pair(i, j);
				}
			}
		}
		
		combination = new int[possibleCount];
		backtracking(0);
		bw.write(String.valueOf(maxCount));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void backtracking(int order) {
		if(order == possibleCount) {
			int count = bfs();
						//if(maxCount >= count) maxCheck = true;
			if(maxCount < count) maxCount = count;
			return;
		}
		
		for(int i = 0; i < 2; i++) {
			combination[order] = piece[i];
			backtracking(order+1);
		}
	}
	
	private static int bfs() {
		int count = 0;
		boolean meeting = false;
		int[][] bishop = new int[N][N];
		Queue<Pair> queue = new ArrayDeque<>();
//		int[] c = {1,1,1,1,2,1,2,1,2,2,2,1,2};
		
		for(int i = 0; i < combination.length; i++) {
			if(combination[i] == 1) {
				count++;
				queue.offer(possible[i]);
				bishop[possible[i].x][possible[i].y] = 1;
			}
		}
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			for(int i = 0; i < 4; i++) {
				meeting = checkDepth(pair, bishop, i);
				if(meeting) break;
			}
			if(meeting) break;
		}
		if(meeting) return 0;
		return count;
	}
	
	private static boolean checkDepth(Pair pair, int[][] bishop, int direction) {
		boolean meeting = false;
		Queue<Pair> queue = new ArrayDeque<>();
		queue.offer(pair);
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			int newX = p.x + moveX[direction];
			int newY = p.y + moveY[direction];
			
			if(newX < 0 || newX >= N || newY < 0 || newY >= N) break;
			if(bishop[newX][newY] == 1) {
				meeting = true;
				break;
			}
			queue.offer(new Pair(newX, newY));
		}
		
		return meeting;
	}

	private static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

/*
backtracking + bfs

0. 배열 및 값 저장
- static 클래스 Pair 생성 (x, y 값 저장) 
- static int maxCount = -1 
- static boolean maxCheck = false
- static int[] piece = {1,2} => 1 = 비숍, 2 = 빈칸 생성
- static Pair[] possible = new int[100] => 체스 보드의 최대 칸의 개수는 10*10이므로
- static boolean maxCheck = false
- static int possibleCount = 0

- 체스판의 크기 N 저장
- N*N 크키의 체스판 board static int 배열 생성
- board에 체스판 상태를 저장, 만약 값이 1이 있다면 possible에 저장하고 possibleCount++
- possibleCount의 크기 만큼의 combination static int 배열 생성


1. backtracking
=> 비숍을 놓을 수 있는 칸이 정해져 있고, 그 칸에서 1 = 비숍, 2 = 빈칸으로 생각하고 모든 경우의 조합을 찾는다

- combination에 저장하는 순서를 표시하는 int order, 시작하는 위치를 변수로 받는다
- if maxCheck return

- if order == possibleCont
	- int count = bfs()
	- if maxCount < count maxCount = count
	- if maxCount >= count maxCheck = true

- for 문 반복 0부터 2까지
	- combination[order] = piece[i]
	- backtracking(order+1)

--------------------------------------------
2. bfs 변형
=> combination에 저장되어 있는 정보를 가지고 값이 1 - 비숍 인 위치에 해당하는 possible 값을 큐에 저장 한 후 
	각 위치에서 각 방향으로 이동을 해서 다른 비숍이 존재를 하면 count = 0

-1-1 -10 -11
0-1 00 01
1-1 10 11

- bfs에 필요한 이동 배열 static (대각선 이동)
	moveX = {-1, 1, -1, 1}
	moveY = {-1, -1, 1, 1}
- board에 비숍이 어디에 있는지 저장한 이차원 배열 int bishop
- int count = 0; // 비숍의 개수 저장 
- boolean meeting = false; // 비숍과 다른 비숍이 만나는지를 저장
	
- Pair를 저장할 수 있는 큐를 생성
- for문 0부터 combination length 만큼
	- if combination[i] == 1
		count++; // 놓아져 있는 비숍의 개수 저장
		큐에 possible[i]에 저장된 Pair 값을 저장
		Pair.x, Pair.y 의 위치의 bishop 값을 1로 저장

- while(큐가 빌때까지)
	- pair = 큐 push
	- for 4번 반복
		- 한 대각선으로 이동했을 때 다른 비숍을 만나게 되면 if(meeting == true), break
		- meeting = checkDepth(pair, i) // 한방향 탐색
	- 만약 meeting == true 이면 break	
		
- 만약 meeting == true 이면 return 0


----------------------------------------
3. boolean checkDepth(Pair pair, int direction)
=> 비숍이 이동할 수 있는 대각선 거리에 비숍이 존재하는지 확인하는 함수
=> 한방향으로 바로 나아가면서 그 위치에 비숍이 놓아져 있는지 확인한다

boolean meeting = false;

- Pair값을 저장하는 큐 생성
- 큐에 pair 값을 저장
- while(큐가 빌때까지)
	- pair = 큐 pop
	- newX, newY 값을 pair.x + moveX[direction], pair.y + moveY[direction] 로 저장
	- 만약 board의 범위를 벗어났다면 break
	- 만약 bishop[newX, newY] == 1이면 meeting = true, break
	- 큐 push pair(newX, newY)

- return meeting
*/
