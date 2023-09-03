import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nClass = Integer.parseInt(br.readLine());
		int[][] classInfo = new int[nClass][2];
		for(int i = 0; i < nClass; i++) {
			String[] inputTmp = br.readLine().split(" ");
			classInfo[i][0] = Integer.parseInt(inputTmp[0]);
			classInfo[i][1] = Integer.parseInt(inputTmp[1]); 
		}
		
		Arrays.sort(classInfo, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
			
		});
		
		PriorityQueue<Integer> nRoom = new PriorityQueue<>();
		
		nRoom.add(classInfo[0][1]);
		for(int i = 1; i < nClass; i++) {
			if(nRoom.peek() <= classInfo[i][0]) nRoom.poll();
			nRoom.add(classInfo[i][1]);
		}
		System.out.println(nRoom.size());
	}
}
