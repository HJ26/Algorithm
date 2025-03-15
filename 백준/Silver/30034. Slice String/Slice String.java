import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<Character> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());    
        while(n --> 0) { 	// n이 0이 될 때까지 반복
            set.add(st.nextToken().charAt(0));		// 문자 구분자 저장
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (m --> 0) {
            set.add(st.nextToken().charAt(0));		// 숫자 구분자 저장
        }
        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (k --> 0) {
            char ch = st.nextToken().charAt(0);		// 병합자 저장

            if (set.contains(ch)) {		// set(구분자) 중 병합자와 같은게 있다면 제거
                set.remove(ch);
            }
        }
        br.readLine();

        boolean flag = false;	
        StringBuilder sb = new StringBuilder();
        for (char c : br.readLine().toCharArray()) {	// 기존 문자열 반복
            if (set.contains(c) || c == ' ') {		// 구분자이거나 공백이라면
                if (flag) {		// flag 가 true 인 경우만
                    sb.append("\n");	// 한 줄 내림 진행.
                    flag = false;
                }
                continue;
            }
            sb.append(c);
            flag = true;
        }
        System.out.println(sb);
    }
}