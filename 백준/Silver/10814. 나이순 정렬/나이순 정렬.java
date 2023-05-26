import java.util.*;

// 백준 10814 나이순 정렬
// https://www.acmicpc.net/problem/10814
 
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);

		List<HashMap<Integer, String>> list = new ArrayList<>();
		HashMap<Integer, String> map = new HashMap<>();

		int N = sc.nextInt();

		for(int i=0; i<N; i++){
			map = new HashMap<>();
			map.put(sc.nextInt(), sc.next());
			list.add(i, map);
		}

		sc.close();

		list.sort(new Comparator<HashMap<Integer, String>>(){
			@Override
			public int compare(HashMap<Integer, String> o1, HashMap<Integer, String> o2){
				return o1.keySet().iterator().next().compareTo(o2.keySet().iterator().next());
			}
		});
		
		for(int i=0; i<N; i++){
			System.out.println(list.get(i).keySet().iterator().next() + " " + list.get(i).values().iterator().next());
		}
	}
}