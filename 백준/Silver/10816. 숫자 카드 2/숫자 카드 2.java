import java.util.*;

// 백준 10816 숫자 카드 2
// https://www.acmicpc.net/problem/10816

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();

        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            String number = sc.next();
            if(map.containsKey(number)){
                map.put(number, (map.get(number) + 1));
            }else{
                map.put(number, 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();

        for(int i=0; i<M; i++){
            String test = sc.next();
            if(map.containsKey(test)){
                sb.append(map.get(test)).append(" ");
            }else{
                sb.append("0 ");
            }
        }

		sc.close();

        System.out.println(sb);
    }
}
