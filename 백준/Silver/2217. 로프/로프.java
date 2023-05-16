import java.util.Arrays;
import java.util.Scanner;

// 백준 2217 로프
// https://www.acmicpc.net/problem/2217


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] ropes = new int[n];

        for (int i=0; i<n; i++) {
            ropes[i] = Integer.parseInt(sc.nextLine());
        }

        Arrays.sort(ropes);
        int maxWeight = 0;

        for (int i=n-1; i>=0; i--) {
            int weight = ropes[i] * (n - i);
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        System.out.println(maxWeight);

        sc.close();
    }
}
