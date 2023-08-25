import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nSwitch = Integer.parseInt(br.readLine());
		String[] stateTmp = br.readLine().split(" ");
		int[] state = new int[nSwitch+1];
		for(int i = 1; i < nSwitch+1; i++) {
			state[i] = Integer.parseInt(stateTmp[i-1]);
		}
		
		int nStudent = Integer.parseInt(br.readLine());
		for(int i = 0; i < nStudent; i++) {
			String[] tmp = br.readLine().split(" ");
			int gender = Integer.parseInt(tmp[0]);
			int noSwitch = Integer.parseInt(tmp[1]);
			if(gender == 1) {	
				for(int j = 1; noSwitch * j <= nSwitch; j++) {
					state[j*noSwitch] = ( state[j*noSwitch] == 0 ? 1 : 0);
				}
			}else {
				for(int j = 0; noSwitch-j > 0 && noSwitch+j <= nSwitch; j++) {
					if( state[noSwitch-j] == state[noSwitch+j]) {
						state[noSwitch-j] = ( state[noSwitch-j] == 0 ? 1 : 0);
						state[noSwitch+j] = state[noSwitch-j]; 
					}else {
						break;
					}
				}
				
			}
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		for(int i = 1; i < nSwitch+1; i++,cnt++) {
			sb.append(state[i]+" ");
			if( cnt == 20 ) {
				sb.append("\n");
				cnt = 0;
			}
		}
		
		System.out.println(sb);
		
	}
}
