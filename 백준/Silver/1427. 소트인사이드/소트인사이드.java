import java.util.*;

// 백준 1427 소트인사이드
// https://www.acmicpc.net/problem/1427

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
    }
}
