import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int nMove = 0;
	public static StringBuilder sb = new StringBuilder();
	
	
	// 하노이 이동
	private static void hanoi(int k, int startIdx,int tmp,int endIdx) {

		if (k == 1) {					
			nMove++;	
			sb.append(startIdx + " " + endIdx + "\n");
			return;
		}
		hanoi(k-1,startIdx,endIdx,tmp); // 마지막 원판 제외 이동
		hanoi(1,startIdx,tmp,endIdx);	// 마지막 원판 이동
		hanoi(k-1,tmp,startIdx,endIdx);	// 나머지 원판 이동

	}
    
    // 실행
	public static void main(String[] args) throws NumberFormatException, IOException {

		int K = Integer.parseInt(br.readLine());
		hanoi(K,1,2,3);
		bw.write(nMove+"\n");
		bw.write(sb.toString());
		bw.flush();
	}
}