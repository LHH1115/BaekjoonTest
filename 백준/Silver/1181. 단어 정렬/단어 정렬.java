import java.util.*;

// 백준 1181 단어 정렬
// https://www.acmicpc.net/problem/1181

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        String[] arr = new String[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.next();
        }

        sc.close();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() < b.length()) {
                    return -1;
                } else if (a.length() > b.length()) {
                    return 1;
                } else {
                    return a.compareTo(b);
                }
            }
        });

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
        Set<String> set = new LinkedHashSet<String>(list);
        String[] uniqueArr = set.toArray(new String[set.size()]);

        for(String str : uniqueArr){
            sb.append(str).append('\n');
        }

        System.out.println(sb);
    }
}