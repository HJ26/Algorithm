import java.util.LinkedList;
import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = 10;
		for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < N; i++){ list.add (sc.nextInt()); }
            int M = sc.nextInt();
            for(int i = 0; i < M; i++){
                String command = sc.next();
                if(command.equals("I")){
                    int idx = sc.nextInt();
                    int count = sc.nextInt();
                    while(count --> 0){ list.add(idx++, sc.nextInt()); }
                }else if(command.equals("D")){
                    int idx = sc.nextInt();
                    int count = sc.nextInt();
                    while(count --> 0){ list.remove(idx); }
                }else{
                    int count = sc.nextInt();
                    while(count --> 0){ list.add(sc.nextInt()); }
                }
            }
            sb.append("#" + tc + " ");
            for(int i = 0; i < 10; i++){
                sb.append(list.get(i) + " " );
            }
            sb.append("\n");
		}
        System.out.println(sb);
	}
}