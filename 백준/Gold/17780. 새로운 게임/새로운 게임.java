import java.util.*;

public class Main {
    static final int WHITE = 0, RED = 1, BLUE = 2; // 각 색상을 상수로 정의
    static final int[] change = { 1, 0, 3, 2 }; // 각 방향에 대한 반대 방향을 정의
    // →, ←, ↑, ↓
    static final int[] dr = { 0, 0, -1, 1 }; // 우, 좌, 상, 하 방향으로 이동하는 배열
    static final int[] dc = { 1, -1, 0, 0 }; 

    static int N, K; // 체스판 크기 N, 말의 개수 K
    static int[][] map; // 체스판 정보
    static ArrayList<Integer>[][] state; // 각 칸에 말이 어떤 말 위에 있는지 저장하는 리스트
    static Horse[] horses; // 각 말의 정보를 저장하는 객체 배열

    static class Horse { // 말의 정보를 저장하는 클래스
        int r, c, dir; // 위치(r, c)와 이동 방향(dir) 저장

        Horse(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 체스판 크기 입력
        K = sc.nextInt(); // 말의 개수 입력

        map = new int[N][N]; // 체스판 배열 생성
        state = new ArrayList[N][N]; // 각 칸에 말이 어떤 말 위에 있는지 저장하는 리스트 생성

        // 체스판 정보 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                state[i][j] = new ArrayList<>();
            }
        }

        horses = new Horse[K + 1]; // 1 ~ K번 말의 정보를 저장하는 객체 배열 생성

        // 각 말의 정보 입력
        for (int i = 1; i <= K; i++) {
            int r = sc.nextInt() - 1; // 체스판은 0부터 인덱스가 시작하므로 -1을 해줌
            int c = sc.nextInt() - 1;
            int dir = sc.nextInt() - 1; // 방향도 0부터 시작하므로 -1을 해줌
            horses[i] = new Horse(r, c, dir); // 말의 정보 저장
            state[r][c].add(i); // 해당 위치의 리스트에 말의 번호 추가
        }

        sc.close(); // 입력 종료

        System.out.println(start()); // start 함수 실행 결과 출력
    }

    private static int start() { // 게임 시작
        boolean flag = true; // 게임 종료 여부를 나타내는 플래그 변수
        int times = 0; // 몇 번째 턴인지 카운트하는 변수
        while (flag) { // 게임이 종료
            times++;
            if (times > 1000)
                break;

            for (int i = 1; i <= K; i++) {
                Horse h = horses[i];
                int r = h.r;
                int c = h.c;

                // 가장 아래쪽 말이 아니라면 PASS
                if (state[r][c].get(0) != i)
                    continue;

                int nr = r + dr[h.dir];
                int nc = c + dc[h.dir];

                // 말이 이동하려는 칸이 파란색인 경우 + 체스판을 벗어나는 경우
                if (!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    // 방향 반대로
                    h.dir = change[h.dir];
                    nr = r + dr[h.dir];
                    nc = c + dc[h.dir];
                }

                // 방향을 반대로 한 후에 이동하려는 칸이 파란색인 경우
                if (!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    continue;
                }
                // 말이 이동하려는 칸이 빨간색인 경우
                else if (map[nr][nc] == RED) {
                    // 순서를 반대로 모든 말이 이동
                    for (int j = state[r][c].size() - 1; j >= 0; j--) {
                        int tmp = state[r][c].get(j);
                        state[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    state[r][c].clear();
                }
                // 말이 이동하려는 칸이 흰색인 경우
                else {
                    // 모든 말이 이동
                    for (int j = 0; j < state[r][c].size(); j++) {
                        int tmp = state[r][c].get(j);
                        state[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    state[r][c].clear();
                }

                // 이동한 곳에 말이 4개 이상 있는가?
                if (state[nr][nc].size() >= 4) {
                    flag = false;
                    break;
                }
            }
        }
        // 1000회 초과 -1 반환
        return flag ? -1 : times;
    }

    static boolean isRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}