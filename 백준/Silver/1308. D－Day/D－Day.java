import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] Tdate = br.readLine().split(" ");
        String[] Ddate = br.readLine().split(" ");

        int Tyear = Integer.parseInt(Tdate[0]);
        int Tmonth = Integer.parseInt(Tdate[1]);
        int Tday = Integer.parseInt(Tdate[2]);

        int Dyear = Integer.parseInt(Ddate[0]);
        int Dmonth = Integer.parseInt(Ddate[1]);
        int Dday = Integer.parseInt(Ddate[2]);

        int Tdays = getDays(Tyear, Tmonth , Tday);
        int Ddays = getDays(Dyear, Dmonth , Dday);

        if( (Dyear - Tyear > 1000) || (Dyear - Tyear == 1000 && Dmonth - Tmonth > 0) || (Dyear - Tyear == 1000 && Dmonth - Tmonth == 0 && Dday - Tday >= 0) ){
            bw.write("gg");
        }else{
            bw.write("D-" + (Ddays - Tdays));
        }

        bw.flush();
        bw.close();
    }
    
        public static int[] getYear(int year){
        int[] month = {31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};
        if(year%4==0 && year%100 != 0 || year%400==0){
            month[1] = 29;
        }
        return month;
    }

    public static int getDays(int year, int month , int day){
        int days = 0;
        int[] months;
        
        for(int i=1; i<year; i++){
            months = getYear(i);
            for(int j=0; j<12; j++){
                days += months[j];
            }
        }
        
        months = getYear(year);
        for(int i=0; i< month-1; i++){
            days += months[i];
        }
        days+=day;
        return days;
    }
}