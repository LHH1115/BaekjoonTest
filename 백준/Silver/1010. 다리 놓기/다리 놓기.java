import java.util.Scanner;
 
public class Main {
	
	static int[][] dp = new int[30][30];
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();	// N = r
			int M = sc.nextInt();	// M = n
						
			sb.append(combi(M, N)).append('\n');
		}
		
		sc.close();
		
		System.out.println(sb);
		
	}
	
	static int combi(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r]; 
		}
		
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}