import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int N = sc.nextInt(), Q = sc.nextInt();
	    
	    // 각 노드의 인접 리스트를 저장할 List<int[]> 배열을 선언하고 초기화한다.
	    List<int[]>[] adj = new ArrayList[N + 1];
	    for (int i = 1; i <= N; i++)
	        adj[i] = new ArrayList<>();

	    // 노드 간의 간선 정보를 입력받아 인접 리스트에 저장한다.
	    for (int i = 1; i < N; i++) {
	        int p = sc.nextInt(), q = sc.nextInt(), r = sc.nextInt();
	        adj[p].add(new int[]{q, r});
	        adj[q].add(new int[]{p, r});
	    }

	    // 결과를 저장할 StringBuilder 객체 sb를 선언하고 초기화한다.
	    StringBuilder sb = new StringBuilder();
	    
	    // 각 쿼리마다 정답을 찾아서 StringBuilder 객체에 저장한다.
	    for (int i = 0; i < Q; i++) {
	        
	        // 최소 길이 k와 시작 노드 v를 입력받는다.
	        int k = sc.nextInt(), v = sc.nextInt();

	        // 각 노드의 방문 여부를 저장할 boolean 배열 visit을 선언하고 초기화한다.
	        boolean[] visit = new boolean[N + 1];
	        visit[v] = true;

	        // BFS 탐색을 위한 Queue<Integer> 객체 que를 선언하고 시작 노드 v를 넣는다.
	        Queue<Integer> que = new LinkedList<>();
	        que.add(v);

	        // BFS 탐색을 수행하면서 최소 길이 이상인 간선을 따라 탐색한 노드의 개수를 센다.
	        int ans = 0;
	        while (!que.isEmpty()) {
	            int cur = que.poll();
	            for (int[] a : adj[cur]) {
	                if (!visit[a[0]] && a[1] >= k) {
	                    que.add(a[0]);
	                    visit[a[0]] = true;
	                    ans++;
	                }
	            }
	        }
	        
	        // StringBuilder 객체에 정답을 저장한다.
	        sb.append(ans).append('\n');
	    }
	    
	    // Scanner 객체를 닫는다.
	    sc.close();
	    
	    // 결과를 출력한다.
	    System.out.println(sb.toString());
	}
}