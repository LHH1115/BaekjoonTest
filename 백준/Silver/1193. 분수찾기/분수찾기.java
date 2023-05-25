import java.util.*;

// 백준 1193 분수찾기
// https://www.acmicpc.net/problem/1193

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        int line_tot_sum = 0;
        int line_count = 1;

        while(true){
            if (X<=line_tot_sum+line_count) {
				if (line_count%2==1) {
					System.out.print((line_count-(X-line_tot_sum-1)) + "/" + (X-line_tot_sum));
					break;
				}else {
					System.out.print((X-line_tot_sum) + "/" + (line_count-(X-line_tot_sum-1)));
					break;
				}
			} else {
				line_tot_sum+=line_count;
				line_count++;
			}
        }
    }
}