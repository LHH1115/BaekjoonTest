import java.util.Scanner;

// 백준 2003 수들의 합 2
// https://www.acmicpc.net/problem/2003

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int cnt = 0;
        
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += arr[j];
                if (sum == K) {
                    cnt++;
                }
            }
        }


        System.out.println(cnt);
    }
}