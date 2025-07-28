import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			LinkedList<Integer> list = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());
			String[] robot = new String[N];
			
			for(int i=0; i<N; i++) {
				robot[i] = br.readLine();
				list.add(i);
			}

			for(int i=0; i<robot[0].length(); i++) {
                
				HashMap<Integer, Character> map = new HashMap<>();
				
				for(int j=0; j<list.size(); j++) {
					int numRobot = list.get(j);
					char result = robot[numRobot].charAt(i);
					map.put(numRobot, result);
				}
				
				int kindCnt = 0;
				char[] kindRSP = new char[3];
				for(int j=0; j<list.size(); j++) {
					int num = list.get(j);
					char c = map.get(num);
					switch(c) {
						case 'S': kindRSP[0]++;
							break;
						case 'R': kindRSP[1]++;
							break;
						case 'P': kindRSP[2]++;
							break;
					}
				}
				for(int j=0; j<3; j++) {
					if(kindRSP[j] != 0) {
						kindCnt++;
					}
				}
				
			
				if(kindCnt == 3 || kindCnt == 1) {
					continue;
				} else if(kindCnt == 2) {
				
					if(kindRSP[2] == 0) {
						for(int j=list.size()-1; j>=0; j--) {
							int robotNum = list.get(j);
							char robotResult = map.get(robotNum);
							if(robotResult == 'S') {
								list.remove(j);
								map.remove(robotNum);
							}
						}
					} else if(kindRSP[0] == 0) {
						for(int j=list.size()-1; j>=0; j--) {
							int robotNum = list.get(j);
							char robotResult = map.get(robotNum);
							if(robotResult == 'R') {
								list.remove(j);
								map.remove(robotNum);
							}
						}	
					} else if(kindRSP[1] == 0) {
						for(int j=list.size()-1; j>=0; j--) {
							int robotNum = list.get(j);
							char robotResult = map.get(robotNum);
							if(robotResult == 'P') {
								list.remove(j);
								map.remove(robotNum);
							}
						}	
					}
						
					
				}
				if(list.size() == 1) {
					System.out.println(list.get(0) + 1);
					break;
				}
			}
		
			if(list.size() > 1) System.out.println(0);

		}

	}
}