import java.util.Scanner;

// 백준 1018 체스판 다시 칠하기
// https://www.acmicpc.net/problem/1018

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] board = new char[N][M];
        sc.nextLine();

        for (int i=0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<=N-8; i++) {
            for (int j=0; j<=M-8; j++) {
                int count = countPaint(board, i, j);
                min = Math.min(min, Math.min(count, 64 - count));
            }
        }

        sc.close();

        System.out.println(min);
    }

    public static int countPaint(char[][] board, int x, int y) {

        int count = 0;
        for (int i=x; i<x+8; i++) {
            for (int j=y; j<y+8; j++) {
                if ((i+j)%2 == 0) {
                    if (board[i][j] == 'B') {
                        count++;
                    }
                } else {
                    if (board[i][j] == 'W') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}