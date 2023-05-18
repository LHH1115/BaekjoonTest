import java.util.Scanner;

// 백준 1085 직사각형에서 탈출
// https://www.acmicpc.net/problem/1085

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y, w, h;
        x = sc.nextInt();
        y  = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();

        sc.close();

        int a = Math.min(Math.abs(0-x), Math.abs(w-x));
        int b = Math.min(Math.abs(0-y),Math.abs(h-y));
        System.out.println(Math.min(a, b));
    }
}