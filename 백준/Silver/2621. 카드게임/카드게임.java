import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] colorList = new String[5]; // 색 저장
        int[] numList = new int[5]; // 숫자 저장
        int colorCount = 1; // 같은 색 카운트
        int[] numCount = new int[10]; // 같은 숫자 카운트

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 색, 숫자 입력
            String color = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            colorList[i] = color;
            numList[i] = num;

            // 같은 색, 숫자 카운트 코드
            if (i >= 1 && colorList[i - 1].equals(colorList[i])) {
                colorCount++;
            }
            numCount[num]++;
        }
        Arrays.sort(numList); // 숫자 오름차순 정렬

        // 연속적인 숫자 카운트 코드
        int continuedNumCount = 1; // 연속적인 숫자 카운트

        for (int i = 0; i < 5; i++) {
            if (i >= 1 && numList[i] == numList[i - 1] + 1) {
                continuedNumCount++;
            }
        }

        // 같은 숫자 계산 코드
        int fourSameNum = 0;
        int threeSameNum = 0;
        int twoSameNum = 0;
        int twoOtherSameNum = 0;

        for (int i = 1; i <= 9; i++) {
            if (numCount[i] == 4) {
                fourSameNum = i;
                break; // 같은 숫자가 4개면 반복 더 안 해도 됨
            } else if (numCount[i] == 3) {
                threeSameNum = i;
            } else if (numCount[i] == 2) {
                if (twoSameNum == 0) {
                    twoSameNum = i;
                } else {
                    twoOtherSameNum = i;
                }
            }
        }

        // 점수를 정하는 규칙대로 실행
        int max = numList[4]; // 가장 높은 숫자
        int score; // 점수

        if (colorCount == 5 && continuedNumCount == 5) { // 1번 규칙
            score = max + 900;
        } else if (fourSameNum > 0) { // 2번 규칙
            score = fourSameNum + 800;
        } else if (threeSameNum > 0 && twoSameNum > 0) { // 3번 규칙
            score = threeSameNum * 10 + twoSameNum + 700;
        } else if (colorCount == 5) { // 4번 규칙
            score = max + 600;
        } else if (continuedNumCount == 5) { // 5번 규칙
            score = max + 500;
        } else if (threeSameNum > 0) { // 6번 규칙
            score = threeSameNum + 400;
        } else if (twoSameNum > 0 && twoOtherSameNum > 0) { // 7번 규칙
            score = Math.max(twoSameNum, twoOtherSameNum) * 10 + Math.min(twoSameNum, twoOtherSameNum) + 300;
        } else if (twoSameNum > 0) { // 8번 규칙
            score = twoSameNum + 200;
        } else { // 9번 규칙
            score = max + 100;
        }

        System.out.println(score);
    }
}