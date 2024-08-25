import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		Stack<String> leftSt = new Stack<String>();
		Stack<String> rightSt = new Stack<String>();
        
		// 처음 커서는 문장의 맨 뒤에서 시작
        // 왼쪽 스택에 초기 문자를 모두 넣어줌
		String[] arr = str.split("");
		for(String s : arr) { //Enhanced For Loop 사용 
			leftSt.push(s); 
		}
		
		for(int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
            
            // 입력값에 따라 구분
			switch(c) {
			case 'L':
				if(!leftSt.isEmpty()) rightSt.push(leftSt.pop());
				break;
			case 'D':
				if(!rightSt.isEmpty()) leftSt.push(rightSt.pop());
				break;
			case 'B':
				if(!leftSt.isEmpty()) leftSt.pop();
				break;
			case 'P':
				char t = command.charAt(2);
				leftSt.push(String.valueOf(t));
				break;
			default:
				break;
			}
		}
        
		// 왼쪽 스택에 있는 데이터들을 모두 오른쪽으로 옮기기
        // 이후 오른쪽에 있는 모든 내용을 출력한다.
		while(!leftSt.isEmpty()) rightSt.push(leftSt.pop());
		while(!rightSt.isEmpty()) bw.write(rightSt.pop());
		
		bw.close(); 
	}
}