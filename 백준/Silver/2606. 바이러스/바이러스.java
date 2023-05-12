import java.util.ArrayList;
import java.util.Scanner;

// 백준 2606 바이러스
// https://www.acmicpc.net/problem/2606

public class Main {
    static ArrayList<Integer>[] a;
    static boolean visit[];
    static int n, m, v;
    static int count = 0;
    public static void dfs(int i) {
        visit[i] = true;
        for(int k : a[i]) {
            if(visit[k] == false) {
                count ++;
                dfs(k);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = 1;
        a = new ArrayList[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            a[j-1].add(k-1);
            a[k-1].add(j-1);
        }
        dfs(v-1);
        System.out.println(count);
        sc.close();
    }
}
