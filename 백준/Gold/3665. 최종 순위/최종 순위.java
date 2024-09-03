import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] indegree;
	static boolean[][] edges;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		// 테스트 케이스 반복
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			// 진입차수를 저장할 배열 ( 나보다 앞선 팀의 수 )
			indegree = new int[N];
			
			// 각 조별로 이미 관계가 나왔는지 체크할 배열
			edges = new boolean[N][N];
			
			// 지난 경기 결과 저장
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				
				int numTmp = Integer.parseInt(st.nextToken()) - 1;
				indegree[numTmp] = i;	// 3등이면 앞에 2팀이 있으므로 진입차수에 2 넣기
				
				// 현재 팀이 다른 팀과 연결된 적이 없다면
				// 내 팀을 기준으로 연결 안된 팀과 연결하기
				// 즉 상위 팀 -> 하위 팀 으로 방향그래프 생성
				for(int j = 0; j < N; j++) {
					if( j != numTmp && !edges[j][numTmp]) edges[numTmp][j] = true;
				}
			}
			
			// 바뀐 결과 저장
			M = Integer.parseInt(br.readLine());
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int teamA = Integer.parseInt(st.nextToken()) - 1;
				int teamB = Integer.parseInt(st.nextToken()) - 1;
				
				// 팀 순위 변경
				swap(teamA, teamB);
			}
			
			// 등수대로 출력
			sb.append(findRank()).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	// 팀 순위 변경
	private static void swap(int teamA, int teamB) {
		
		// 팀 우선순위 반전시키기
		if(edges[teamA][teamB]) {
			edges[teamA][teamB] = false;
			edges[teamB][teamA] = true;
			indegree[teamA]++;
			indegree[teamB]--;
		} else {		
			edges[teamA][teamB] = true;
			edges[teamB][teamA] = false;
			indegree[teamA]--;
			indegree[teamB]++;
		}
		
	}

	private static Object findRank() {
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			// 진입 차수가 0인 팀 큐에 넣기
			if(indegree[i] == 0) que.add(i);
		}
		
		// 모든 정점에 대하여 반복
		for(int i = 0; i < N; i++) {
			
			// 다음 팀이 없는 경우
			if(que.size() == 0) return "IMPOSSIBLE";
			
			// 다음 순위가 가능한 팀이 여러팀인 경우
			if(que.size() > 1) return "?";
			
			// 현재 팀 순위확정
			int cur = que.poll();
			sb.append(cur+1).append(" ");
			
			// 다른 팀 정렬
			for(int j = 0; j < N; j++) {
				if(edges[cur][j]) {						// 지금 팀 기준 하위에 있는 팀이라면
					edges[cur][j] = false;				// 순위 확정 끝난 팀 정보 지우고
					if(--indegree[j] == 0) que.add(j);	// 진입 차수가 0 이 되면 큐에 추가
				}
			}
			
		}
		return sb.toString();
	}
}


