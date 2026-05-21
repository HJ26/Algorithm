
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        String answer = "";
        for (int i = 1; i <= N; i++) {
            answer += i + " ";
        }

        answer = answer.replaceAll("[0124578]*[369][0124578]*", "-");
        System.out.println(answer);
            
	}
}