import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 백준 2164 카드2
// https://www.acmicpc.net/problem/2164

public class Main { public static void main(String[] args) {
  
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();

    sc.close();

    Deque<Integer> d = new LinkedList<>();

    for(int i=1; i<=N; i++){
        d.add(i);
    }

    while(d.size() > 1){
        d.pollFirst();
        d.addLast(d.pollFirst());
    }

    System.out.println(d.poll());
    
    }
}
