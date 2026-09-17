import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int k = 0; k < 10; k++) {
            int tc = sc.nextInt();
            int[] datas = new int[8];

            for (int i = 0; i < 8; i++) {
                datas[i] = sc.nextInt();
            }

            List<String> passwords = findPassword(datas);
            String message = String.join(" ", passwords);

            System.out.println("#" + tc + " " + message);
        }
    }

    static List<String> findPassword(int[] datas) {
        int index = 0;
        while (true) {
            boolean codeCheck = false;
            for (int i = 1; i <= 5; i++) {
                datas[index] -= i;

                if (datas[index] <= 0) {
                    datas[index] = 0;
                    codeCheck = true;
                }

                if (index == 7) {
                    index = 0;
                } else {
                    index++;
                }

                if (codeCheck) {
                    break;
                }
            }

            if (codeCheck) {
                break;
            }
        }

        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            passwords.add(Integer.toString(datas[index]));

            if (index == 7) {
                index = 0;
            } else {
                index++;
            }
        }

        return passwords;
    }
}