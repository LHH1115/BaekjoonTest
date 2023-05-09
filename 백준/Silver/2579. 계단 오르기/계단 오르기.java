import java.util.Scanner;

// 백준 2579 계단 오르기
// https://www.acmicpc.net/problem/2579

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        int[] dp = new int[n];

        for (int i=0; i<n; i++) {
            score[i] = sc.nextInt();
        }

        sc.close();

        switch (n) {
            case 1:
                System.out.println(score[0]);
                return;
            case 2:
                System.out.println(score[0] + score[1]);
                return;
            default:
                dp[0] = score[0];
                dp[1] = score[0] + score[1];
                dp[2] = Math.max(score[0]+score[2], score[1]+score[2]);

                for (int i=3; i<n; i++) {
                    dp[i] = Math.max(dp[i-2]+score[i], dp[i-3]+score[i-1]+score[i]);
                }

                System.out.println(dp[n-1]);
        }
    }
}