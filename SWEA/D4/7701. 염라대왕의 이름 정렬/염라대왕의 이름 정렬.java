import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            List<String> str = new ArrayList<>();
            for (int i = 0; i< N; i++){
                str.add(sc.next());
            }
            List<String> list = str.stream().distinct().sorted(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    } else {
                        if (o1.length() > o2.length()) return 1;
                        else return -1;
                    }
                }
            }).collect(Collectors.toList());
            sb.append("#"+tc+"\n");
            for (String s : list) {
                sb.append(s + "\n");
            }
        }
        System.out.println(sb);
    }
}