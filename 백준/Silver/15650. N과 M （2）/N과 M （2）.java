import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.IOException;
 
public class Main {
 
	public static int N;
	public static int M;
	public static int[] seq;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] nm = br.readLine().split(" ");
 
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		seq = new int[M];
        
		sb = makeSeq(1, 0, sb);
		
		bw.write(sb.toString());
		bw.flush();
 
	}
 
	public static StringBuilder makeSeq(int start, int cnt, StringBuilder sb) {
		if (cnt == M) {
			for (int s : seq) {
				sb.append(s).append(' ');
			}
			sb.append('\n');
			return sb;
		}
 
		for (int i = start; i < N+1; i++) {
			seq[cnt] = i;
			sb = makeSeq(i+1, cnt+1, sb);
		}
		return sb;
	}
 
}