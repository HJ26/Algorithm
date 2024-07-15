import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int musicNum, fret = 0;
        int move = 0;
        int nowLine, nowFret;

        Stack<Integer>[] stack = new Stack[7];

        StringTokenizer st = new StringTokenizer(br.readLine());

        musicNum = Integer.parseInt(st.nextToken());
        fret = Integer.parseInt(st.nextToken());

        for (int x = 0; x <= 6; x++) {
            stack[x] = new Stack<Integer>();
        }

        for (int x = 0; x < musicNum; x++) {
            st = new StringTokenizer(br.readLine());

            nowLine = Integer.parseInt(st.nextToken());
            nowFret = Integer.parseInt(st.nextToken());

            while(!stack[nowLine].isEmpty() && stack[nowLine].peek() > nowFret ){
                stack[nowLine].pop();
                move++;
            }
            
            if (stack[nowLine].isEmpty() || stack[nowLine].peek() < nowFret) {
                stack[nowLine].push(nowFret);
                move++;
            }


        }

        bw.write(String.valueOf(move));
        bw.close();
        br.close();


    }


}