import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int nSlime = Integer.parseInt(br.readLine());
			long totalEnergy = 1;
			
			PriorityQueue<Long> slime = new PriorityQueue<Long>();
			String[] input = br.readLine().split(" ");
			for(int i =0 ; i < nSlime; i++) {
				slime.offer(Long.parseLong(input[i]));
			}
			
			while(slime.size() != 1) {
				long needEnergy = slime.poll() * slime.poll();
				totalEnergy = totalEnergy * (needEnergy % 1000000007) % 1000000007;
				slime.add(needEnergy);
			}
			
			bw.write(Long.toString(totalEnergy));
			bw.write("\n");
		}
		bw.close();
		br.close();
	}
}
