import java.util.Scanner;

// 백준 1463 1로 만들기
// https://www.acmicpc.net/problem/1463

public class Main{
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
        
		int N = sc.nextInt();
		
		sc.close();
		
		System.out.println(findMin(N, 0));
	}
	
	public static int findMin(int N, int count) {
		if(N < 2) {
			return count;
		}
		return Math.min(findMin(N/2, count+1+(N%2)), findMin(N/3, count+1+(N%3)));
	}
}