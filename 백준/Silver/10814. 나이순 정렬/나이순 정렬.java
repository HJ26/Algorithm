import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
        int N = Integer.parseInt(br.readLine());

		StringBuilder[] p = new StringBuilder[201];
		
		//객체배열의 인덱스에 각 StringBuilder 객체를 생성해준다.
		for(int i = 0; i < p.length; i++) {
			p[i] = new StringBuilder();
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			p[age].append(age).append(' ').append(name).append('\n');
		}
		
		for(StringBuilder val : p) {
			sb.append(val);
		}
        
		System.out.println(sb);
	}
}