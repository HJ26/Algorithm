import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nArray = Integer.parseInt(br.readLine());
		int[][] arr = new int[nArray][2];
		for(int i = 0; i < nArray; i++) {
			arr[i][0] = Integer.parseInt(br.readLine());
			arr[i][1] = i; // 이전 위치 저장
		}
        // 정렬
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
		});	
		
		
		// 실제 인덱스와 현재 위치의 차이 구하기\
		int[] diff = new int[nArray];
		int max = 0;
		for(int i = 0; i < nArray; i++) {
			diff[i] = arr[i][1] - i;
			if( diff[max] < diff[i] ) max = i;
		}
		
		System.out.println(diff[max]+1);
		
	}
}
