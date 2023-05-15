import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

// 백준 1620 나는야 포켓몬 마스터 이다솜
// https://www.acmicpc.net/problem/1620

public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 8192);

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] array = new String[N];
        
        for (int i=0; i<N; i++) {
            String s = sc.next();
            hashMap.put(s, i);
            array[i] = s;
        }

        for (int i=0; i<M; i++) {
            String input = sc.next();

            if (Character.isDigit(input.charAt(0))) {
                int num = Integer.parseInt(input);
                bw.write(array[num-1] + "\n");
            } else {
                bw.write((hashMap.get(input)+1) + "\n");
            }
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}
