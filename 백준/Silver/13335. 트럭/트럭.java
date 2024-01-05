import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int nTruck = Integer.parseInt(input[0]); // 트럭 개수
		int nBridge = Integer.parseInt(input[1]); // 다리 길이
		int maxWeight = Integer.parseInt(input[2]); // 최대 하중

		Queue<Integer> trucks = new LinkedList<Integer>(); // 트럭 무게
		Queue<Integer> movTrucks = new LinkedList<Integer>(); // 다리 위의 트럭
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < nTruck; i++)
			trucks.offer(Integer.parseInt(st.nextToken()));

		int curWeight = 0;
		int time = 1;

		// 다리 길이만큼 0으로 넣기
		for (int i = 0; i < nBridge; i++) {
			movTrucks.offer(0);
		}

		// 아직 이동을 완료하지 않은 트럭이 있을때까지 반복
		while (!trucks.isEmpty() || !movTrucks.isEmpty()) {

			// 마지막 차가 나왔으면 종료
			if (movTrucks.peek() != 0) nTruck--;
			if (nTruck == 0) break;
			
			// 도로위에서 차 나오기
			curWeight -= movTrucks.poll();
			
			// 트럭 이동하기
			// 이동할 트럭이 있고, 다리위의 무게와 다음에 올라갈 트럭의 무게가 하중보다 적으면 올라가기
			if (!trucks.isEmpty()) {
				if (curWeight + trucks.peek() <= maxWeight) {
					movTrucks.offer(trucks.peek());
					curWeight += trucks.poll();
				} else {	// 못올라갔으면 0으로 채우기
					movTrucks.offer(0);
				}
			}

			// 시간 증가
			time++;
		}

		bw.write(Integer.toString(time));
		bw.close();
		br.close();
	}
}
