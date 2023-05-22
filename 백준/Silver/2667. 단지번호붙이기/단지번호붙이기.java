import java.util.*;

// 백준 2667 단지번호붙이기
// https://www.acmicpc.net/problem/2667

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        List<Integer> danji = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        sc.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    danji.add(dfs(map, visited, i, j, N, 0));
                }
            }
        }

        Collections.sort(danji);
        System.out.println(danji.size());
        for (int count : danji) {
            System.out.println(count);
        }
    }

    public static int dfs(int[][] map, boolean[][] visited, int x, int y, int N, int count) {
        visited[x][y] = true;
        count++;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    count = dfs(map, visited, nx, ny, N, count);
                }
            }
        }

        return count;
    }
}