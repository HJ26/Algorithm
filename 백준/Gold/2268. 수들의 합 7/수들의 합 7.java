import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new long[N*4];

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int func = Integer.parseInt(st.nextToken());
            int val1 = Integer.parseInt(st.nextToken());
            int val2 = Integer.parseInt(st.nextToken());

            // sum()
            if( func == 0 ){
                if( val1 > val2 ){
                    int tmp = val2;
                    val2 = val1;
                    val1 = tmp;
                }
                sb.append(sum(1,N,1,val1,val2) + "\n");
            }else{  // modify()
                update(1,N,1,val1,val2);
            }
        }

        System.out.println(sb);
    }

    public static long sum(int start, int end, int node, int left, int right){
        if(left > end || right < start) return 0;

        if(left <= start && end <= right) return tree[node];

        int mid = ( start + end ) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2 + 1, left, right);
    }
    
    public static long update(int start, int end, int node, int idx, int val){
        if(idx < start || idx > end) return tree[node];
        
        // 리프노드인경우
        if(start == end) return tree[node] = val;
        
        int mid = (start + end) / 2;
        
        // 리프노드와 연결된 트리 가지 업데이트
        return tree[node] = update(start, mid, node * 2, idx, val) + update(mid +1, end, node * 2 + 1, idx, val);
    }
}
