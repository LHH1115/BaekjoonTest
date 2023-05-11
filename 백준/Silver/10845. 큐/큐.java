import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 백준 10845 큐
// https://www.acmicpc.net/problem/10845

public class Main { public static void main(String[] args) {

    Deque<Integer> q = new LinkedList<>();
    
    Scanner sc = new Scanner(System.in);
    
    StringBuilder sb = new StringBuilder();
    
    int N = sc.nextInt();
    
    String str = null;

    int temp = 0;
    
    for(int i=0; i<N; i++) {
        str = sc.next();
        switch (str) {
        case "push":
            temp = sc.nextInt();
            q.add(temp);
            break;

        case "pop":
            if(q.isEmpty()){
                sb.append(-1).append('\n');
            }else{
                sb.append(q.pollFirst()).append('\n');
            }
            break;
            
        case "size":
            sb.append(q.size()).append('\n');
            break;
        
        case "empty":
            if(q.isEmpty()){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
            break;
            
        case "front":
            if(q.isEmpty()){
                sb.append(-1).append('\n');
            }else{
                sb.append(q.peekFirst()).append('\n');
            }
            break;

        case "back":
            if(q.isEmpty()){
                sb.append(-1).append('\n');
            }else{
                sb.append(q.peekLast()).append('\n');
            }
            break;
            }
        }
    System.out.println(sb);
    sc.close();
    }
}