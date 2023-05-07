import java.util.Scanner;
import java.util.Stack;

// 백준 9012 괄호
// https://www.acmicpc.net/problem/9012

public class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			System.out.println(stack(sc.next()));
		}
		sc.close();
	}
 
	public static String stack(String str) {
 
		Stack<Character> stack = new Stack<>();
 
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
 
			if (ch == '(')
				stack.push(ch);
			else if (stack.empty())
				return "NO";
			else
				stack.pop();
		}
 
		if (stack.empty())
			return "YES";
		else
			return "NO";
	}
}