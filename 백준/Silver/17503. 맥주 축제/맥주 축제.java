import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Beer[] beers = new Beer[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int prefer = Integer.parseInt(st.nextToken());
            int alchol = Integer.parseInt(st.nextToken());

            Beer beer = new Beer(prefer, alchol);
            beers[i] = beer;
        }

        Arrays.sort(beers); 
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 

        long total = 0;
        int result = 0;
        for (int i = 0; i < beers.length; i++) {

            priorityQueue.offer(beers[i].prefer);
            total += beers[i].prefer;

            if (priorityQueue.size() > n) {
                total -= priorityQueue.poll();
            }

            if (priorityQueue.size() == n && total >= m) {
                result = beers[i].alchol;
                break;
            }
        }

        if (result == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(result + "\n");
        }

        bw.close();
        br.close();
    }
}

class Beer implements Comparable<Beer> {
    int prefer;
    int alchol;

    public Beer(int prefer, int alchol) {
        this.prefer = prefer;
        this.alchol = alchol;
    }

    @Override
    public int compareTo(Beer arg0) {
        return this.alchol - arg0.alchol;
    }
}