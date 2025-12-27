import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	static int notCompleted(int arr[]) {
		int index=0;
		
		for(int i=arr.length-1;i>0;i--) {
			if(arr[i]!=0) {
				index=i;
				break;
			}
		}
		
		return index;
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int semester=Integer.parseInt(br.readLine());
		int scores[]= new int[semester+1];
		int times[]=new int[semester+1];
		
		int homeworkNum=0;
		int result=0;
		
		for(int i=1;i<=semester;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
            
			if(num==0) {
				times[homeworkNum]--;
			}
			else {
				int score=Integer.parseInt(st.nextToken());
				int time=Integer.parseInt(st.nextToken());
				homeworkNum++;
					
				scores[homeworkNum]=score;
				times[homeworkNum]=time-1;
				
			}
			
			if(times[homeworkNum]==0) {
				result+=scores[homeworkNum];
				homeworkNum=notCompleted(times);
			}
		}
		
		System.out.println(result);
		
	}

}