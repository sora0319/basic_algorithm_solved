package code;

public class No_1941 {

	public static void main(String[] args) {
		

	}

}


/*
 * bfs를 사용한 문제풀이 큐 활용
 * 25개의 자리 별로 bfs를 돌리면서 자리가 7개가 되면 S가 4개 이상이 있는지 확인하며 경우의 수 구함
 * 
 * 사용하는 배열
 * - 5*5 자리를 저장하는 2차원 int 배열 seats
 * - 5*5 자리를 방문한 기록을 남기는 boolean 배열 visited
 * - 7개 가지를 저장하는 int 배열 group
 * - 상하좌우 움직일 수 있게 하는 int 배열 moveX, moveY
 * 
 * 변수
 * - local : group의 index : order = 0
 * - global : group의 개수 저장 : count = 0
 * 
 * 
 * 순서
 * - 자리를 저장받아 seats에 넣기
 * - 반복문 25개 자리 반복
 * - bfs 함수 생성 => 각 자리 위치 파라미터로 입력 받기
 * 
 * - bfs 함수
 * - 입력 받은 파라미터 자리에서 시작
 * - 큐 생성
 * - 입력 받은 자리를 큐에 삽입
 * - group[order++]에 자리 저장
 * 
 * - 4번 반복문
 * 		큐 pop()
 * 		새로운 newX, newY의 값을 moveX, moveY를 이용해 생성
 * 		만약 newX, newY 값이 5*5 범위를 벗어난다면 continue
 * 		큐에 newX, newY를 Pair로 만든 것을 push()
 * 		visited에 newX, newY를 true로 변경
 * 		group[order++]에 newX, newY를 저장
 * 		만약 order == 7이라면 
 * 			만약 checkSeat함수 실행이 true 면 count++
 * 			
 * 
 * - boolean checkSeat 함수
 * 		int S = 0;
 * 		for 반복문 7번 반복
 * 			x, y = group[i]
 * 			만약 seat[x][y] == S 라면 S++
 * 
 * 		만약 S >= 4 true
 * 		false
 * 			
 * - x, y를 저장할 클래스 Pair
 * 
 * 
 * 
 */









