import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swexpert_3289 {

	static int [] parent;
	static int [] rank;
	static int [] ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int Tc = Integer.parseInt(br.readLine());
		
		for ( int tc = 1; tc <=Tc; tc++) {
			
			st = new StringTokenizer(br.readLine()," ") ;
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			rank = new int [N+1]; // 초기값 0 으로 저장 
			ans = new int [M]; 
			int idx =0;
			// 초기값 본인이 짱으로 저장 
			for ( int i=1; i<= N; i++) {
				parent[i] = i;
			}
			
			for ( int i=0; i<M; i++) {
				// 각 연산에 대해 입력받기
				st = new StringTokenizer(br.readLine(), " ");
				int is = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// 1이면 union
				if ( is == 0) union(a,b);
				
				// 0이면 find
				else if ( is == 1) {
					if ( find(a) == find(b)) {
						ans[idx++] = 1;
					}
					else ans[idx++] = 0;
				}
				
			}
			System.out.print("#"+tc+" ");
			for ( int i=0; i< idx ; i++) {
				System.out.print(ans[i]);
			}
			
			System.out.println();
		}
		
	}
	
	static int find(int x) {
		
		// 같으면 return x
		if ( parent[x] == x) return x ;
		
		// 다르면 또 검사
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union ( int x, int y) {
		
		int px = find(x);
		int py = find(y);
		
		if( px == py) return;
		else {
			if ( rank [px] > rank [py] ) 
				parent[py] = px ;
			else if ( rank [px] < rank [py])
				parent[px] = py;
			else {
				parent[py] = px;
				rank[py] ++;
			}
		}
	}
	
}
