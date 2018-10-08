package edu.wofford;


public class TicTacToeModel {

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };
	protected Mark[][] board;
	protected boolean xTurn;
	protected boolean gamenotOver;
	private int filled = 0;

    protected String getColumnAsString(int col) {
        if(col >= 0 && col < 3) {
            String s = "";
            int row = 2;
            while(row >= 0 && board[row][col] != Mark.EMPTY) {
                s += (board[row][col] == Mark.XMARK)? "X" : "O";
                row--;
            }
            return s;
        }
        else {
            return "";
        }
    }
    protected String getRowAsString(int row) {
        if(row >= 0 && row < 3) {
            String s = "";
            int col = 2;
            while(col >= 0 && board[row][col] != Mark.EMPTY) {
                s += (board[row][col] == Mark.XMARK)? "X" : "O";
                col--;
            }
            return s;
        }
        else {
            return "";
        }
    }
	
	protected String getDiaAsString(int i){
		if (i >= 0 && i < 3){
			String s = "";
			if (i == 0 && (board[0][0]!=Mark.EMPTY && board[1][1]!=Mark.EMPTY && board[2][2]!=Mark.EMPTY)){
				s += (board[0][0] == Mark.XMARK)? "X" : "O";
				s += (board[1][1] == Mark.XMARK)? "X" : "O";
				s += (board[2][2] == Mark.XMARK)? "X" : "O";
			}
			if (i != 0 && (board[0][2]!=Mark.EMPTY&& board[1][1]!=Mark.EMPTY&& board[2][0]!=Mark.EMPTY)){
				s += (board[0][2] == Mark.XMARK)? "X" : "O";
				s += (board[1][1] == Mark.XMARK)? "X" : "O";
				s += (board[2][0] == Mark.XMARK)? "X" : "O";
			}
			return s;
		}
		else {
			return "";
		}
	}
	
    public TicTacToeModel() {
		board = new Mark[3][3];
        for (int i = 0;i < 3; i++){
            for (int j = 0; j < 3; j ++){
                board[i][j] = Mark.EMPTY;
            }
        }
        xTurn = true;
		gamenotOver = true;

    }
    
    public boolean setMarkAt(int row, int col) {
		if ((row>=0 && row < 3)&&(col>=0 && col < 3)&& gamenotOver && board[row][col] == Mark.EMPTY){
			if (board[row][col].equals(Mark.EMPTY)&& xTurn){
				board[row][col] = Mark.XMARK;
			}
			if (board[row][col].equals(Mark.EMPTY)&& !xTurn){
				board[row][col] = Mark.OMARK;
			}
			xTurn = !xTurn;
			filled ++;
			return true;
		}
		
        return false;
    }
    
    public Mark getMarkAt(int row, int col) {
		
        return board[row][col];
    }

    public Result getResult() {
        for(int i = 0; i < 3; i ++){
            String c = getColumnAsString(i);
			String r = getRowAsString(i);
			String d = getDiaAsString(i);
            if ((c.equals("XXX"))||(r.equals("XXX"))||(d.equals("XXX"))){
				gamenotOver = false;
                return Result.XWIN;
            }   
            if ((c.equals("OOO"))||(r.equals("OOO"))||(d.equals("OOO"))){
				gamenotOver = false;
                return Result.OWIN;
            }
			if (filled == 9){
				gamenotOver = false;
				return Result.TIE;
			}
            }
        return Result.NONE;
    }
    
    public String toString() {
        String outcome = "";
		String[][] temp = new String[3][3];
        for (int row = 0; row<3; row++){
            for (int column = 0; column<3; column++) {
                if (board[row][column] == Mark.EMPTY) {
                    temp[row][column] = " ";
                }
                if (board[row][column] == Mark.XMARK) {
                    temp[row][column] = "X";
                }
                else if (board[row][column] == Mark.OMARK){
                    temp[row][column] = "O";
                }
            }
        }
	outcome = temp[0][0] + "|" + temp[0][1] + "|" + temp[0][2] + "\n-----\n" 
			+ temp[1][0] + "|" + temp[1][1] + "|" + temp[1][2] + "\n-----\n"
			+ temp[2][0] + "|" + temp[2][1] + "|" + temp[2][2];
		
        return outcome;
    }    

}
