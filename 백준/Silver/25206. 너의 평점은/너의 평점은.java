import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Double> scoreList = new HashMap<>();
		
        // 학점 별 점수
		scoreList.put("A+", 4.5);
		scoreList.put("A0", 4.0);
		scoreList.put("B+", 3.5);
		scoreList.put("B0", 3.0);
		scoreList.put("C+", 2.5);
		scoreList.put("C0", 2.0);
		scoreList.put("D+", 1.5);
		scoreList.put("D0", 1.0);
		scoreList.put("F", 0.0);

		double sum = 0;
		int nSbj = 0;
		
		for(int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();	// 과목명 넘어가기
			double score = Double.parseDouble(st.nextToken());    // 학점
			String grade = st.nextToken();                        // 성적
			
			if(!scoreList.containsKey(grade)) continue;
			sum += scoreList.get(grade) * score;
			nSbj += score;
		}
		
		System.out.printf("%.6f\n", sum/nSbj);
		
		
	}
}
