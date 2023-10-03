import java.io.*;
import java.util.*;

public class Main {
	
	static class Student{
		int num;
		ArrayList<Integer> list;
		public Student(int num, ArrayList<Integer> list) {
			this.num = num;
			this.list = list;
		}
		
	}
	
	static class Place implements Comparable<Place>{
		
		int x, y, nLike, nEmpty;
		
		
		public Place(int x, int y, int nLike, int nEmpty) {
			this.x = x;
			this.y = y;
			this.nLike = nLike;
			this.nEmpty = nEmpty;
		}


		@Override
		public int compareTo(Place o) {
			if(this.nLike != o.nLike) return o.nLike - this.nLike;
			if(this.nEmpty != o.nEmpty) return o.nEmpty - this.nEmpty;
			if(this.x != o.x) return this.x - o.x;
			return this.y - o.y;
		}
		
	}
	
	static int N;
	static int map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans = 0;
	static ArrayList<Student>[] students;
	static HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		// 학생 정보 저장
		students = new ArrayList[N*N];
		for(int i= 0; i < N*N; i++) {
			students[i] = new ArrayList<>();	// 초기화
		}
		
		// 교실 정보 저장
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
		}
		
		// 학생 관계 정보 저장
		for(int i =0 ; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());	// 학생 번호
			ArrayList<Integer> tmp = new ArrayList<>();
			for(int j = 0; j < 4; j++) {	// 학생이 선호하는 학생 4명
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			students[i].add(new Student(num, tmp));
			hashMap.put(num, tmp);
		}
		
		// 각 학생별로 반복하면서 자리 배치하기
		for(int i = 0; i < N*N; i++) {
			Student n = students[i].get(0);
			getNLike(n);
		}
		
		// 만족도 계산하기
		for(int i =0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int studentNum = map[i][j];
				int cnt = 0;
				ArrayList<Integer> tmp = hashMap.get(studentNum);
				
				for(int k = 0; k < 4; k++) {
					int nextX = i + dx[k];
					int nextY = j + dy[k];
					if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N ) continue;
					
					if(tmp.contains(map[nextX][nextY])) cnt++;
				}
				switch(cnt) {
				case 0:
					ans += 0;
					break;
				case 1:
					ans += 1;
					break;
				case 2:
					ans += 10;
					break;
				case 3:
					ans += 100; 
					break;
				default:
					ans += 1000;
					break;
				}
			}
			
		}
		bw.write(Integer.toString(ans));
		bw.close();
		br.close();
	}


	private static void getNLike(Student student) {
		
		ArrayList<Place> place = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int nLike = 0;
				int nEmpty = 0;
				
				// 칸에 이미 앉은 사람이 있으면 넘어가기
				if(map[i][j] != -1) continue;
				
				// 인접 방향 탐색
				for(int k = 0; k < 4; k++) {
					int nextX = i + dx[k];
					int nextY = j + dy[k];
					if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N ) continue;
					
					if(student.list.contains(map[nextX][nextY])) nLike++;
					if(map[nextX][nextY] == -1) nEmpty++;
				}
				place.add(new Place(i,j,nLike,nEmpty));
			}
		}
		Collections.sort(place);
		Place p = place.get(0);
		map[p.x][p.y] = student.num;
	}


}

