package tictactoe;

public class Board {

	char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	int currentPlayer = 1;

	int moveCount;

	public boolean isEnded() {
		return moveCount == 9;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void move(int row, int col) throws InvalidMoveException{
		if (row>3||row<1||col>3||col<1){
			throw new InvalidMoveException("give a number between 1 and 3");
		}if(board[row - 1][col - 1]!=' '){
			throw new InvalidMoveException(" it is not empty");
		}
		board[row - 1][col - 1] = currentPlayer == 1 ? 'X' : 'O';
		currentPlayer = 3 - currentPlayer;
		moveCount++;
	}
	
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("    1   2   3\n").
		append("   -----------\n");
		for (int row = 0; row < 3; ++row) {
			buf.append(row + 1 + " ");
			for (int col = 0; col < 3; ++col) {
				buf.append("|");
				buf.append(" " + board[row][col] + " ");
				if (col == 2)
					buf.append("|");
			}

			buf.append("\n");
			buf.append("   -----------\n");
		}
		return buf.toString();
	}
}
