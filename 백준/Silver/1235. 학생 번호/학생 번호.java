import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int N = Integer.parseInt(br.readLine());
		int ans = 0;
		String[] arr = new String[N];
		HashSet<String> set = new HashSet<String>();
		
		for(int i=0; i<N; ++i) {
			arr[i] = br.readLine();
		}
        
		for(int i=1; i<=arr[0].length(); ++i) {
			for(int j=0; j<N; ++j) {
				set.add(arr[j].substring(arr[j].length()-i));
			}
			if(set.size() == N) {
				ans = i;
				break;
			}
			set.clear();
		}
        
		bw.write(ans + "");
		bw.close();
	}	
}