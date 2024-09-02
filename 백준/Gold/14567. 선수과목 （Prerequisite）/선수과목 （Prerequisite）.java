import java.io.*;
import java.util.*;

public class Main {
	
    // 수업 정보를 저장할 클래스
    static class Class{
		int idx;
		int semester;
		
		public Class() {}

		public Class(int idx, int semester) {
			this.idx = idx;
			this.semester = semester;
		};
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		// 각 과목의 진입차수를 저장할 배열
		int[] indegree = new int[N];
		// 과목별 다음 과목 정보를 저장할 리스트
		List<Integer>[] edges = new ArrayList[N];
		for(int i = 0; i < N; i++) edges[i] = new ArrayList<Integer>();
		
		// 정보 저장
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken())-1;
			int next = Integer.parseInt(st.nextToken())-1;
			
			edges[pre].add(next);
			indegree[next]++;
			
		}
		
		// 인덱스정보와 학기정보를 같이 큐에 저장
		Queue<Class> que = new LinkedList<>();
		int[] rslt = new int[N];
		
		// 진입차수가 0인 과목 큐에 추가
		for(int i = 0; i < N; i++) {
			if(indegree[i] == 0) que.add(new Class(i,1));
		}
		
		while(!que.isEmpty()) {
			
			Class cur = que.poll();
			int curIdx = cur.idx;
			int curSemester = cur.semester;
			rslt[curIdx] = curSemester;
			
			// 현재 수업을 들으면 차수가 0이 되는 과목 학기에 추가
			for(int i : edges[curIdx]) {
				if(--indegree[i] == 0) que.add(new Class(i, curSemester+1));
			}
		}
		
		for(int i = 0; i < N; i++) sb.append(rslt[i]).append(" ");
		System.out.println(sb.toString());
	}
}
