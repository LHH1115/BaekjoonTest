import java.util.*;

public class Main {
	static final int WHITE = 0, RED = 1, BLUE = 2;
    static final int[] change = { 1, 0, 3, 2 };
    // →, ←, ↑, ↓
    static final int[] dr = { 0, 0, -1, 1 };
    static final int[] dc = { 1, -1, 0, 0 };

    static int N, K;
    static int[][] map;
    static ArrayList<Integer>[][] state;
    static Horse[] horses;

    static class Horse {
        int r, c, dir;

        Horse(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][N];
        state = new ArrayList[N][N];


        // 체스판 정보
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                state[i][j] = new ArrayList<>();
            }
        }
        // 말의 정보
        horses = new Horse[K + 1]; // 1 ~ K번 말
        for (int i = 1; i <= K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int dir = sc.nextInt() - 1;
            horses[i] = new Horse(r, c, dir);
            state[r][c].add(i);
        }
        
        sc.close();

        System.out.println(start());

    }

    private static int start() {
        boolean flag = true;
        int times = 0;
        while (flag) {
            times++;
            if (times > 1000)
                break;

            for (int i = 1; i <= K; i++) {
                Horse h = horses[i];
                int r = h.r;
                int c = h.c;

                if (state[r][c].get(0) != i)
                    continue;

                int nr = r + dr[h.dir];
                int nc = c + dc[h.dir];

                if(!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    h.dir = change[h.dir];
                    nr = r + dr[h.dir];
                    nc = c + dc[h.dir];
                }

                if (!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    continue;
                }else if (map[nr][nc] == RED) {
                    for (int j = state[r][c].size() - 1; j >= 0; j--) {
                        int tmp = state[r][c].get(j);
                        state[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    state[r][c].clear();
                }else {
                    for (int j = 0; j < state[r][c].size(); j++) {
                        int tmp = state[r][c].get(j);
                        state[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    state[r][c].clear();
                }
    			
    			if (state[nr][nc].size() >= 4) {
                    flag = false;
                    break;
                }
    		}
    	}
    	
    	return flag ? -1 : times;
    }
    
    static boolean isRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}