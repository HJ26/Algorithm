import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(!str.equals("end")){

            board = new char[3][3];
            int nX = 0;
            int nO = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    board[i][j] = str.charAt(i*3+j);
                    if(board[i][j] == 'X') nX++;
                    else if(board[i][j] == 'O') nO++;
                }
            }

            tictactoe(board, nX, nO);
            str = br.readLine();
        }

        System.out.println(sb.toString());
    }

    private static void tictactoe(char[][] board, int nX, int nO) {

        boolean xFlag = false;
        boolean oFlag = false;

        // 가로 확인
        Loop: for(int i = 0; i < 3; i++){
            char cur = board[i][0];
            if(cur == '.') continue;
            for(int j = 0; j < 3; j++){
                char next = board[i][j];
                if(cur != next) continue Loop;;
            }
            if(cur == 'X') xFlag = true;
            else if(cur == 'O') oFlag = true;
        }

        if(xFlag && oFlag){
            sb.append("invalid").append("\n");
            return;
        }

        // 세로 확인
        Loop: for(int i = 0; i < 3; i++){
            char cur = board[0][i];
            if(cur == '.') continue;
            for(int j = 0; j < 3; j++){
                char next = board[j][i];
                if(cur != next) continue Loop;
            }
            if(cur == 'X') xFlag = true;
            else if(cur == 'O') oFlag = true;
        }

        if(xFlag && oFlag){
            sb.append("invalid").append("\n");
            return;
        }

        // 대각선 확인
        if(board[0][0] == board[1][1] && board[1][1] ==  board[2][2]){
            if(board[0][0] == 'X') xFlag = true;
            else if(board[0][0] == 'O') oFlag = true;
        }

        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2]){
            if(board[2][0] == 'X') xFlag = true;
            else if(board[2][0] == 'O') oFlag = true;
        }

        if(xFlag && oFlag){
            sb.append("invalid").append("\n");
            return;
        }

        if(xFlag && nX == nO+1){
            sb.append("valid").append("\n");
            return;
        }

        if(oFlag && nX == nO){
            sb.append("valid").append("\n");
            return;
        }

        if(!xFlag && !oFlag && nX == 5 && nO == 4) sb.append("valid").append("\n");
        else sb.append("invalid").append("\n");
    }
}