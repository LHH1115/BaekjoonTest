import java.util.Scanner;

// 백준 11726 2xn 타일링
// https://www.acmicpc.net/problem/11726

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        dp = new int[n + 1];

        System.out.println(countTile(n));
    }

    public static int countTile(int n){
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        return dp[n];
    }
}