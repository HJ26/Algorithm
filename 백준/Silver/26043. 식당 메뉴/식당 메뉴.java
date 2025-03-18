import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 정보의 개수
		
		List<Integer> A = new LinkedList<>(); // 원하는걸 먹은 학생
		List<Integer> B = new LinkedList<>(); // 원하지 않는걸 먹은 학생
		Queue<int[]> list = new LinkedList<>(); // 식당 줄
		
		int[] member;
		int type, a, b;
		StringTokenizer st;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken()); // 유형
			
			switch (type) {
			case 1:
				a = Integer.parseInt(st.nextToken()); // 학생의 번호
				b = Integer.parseInt(st.nextToken()); // 좋아하는 메뉴
				member = new int[2];
				member[0] = a;
				member[1] = b;
				
				list.add(member);
				break;
			case 2:
				b = Integer.parseInt(st.nextToken()); // 준비된 메뉴 번호
				member = list.poll();
				
				if (member[1] == b) { // 원하는 메뉴를 먹었을 때
					A.add(member[0]);
				} else { // 원하지 않은 메뉴를 먹었을 때
					B.add(member[0]);
				}
				
				break;
			}
		}
		
		if (A.size() == 0) { // 원하는 메뉴를 먹은 학생이 없다면
			sb.append("None");
		} else {
			Collections.sort(A);
			
			for (int nn : A) {
				sb.append(nn).append(" ");
			}
		}
		
		sb.append("\n");
		
		if (B.size() == 0) { // 원하지 않은 메뉴를 먹은 학생이 없다면
			sb.append("None");
		} else {
			Collections.sort(B);
			
			for (int nn : B) {
				sb.append(nn).append(" ");
			}
		}
		
		sb.append("\n");
		
		if (list.size() == 0) { // 못 먹은 학생이 없다면
			sb.append("None");
		} else {
			List<Integer> C = new LinkedList<>(); // 못 먹은 학생
			
			while (!list.isEmpty()) {
				C.add(list.poll()[0]);
			}
			
			Collections.sort(C);
			for (int nn : C) {
				sb.append(nn).append(" ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}