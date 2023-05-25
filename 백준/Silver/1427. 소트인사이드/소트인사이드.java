import java.util.*;

// 백준 1427 소트인사이드
// https://www.acmicpc.net/problem/1427

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int[] arr = new int[N.length()];
        for(int i=0; i<N.length(); i++){
            arr[i] = Integer.parseInt(N.substring(i, i+1));
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }

        System.out.println(sb.toString());
    }
}
