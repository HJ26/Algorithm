import java.io.*;
import java.util.*;

// 좌표 정보를 저장할 클래스
class Node{
	int x;	// x 좌표
	int y;	// y 좌표
	
	public Node() {}
	
	public Node(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}

	
}
public class Main {
	
	static int nStore;		// 편의점 개수
	static Node home;		// 집 위치
	static Node[] stores;	// 편의점 위치 배열
	static Node penta;		// 펜타포트 위ㅣ
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			nStore = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			home = new Node(st.nextToken(), st.nextToken());
			stores = new Node[nStore];
			
			for(int n = 0; n < nStore; n++) {
				st = new StringTokenizer(br.readLine());
				stores[n] = new Node(st.nextToken(),st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			penta = new Node(st.nextToken(),st.nextToken()); 
			
			// 결과 저장
			String rslt = BFS();
			sb.append(rslt);
			sb.append("\n");
		}
		// 출력
		bw.write(sb.toString());
		bw.close();
	}

	private static String BFS() {
		
		// 편의점 방문 정보를 저장할 배열
		boolean[] visit = new boolean[nStore];
		
		// 방문한 위치를 저장할 큐
		Queue<Node> que = new LinkedList<Node>();
		que.add(home);	// 시작위치(집) 정보 저장
		
		// 큐가 빌때까지 반복
		while(!que.isEmpty()) {
			
			// 현재 위치 저장
			Node cur = que.poll();
			int curX = cur.x;
			int curY = cur.y;
			
			// 현재 위치부터 펜타포트까지의 거리가 1000 이하면 ( 맥주 20병으로 갈 수 있으면 ) happy 반환 후 저장
			if(Math.abs(penta.x - curX) + Math.abs(penta.y - curY) <= 1000) return "happy";
			
			// 갈 수 없다면 갈 수 있는 편의점으로 이동
			for(int i = 0; i < nStore; i++) {
				// 방문하지 않은 편의점일때
				if(!visit[i]) {
					
					// 다음 위치 저장
					Node next = stores[i];
					int nextX = next.x;
					int nextY = next.y;
					
					// 현재위치부터 다음위치까지의 거리 계산
					int dist = Math.abs(nextX - curX) + Math.abs(nextY - curY);
					
					// 해당 편의점으로 이동할 수 있으면
					if( dist <= 1000 ) {
						// 방문했다고 표시
						visit[i] = true;
						// 큐에 저장
						que.add(stores[i]);
					}
				}
			}
			
		}
		
		// 큐가 빌때까지 펜타포트에 가지 못했으면
		// sad 리턴 후 종료
		return "sad";
	}
}
