import java.util.Arrays;
import java.util.Scanner;

// 백준 10828 균형잡힌 세상
// https://www.acmicpc.net/problem/10828
 
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		int tot = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(arr);
		
		for(int i=arr.length-1; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				tot+= arr[j];
			}
		}
		
		System.out.println(tot);
	}
}