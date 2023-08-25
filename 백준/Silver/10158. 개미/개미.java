import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			StringTokenizer wh = new StringTokenizer(br.readLine());
			StringTokenizer pq = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(br.readLine());
			int w = Integer.parseInt(wh.nextToken());
			int h = Integer.parseInt(wh.nextToken());
			int p = Integer.parseInt(pq.nextToken());
			int q = Integer.parseInt(pq.nextToken());
			
	        int tp = t+p;
	        int tq = t+q;
	        int xDist = tp%w;
	        int yDist = tq%h;
	        
			int row = (tp/w)%2 == 0 ? xDist : w-(xDist);
			int col = (tq/h)%2 == 0 ? (yDist) : h-(yDist);
			bw.write(Integer.toString(row));
			bw.write(" ");
			bw.write(Integer.toString(col));
			bw.close();
		}

}
