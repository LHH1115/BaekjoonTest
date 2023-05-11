import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 백준 10866 덱
// https://www.acmicpc.net/problem/10866

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        Deque<Integer> d = new LinkedList<>();

        String s;
        int temp;

        for(int i=0; i<N; i++){
            s = sc.next();
            switch (s) {
                case "push_front":
                        d.addFirst(sc.nextInt());
                    break;
                
                case "push_back":
                    d.addLast(sc.nextInt());
                    break;
                
                case "pop_front":
                    if(d.isEmpty())
                        sb.append(-1).append('\n');
                    else{
                        temp = d.pollFirst();
                        sb.append(temp).append('\n');
                    }
                    break;
                
                case "pop_back":
                if(d.isEmpty())
                    sb.append(-1).append('\n');
                else{
                    temp = d.pollLast();
                    sb.append(temp).append('\n');
                }
                    break;
                
                case "size":
                    sb.append(d.size()).append('\n');
                    break;

                case "empty":
                    if(d.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;
                
                case "front":
                    if(d.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(d.peekFirst()).append('\n');
                    break;
                
                case "back":
                    if(d.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(d.peekLast()).append('\n');
                    break;
            }
        }
        sc.close();
        System.out.println(sb);
    }
}
