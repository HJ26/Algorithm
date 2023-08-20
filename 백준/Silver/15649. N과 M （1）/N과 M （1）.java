import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class Main {
 
	public static int N;
	public static int M;
	public static int[] seq;
	public static boolean[] visit;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] nm = br.readLine().split(" ");
 
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		seq = new int[M];
		visit = new boolean[N];
        
		sb = makeSeq(0, sb);
		
		bw.write(sb.toString());
		bw.flush();
 
	}
 
	public static StringBuilder makeSeq(int cnt, StringBuilder sb) {
		if (cnt == M) {
			for (int s : seq) {
				sb.append(s).append(' ');
			}
			sb.append('\n');
			return sb;
		}
 
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				seq[cnt] = i + 1;
				sb = makeSeq(cnt + 1,sb);
				visit[i] = false;
			}
		}
		return sb;
	}
 
}