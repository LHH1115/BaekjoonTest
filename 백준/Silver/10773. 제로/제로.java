import java.util.Scanner;
import java.util.Stack;

// 백준 10773 제로
// https://www.acmicpc.net/problem/10773

public class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<K; i++) {
			int temp = sc.nextInt();
			if(temp != 0) {
				stack.push(temp);
			}else {
				stack.pop();
			}
		}
		
		int result = 0;
		
		while(!stack.empty()) {
			result = result + stack.pop();
		}
		
		System.out.println(result);
	}
}