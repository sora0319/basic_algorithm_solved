package code;

import java.util.*;
import java.io.*;
public class No_18808 {
    private static int N, M, K;
    private static int[][] noteBook;
    private static int[][] moveX = {{-1,1,0,0}, {0,0,1,-1}, {}, {}};
    private static List<int[][]> stickers = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        noteBook = new int[N][M];

        // save stickers
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[x][y];
            for (int j = 0; j < x; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < y; z++) {
                    sticker[j][z] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(sticker);
        }






        br.close();
        bw.flush();
        bw.close();
    }
}


/*
1. 첫번째 스티커 사용 0
2. 두번째 스티커 넣지 않음 0
3. 두번째 스티커 회전 90
4. 두번째 스티커 넣음
5. 세번째 스티커 넣지 않음 0
6. 세번재 스티커 회전 90
7. 세번째 스티커 회전 180
8. 세번재 스티커 회전 270
9. 세번째 스티커 넣지 않음
10. 네번째 스티커 넣지 않음 0
11. 네번재 스티커 회전 90
12. ....



사용해야 할 도구
- 스티커의 모양에 맞게 노트북의 공간이 있는지 확인
- 90.180.270 으로 돌리는 과정을 직접 구현? 또는 코드로 임시 방편
- 공간 확인 시 dfs bfs ?
- 새로운 스티커를 붙일 때 시작 지점을 찾는 과정


10*10*100+10*10*4*100*40*40

0.90.180.270 회전

0
0.0 0.1 0.2
1.0 1.1 1.2
2.0 2.1 2.2
3.0 3.1 3.2
상하좌우 0.0
x -1.1.0.0
y 0.0.-1.1

90
3.0 2.0 1.0 0.0
3.1 2.1 1.1 0.1
3.2 2.2 1.2 0.2
상하좌우 3.0
x 0.0.1.-1
y -1.1.0.0

180
3.2 3.1 3.0
2.2 2.1 2.0
1.2 1.1 1.0
0.2 0.1 0.0
상하좌우 3.2
x 1.-1.0.0
y 0.0.1.-1

270
0.2 1.2 2.2 3.2
0.1 1.1 2.1 3.1
0.0 1.0 2.0 3.0
상하좌우 0.2
x 0.0.-1.1
y 1.-1.0.0

 */