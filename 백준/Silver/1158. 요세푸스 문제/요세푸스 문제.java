import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 백준 1158 요세푸스 문제
// https://www.acmicpc.net/problem/1158

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        sc.close();

        Deque<Integer> d = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            d.add(i);
        }

        while (!d.isEmpty()) {
            for (int i=0; i<K-1; i++) {
              d.addLast(d.pollFirst());
            }
            list.add(d.pollFirst());
        }

        sb.append("<");
        for (int i=0; i<list.size(); i++) {
            if (i == list.size() - 1)
                sb.append(list.get(i)).append(">");
            else
                sb.append(list.get(i)).append(", ");
        }

        System.out.println(sb);
    }
}