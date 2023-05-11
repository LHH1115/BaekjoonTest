import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 백준 2164 카드2
// https://www.acmicpc.net/problem/2164

public class Main { public static void main(String[] args) {
  
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();

    sc.close();
    
    if(N == 1){
        System.out.println(1);
        return;
    }
    
    Deque<Integer> d = new LinkedList<>();

    for(int i=1; i<=N; i++){
        d.add(i);
    }

    int temp = 0;

    while(d.size() > 1){
        d.pollFirst();
        temp = d.pollFirst();
        d.addLast(temp);
    }

    System.out.println(temp);
    
    }
}