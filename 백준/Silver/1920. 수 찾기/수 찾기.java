import java.util.*;

// 백준 1920 수찾기
// https://www.acmicpc.net/problem/1920

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];

        for(int i=0; i<N; i++){
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            if(Arrays.binarySearch(a, sc.nextInt()) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
        }

        sc.close();

        System.out.println(sb);
    }
}