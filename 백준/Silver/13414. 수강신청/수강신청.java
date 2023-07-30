import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 수강신청 인원 한계 & 신청 횟수
		String[] nums = br.readLine().split(" ");
		int maxN = Integer.parseInt(nums[0]);
		int clickN = Integer.parseInt(nums[1]);
		String studentID;
		
		// 수강신청 리스트 받기
		LinkedHashSet<String> classStudent = new LinkedHashSet<>();
		//List<String> classStudent = new ArrayList<>();
		int j = 0;
		
		for(int i = 0; i < clickN; i++) {
			studentID = br.readLine();
			if(classStudent.contains(studentID)) {
				classStudent.remove(studentID);
			}
			classStudent.add(studentID);
		}
		
		// 결과 저장
		if(maxN > classStudent.size()) maxN = classStudent.size();
		for(String s : classStudent) {
			if (maxN > 0) {
				bw.write(s+"\n");
				maxN--;
			}
		}
		
		bw.close();
	}
}
