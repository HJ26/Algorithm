import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	// 상하 반전
	public static String[][] upDown(String[][] arr, int row, int col, int max) {
		
		String[][] rslt = new String[max][max];
		for(int i = 0; i < row/2; i++ ) {
			rslt[i] = arr[row-1-i]; 
			rslt[row-i-1] = arr[i];
		}
		return rslt;
		
	}
	
	// 좌우 반전
	public static String[][] leftRight(String[][] arr, int row, int col, int max){
		
		String[][] rslt = new String[max][max];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				
				rslt[i][j] = arr[i][col-j-1];
				rslt[i][col-j-1] = arr[i][j];
				
			}
		}
		
		return rslt;
	}
	
	// 오른쪽 90도
	public static String[][] right90(String[][] arr, int row, int col, int max){
		
		String[][] rslt = new String[max][max];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				rslt[j][row-i-1] = arr[i][j];
			}
		}
		return rslt;
	}
	
	// 왼쪽 90도
	public static String[][] left90(String[][] arr, int row, int col, int max){
		
		String[][] rslt = new String[max][max];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				rslt[col-j-1][i] = arr[i][j];
			}
		}
		
		return rslt;
	}

	// 시계방향
	public static String[][] blockRight(String[][] arr, int row, int col, int max){
		
		String[][] rslt = new String[max][max];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				
				if( (i < (row/2) && j < (col/2) )  || ( i >= (row/2) && j >= (col/2)) ) {
					
					if( j < (col/2) ) {
						rslt[i][j+(col/2)] = arr[i][j];
					} else {
						rslt[i][j-(col/2)] = arr[i][j];
					}
				}else {
					
					if( i < (row/2) ) {
						rslt[i+(row/2)][j] = arr[i][j];
					} else {
						rslt[i-(row/2)][j] = arr[i][j];
					}
				}
				
			}
		}
		return rslt;
		
	}
	
	// 반시계방향
	public static String[][] blockLeft(String[][] arr, int row, int col, int max) {
		
		String[][] rslt = new String[max][max];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				
				if( (i < row/2 && j < col/2)  || ( i >= (row/2) && j >= (col/2) )) {
					if( i < (row/2) ) {
						rslt[i+(row/2)][j] = arr[i][j];
					} else {
						rslt[i-(row/2)][j] = arr[i][j];
					}
				}else {
					if( j < (col/2) ) {
						rslt[i][j+(col/2)] = arr[i][j];
					} else {
						rslt[i][j-(col/2)] = arr[i][j];
					}
				}
				
			}
		}
		
		return rslt;
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nmr = br.readLine().split(" ");
		int n = Integer.parseInt(nmr[0]);
		int m = Integer.parseInt(nmr[1]);
		int r = Integer.parseInt(nmr[2]);
		int tmp;
		
		int max = ( n > m ? n : m );
		String[][] rslt = new String[max][max];
		
		// 원본 만들기
		for(int i = 0; i < n; i++) {
			rslt[i] = br.readLine().split(" ");
		}

		// 함수 적용
		String[] func = new String[r];
		func = br.readLine().split(" ");
		
		for(String f : func) {
			switch(f) {
			case "1":
				rslt = upDown(rslt,n,m,max);
				break;
			case "2":
				rslt = leftRight(rslt,n,m,max);
				break;
			case "3":
				rslt = right90(rslt,n,m,max);
				tmp = n;
				n = m;
				m = tmp;
				break;
			case "4":
				rslt = left90(rslt,n,m,max);
				tmp = n;
				n = m;
				m = tmp;
				break;
			case "5":
				rslt = blockRight(rslt,n,m,max);
				break;
			case "6":
				rslt = blockLeft(rslt,n,m,max);
				break;
			}
		}
		
		//출력
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				bw.write(rslt[i][j]+" ");
			}bw.write("\n");
		}
		
		bw.close();
	}
}
