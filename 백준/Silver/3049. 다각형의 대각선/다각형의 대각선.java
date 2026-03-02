import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   
    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int polygon = Integer.parseInt(br.readLine());

        int cal = ((polygon)*(polygon-1)*(polygon-2)*(polygon-3))/24;
        System.out.println(cal);
    }   
}