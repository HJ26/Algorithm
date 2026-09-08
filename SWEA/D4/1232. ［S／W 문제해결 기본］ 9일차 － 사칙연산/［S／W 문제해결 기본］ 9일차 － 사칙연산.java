import java.util.*;
import java.io.*;

class Node{
	int num;
	String data;
	int left;
	int right;
	
	public Node(int num, String data, int left, int right) {
		super();
		this.num = num;
		this.data = data;		
		this.left = left;
		this.right = right;
	}
	
}

public class Solution {
	
	
	static List<Node> arr;
	
	static double inOrder(Node node) {
		
		double leftResult = Integer.MIN_VALUE;
		double rightResult = Integer.MIN_VALUE;
		
		if(node.left!=-1) {
			leftResult = inOrder(arr.get(node.left));
		}
		
		if(node.right!=-1) {
			rightResult = inOrder(arr.get(node.right));
		}
		
		if(leftResult!=Integer.MIN_VALUE && rightResult!=Integer.MIN_VALUE) {
			if(node.data.equals("+")) return leftResult+rightResult;
			else if(node.data.equals("-")) return leftResult-rightResult;
			else if(node.data.equals("*")) return leftResult*rightResult;
			else if(node.data.equals("/")) return leftResult/rightResult;
		
		}
        
		return Double.valueOf(Integer.parseInt(node.data));
		
	}
	
    public static void main(String[] args) throws IOException, InterruptedException {
 
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer stf = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stf.nextToken());
            
            arr = new ArrayList<>();
            
            arr.add(new Node(-1, "", -1, -1));
            
            for (int i = 0; i < N; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());      
            	int n = Integer.parseInt(st.nextToken());
            	String d = st.nextToken();
            	int l = -1;
            	int r = -1;
            	int inputcnt = 0;
            	while(st.hasMoreTokens()) {
            		if(inputcnt==0) {
            			l = Integer.parseInt(st.nextToken()); inputcnt++;
            		}
            		else if(inputcnt==1) {
            			r = Integer.parseInt(st.nextToken()); inputcnt++;
            		}
            		
            	}
            	Node node = new Node(n, d, l, r);            	
            	arr.add(node);
			}
            
            
            int result = (int) inOrder(arr.get(1));
            
            
            String ans = String.valueOf(result);
            System.out.println("#" + tc + " " + ans);
        }
    }
}