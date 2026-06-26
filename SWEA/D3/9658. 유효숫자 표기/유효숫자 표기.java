import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String n = br.readLine();
            int square = n.length() - 1; // 지수

            int x = Integer.parseInt(n.charAt(0) + ""); 
            int y = Integer.parseInt(n.charAt(1) + "");
            int z = Integer.parseInt(n.charAt(2) + "");

            if (z >= 5) {
                y += 1;
                if(y == 10) {
                    x += 1;
                    y = 0;
                    if(x == 10) {
                        x = 1;
                        square += 1;
                    }
                }
            }

            sb.append("#" + (i + 1) + " " + x + "." + y + "*10^" + square + "\n");
        }

        System.out.println(sb);
    }
}