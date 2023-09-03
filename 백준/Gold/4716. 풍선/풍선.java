import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {

            String[] input = br.readLine().split(" ");
            int nTeam = Integer.parseInt(input[0]);
            int nA = Integer.parseInt(input[1]);
            int nB = Integer.parseInt(input[2]);
            
            if(nTeam == 0 && nA == 0 && nB == 0) break;
            
            int[][] teamInfo = new int[nTeam][4];
            for(int i = 0; i < nTeam; i++) {
                String[] input2 = br.readLine().split(" ");
                teamInfo[i][0] = Integer.parseInt(input2[0]);
                teamInfo[i][1] = Integer.parseInt(input2[1]);
                teamInfo[i][2] = Integer.parseInt(input2[2]);
                teamInfo[i][3] = teamInfo[i][1] - teamInfo[i][2];
            }
            
            // 거리 차이가 큰 순으로 내림차순 정렬
            Arrays.sort(teamInfo, new Comparator<int[]>() {
            	
            	@Override
            	public int compare(int[] o1, int[] o2) {
            		if(Math.abs(o1[3]) == Math.abs(o2[3])) {
            			return o1[0]-o2[0];
            		}else {
            			return Math.abs(o2[3])-Math.abs(o1[3]);
            		}
            	}
            	
            });
            
            // 음수면 A와 더 가깝다는 뜻, 양수면 B와 더 가깝다는 뜻
            // 음수면 A에서 가져가고, B면 음수에서 가져감
            int totalDistance = 0;
            
            for(int i = 0; i < nTeam; i++ ) {
            	if(teamInfo[i][3] < 0) {
            		if( teamInfo[i][0] > nA ) {
            			totalDistance += ( teamInfo[i][1]*(nA));
            			totalDistance += ( teamInfo[i][2]*(teamInfo[i][0]-nA));
            			nB -= teamInfo[i][0]-nA; 
            			nA = 0;
            		}else {
            			totalDistance += ( teamInfo[i][1]*teamInfo[i][0]);
            			nA -= teamInfo[i][0];
            		}
            	}else {
            		if( teamInfo[i][0] > nB ) {
            			totalDistance += ( teamInfo[i][2]*(nB));
            			totalDistance += ( teamInfo[i][1]*(teamInfo[i][0]-nB));
            			nA -= teamInfo[i][0]-nB; 
            			nB = 0;
            		}else {
            			totalDistance += ( teamInfo[i][2]*teamInfo[i][0]);
            			nB -= teamInfo[i][0];
            		}
            	}
            }
            
            System.out.println(totalDistance);
        }
    }
}