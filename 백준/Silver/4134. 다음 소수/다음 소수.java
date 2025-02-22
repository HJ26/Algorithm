import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbd = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            long prime = Long.parseLong(br.readLine());

            // 입력받는 prime은 0부터 시작한다고 했으니, 0과 1 이상의 소수는 2라서 2 출력
            if(prime == 0 | prime == 1 ) {
                sbd.append(2).append("\n");
                continue;
            }

            while(true) {
                long cnt = 0;
                for(long j = 2; j <= Math.sqrt(prime); j++) {
                    if(prime % j ==0) {
                        cnt++;
                        break;
                    }
                }

                if(cnt == 0) {
                    sbd.append(prime).append("\n");
                    break;
                }
                prime++;
            }
        }

        System.out.println(sbd);

    }
}