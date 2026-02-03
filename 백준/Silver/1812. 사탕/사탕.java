import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int[] answers = new int[N + 1];
        int sum = 0;
        for (int i = 1; i < input.length; i++) {
            if (i % 2 == 0) {
                sum -= input[i];
            } else {
                sum += input[i];
            }
        }
        answers[1] = sum / 2;
        for (int i = 2; i < input.length; i++) {
            answers[i] = input[i - 1] - answers[i - 1];
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.println(answers[i]);
        }
    }
}