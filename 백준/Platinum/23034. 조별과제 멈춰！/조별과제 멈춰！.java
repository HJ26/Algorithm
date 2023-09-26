import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int m_nEnd;
    int m_nCost;

    public Node(int m_nEnd, int m_nCost) {
        this.m_nEnd = m_nEnd;
        this.m_nCost = m_nCost;
    }

	@Override
	public int compareTo(Node o) {
		return this.m_nCost - o.m_nCost;
	}
}

public class Main {
    static int N, M, X, Y, nResult, nPrim, nMaxWeight;
    static int[] narrCost;
    static int[] narrParents;
    static boolean[] barrVisit;
    static ArrayList<Node>[] arrList;
    static ArrayList<Node>[] arrPrim;
    public static void main(String[] args) throws IOException {
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수

        arrList = new ArrayList[N+1];
        arrPrim = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            arrList[i] = new ArrayList<>();
            arrPrim[i] = new ArrayList<>();
        }

        // 시작 노드, 끝 노드, 비용 입력 받자
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bReader.readLine());
            int nStart = Integer.parseInt(st.nextToken());
            int nEnd = Integer.parseInt(st.nextToken());
            int nCost = Integer.parseInt(st.nextToken());

            arrList[nStart].add(new Node(nEnd, nCost));
            arrList[nEnd].add(new Node(nStart, nCost));
        }

        // 최소 스패닝 트리 만들자
        narrCost = new int[N+1];
        narrParents = new int[N+1];
        barrVisit = new boolean[N+1];

        prim();

        for(int j = 1; j <= N; j++)
            nPrim += narrCost[j];

        //System.out.println("prim : " + nPrim);
        // 질문의 갯수를 입력 받자
        int Q = Integer.parseInt(bReader.readLine());

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(bReader.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            nMaxWeight = 0;
            nResult = nPrim;
            barrVisit = new boolean[N+1];
            DFS(X, 0, Y);
            if(nMaxWeight == 0) {
            	barrVisit = new boolean[N+1];
            	DFS(Y, 0, X);
            }

            // 최소 스패닝 트리 가중치에서 X와 Y사이의 가중치들 중 최댓값을 빼버리자
            nResult -= nMaxWeight;

            bWriter.write(nResult + "\n");
        }

        bWriter.flush();
        bWriter.close();
    }

    private static void prim() {
    	PriorityQueue<Node> pq = new PriorityQueue<Node>();
    	pq.addAll(arrList[1]);
    	barrVisit[1] = true;
    	
    	int nParent = 1;
    	int pick = 0;
    	while(pick != N-1) {
    		Node n = pq.poll();

    		if(barrVisit[n.m_nEnd]) continue;
    		barrVisit[n.m_nEnd] = true;
    		nPrim += n.m_nCost;
    		pick++;
    		pq.addAll(arrList[n.m_nEnd]);
    		arrPrim[nParent].add(n);
    		nParent = n.m_nEnd;
    	}
    	
    }

    // DFS를 통해 X와 Y상의 경로에 최댓값을 갖자
    public static void DFS(int nNode, int nMax,int goal) {

        if(barrVisit[nNode])
            return;

        barrVisit[nNode] = true;

        for(int i = 0; i < arrPrim[nNode].size(); i++) {
            int nChild = arrPrim[nNode].get(i).m_nEnd;
            int nCost = arrPrim[nNode].get(i).m_nCost;

            if(nMax < nCost)
                nMax = nCost;

            if(nChild == goal) {
                nMaxWeight = nMax;
                return;
            }

            DFS(nChild, nMax, goal);
        }
    }
}