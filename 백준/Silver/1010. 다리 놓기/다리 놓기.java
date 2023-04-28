import java.util.Scanner;

public class Main {
	
    // 이항계수를 저장할 배열
	static int[][] dp = new int[30][30];
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        // 테스트 케이스 개수 입력받기
		int T = sc.nextInt();
		
        // 출력 결과를 저장할 StringBuilder
		StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < T; i++) {
            // 각 테스트 케이스마다 다리의 개수 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
						
            // StringBuilder에 현재 테스트 케이스의 결과값 추가하기
			sb.append(combi(M, N)).append('\n');
		}
		
		sc.close();
		
        // 모든 테스트 케이스 결과값 출력하기
		System.out.println(sb);
		
	}
	
    // 이항계수를 계산하는 함수
	static int combi(int n, int r) {
        // 이미 계산된 값이 있는 경우, 저장된 값을 리턴
		if(dp[n][r] > 0) {
			return dp[n][r]; 
		}
		
        // nCn과 nC0의 값은 1
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
        // 이항계수의 성질을 이용해 값을 계산
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}
