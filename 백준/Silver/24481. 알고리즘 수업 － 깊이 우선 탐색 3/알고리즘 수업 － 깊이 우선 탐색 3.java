import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> arr;
	static int d[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken())-1;
		
		arr=new ArrayList<>();
		d=new int[n];
		
		for(int i=0; i<n; i++) {
			arr.add(new ArrayList<>());
			d[i]=-1;
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(bf.readLine());
			int u=Integer.parseInt(st.nextToken())-1;
			int v=Integer.parseInt(st.nextToken())-1;
			
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		
		for(int i=0; i<n; i++) {
			Collections.sort(arr.get(i));
		}
		
		d[r]=0;
		dfs(r);
		
		for(int i=0; i<n; i++) {
			bw.write(d[i]+"\n");
		}
		bw.close();
	}

	private static void dfs(int r) {
		for(int i=0; i<arr.get(r).size(); i++) {
			if(d[arr.get(r).get(i)]==-1) {
				d[arr.get(r).get(i)]=d[r]+1;
				dfs(arr.get(r).get(i));
			}
		}
	}
}