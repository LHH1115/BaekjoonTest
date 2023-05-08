import java.util.Scanner;
import java.util.Stack;

// 백준 10828 균형잡힌 세상
// https://www.acmicpc.net/problem/10828
 
public class Main {
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		String str = null;
		
		for(int i=0; i<N; i++) {
			str = sc.next();
			switch (str) {
			case "push":
				stack.push(sc.nextInt());
				break;

			case "pop":
				if(stack.empty())
					sb.append(-1).append('\n');
				else
					sb.append(stack.pop()).append('\n');
				break;
				
			case "size":
				sb.append(stack.size()).append('\n');
				break;
			
			case "empty":
				if(stack.empty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
				
			case "top":
				Integer temp = -1; 
				if(stack.empty())
					sb.append(-1).append('\n');
				else {
					temp = stack.pop();
					sb.append(temp).append('\n');
					stack.push(temp);
				}
				break;
			}
		}
		System.out.println(sb);
		sc.close();
	}
}