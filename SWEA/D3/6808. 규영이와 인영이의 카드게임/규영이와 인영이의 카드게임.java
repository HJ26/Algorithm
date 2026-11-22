import java.io.*;
import java.util.*;

public class Solution {

    static int[] gCards = new int[9];
    static int[] iCards = new int[9];
    static int[] selected = new int[9];
    static boolean[] isVisited;
    static int winCount, loseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            boolean[] isUsed = new boolean[19];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 9; i++) {
                gCards[i] = Integer.parseInt(st.nextToken());
                isUsed[gCards[i]] = true;
            }

            int idx = 0;
            for(int i = 1; i <= 18; i++) {
                if (!isUsed[i]) {
                    iCards[idx++] = i;
                }
            }

            winCount = 0;
            loseCount = 0;
            isVisited = new boolean[9];

            recursion(0);

            sb.append("#"+tc+" "+winCount+" "+loseCount+"\n");
        }

        System.out.println(sb.toString());
    }

    public static void recursion(int idx) {
        if (idx == 9) {
            calculate();
            return;
        }

        for(int i = 0; i < 9; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                selected[idx] = iCards[i];
                recursion(idx + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void calculate() {
        int gScore = 0;
        int iScore = 0;

        for (int i = 0; i < 9; i++) {
            int gNum = gCards[i];
            int iNum = selected[i];

            if (gNum > iNum) {
                gScore += (gNum + iNum);
            } else {
                iScore += (gNum + iNum);
            }
        }

        if (gScore > iScore) {
            winCount++;
        } else if (gScore < iScore) {
            loseCount++;
        }
    }
}