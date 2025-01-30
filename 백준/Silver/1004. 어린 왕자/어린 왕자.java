import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int tc, numberOfGalaxy;
        int[] xys = new int[4], galaxy = new int[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        while(tc > 0){

            int cnt = 0;

            String[] xyxy = br.readLine().split(" ");
            for(int i = 0; i < xys.length; i++)
                xys[i] = Integer.parseInt(xyxy[i]);

            numberOfGalaxy = Integer.parseInt(br.readLine());

            while(numberOfGalaxy > 0){

                String[] xyr = br.readLine().split(" ");
                for(int i = 0; i < galaxy.length; i++)
                    galaxy[i] = Integer.parseInt(xyr[i]);

                double startCircleVal = Math.pow(xys[0] - galaxy[0], 2) + Math.pow(xys[1] - galaxy[1], 2);
                double destinationCircleVal = Math.pow(xys[2] - galaxy[0], 2) + Math.pow(xys[3] - galaxy[1], 2);
                double squaredRadius = Math.pow(galaxy[2], 2);

                if(startCircleVal <= squaredRadius && destinationCircleVal <= squaredRadius){
                    numberOfGalaxy--;
                    continue;
                }
                else if(startCircleVal <= squaredRadius || destinationCircleVal <= squaredRadius)
                    cnt++;

                numberOfGalaxy--;
            }
            System.out.println(cnt);
            tc--;
        }
        br.close();
    }
}