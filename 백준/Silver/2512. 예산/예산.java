import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지방의 수 입력
        N = Integer.parseInt(br.readLine());

        // 각 지방의 예산요청을 배열에 저장
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        int high = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            high = Math.max(high, arr[i]);
        }

        int K = Integer.parseInt(br.readLine());

        // 모든 예산 요청의 합이 총 예산 이하인 경우 가장 큰 예산 요청 값을 출력하고 종료
        if (sum <= K) {
            System.out.println(high);
            return;
        }

        // 이분 탐색을 위한 시작점과 끝점 초기화
        int low = 1;

        // 이분 탐색 실행
        while (low < high - 1) {
            int mid = (low + high) / 2;
            
            // 상한액(mid)을 기준으로 각 지방의 배정 예산 합을 계산
            if (sum(mid) > K) {
                high = mid; // 상한액을 낮게 설정하여 다시 탐색
            } else {
                low = mid; // 상한액을 높게 설정하여 다시 탐색
            }
        }

        System.out.println(low);
    }

    static int sum(int mid) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += Math.min(arr[i], mid); // 상한액과 지방의 예산 중 작은 값을 더함
        }
        return total;
    }
}