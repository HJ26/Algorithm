import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");

		int nStudent = Integer.parseInt(input[0]);
		int roomMax = Integer.parseInt(input[1]);
		int[][] studentInfo = new int[6][2];
		for(int i = 0; i < nStudent; i++) {
			String[] stu = br.readLine().split(" ");
			studentInfo[Integer.parseInt(stu[1])-1][Integer.parseInt(stu[0])]++;
		}
		
		int nRoom = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				nRoom += studentInfo[i][j] / roomMax;
				if(studentInfo[i][j] % roomMax != 0) nRoom++;
			}
		}
		System.out.println(nRoom);
	}
}
