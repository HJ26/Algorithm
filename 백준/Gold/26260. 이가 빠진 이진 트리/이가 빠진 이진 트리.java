import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    static int N, removePlace;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        tree = new int[N];
        removePlace = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(tree[i] == -1) removePlace = i;
        }
        
        int changeNum = Integer.parseInt(br.readLine());
        tree[removePlace] = changeNum;
        
        // 오름차순 정렬
        Arrays.sort(tree);
        
        // 후위 순회
        postOrder(0,N-1);
        
    }

    
    // 후위 순회
    private static void postOrder(int start, int end) {
        if(start > end) return;
    	int mid = (start+end)/2;
        
        // 자식노드에 대해 다시 순회
        postOrder(start, mid-1);
        postOrder(mid+1, end);
        System.out.print(tree[mid]+" ");
    }

}
