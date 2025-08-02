import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumA = new int[N*N];
        int[] sumB = new int[N*N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sumA[i*N+j] = A[i]+B[j];
                sumB[i*N+j] = C[i]+D[j];
            }
        }

        Arrays.sort(sumA);
        Arrays.sort(sumB);

        int left = 0;
        int right = N*N-1;
        long answer = 0;
        while(left < N*N && right >= 0){
            if(sumA[left] + sumB[right] > 0) right--;
            else if(sumA[left] + sumB[right] < 0) left++;
            else{
                long leftCnt = 1;
                long rightCnt = 1;
                while(left + 1 < N*N && sumA[left] == sumA[left+1]){
                    leftCnt++;
                    left++;
                }

                while(right -1 >= 0 && sumB[right] == sumB[right-1]){
                    rightCnt++;
                    right--;
                }

                answer += leftCnt * rightCnt;
                left++;
            }
        }

        System.out.println(answer);
    }
}