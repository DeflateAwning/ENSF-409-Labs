

public class BlockingPlayer extends RandomPlayer {

	public BlockingPlayer(String name, char mark) {
		super(name, mark);
	}
	
	protected void makeMove() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (testForBlocking(row, col)) {
					board.addMark(row, col, mark);
				}
			}
		}
		
		// Make a random move
		super.makeMove();
	}
	
	/**
	 * Checks to see if the opponent can win by playing at the given row/col
	 * 
	 * @param row
	 * @param col
	 * @return true if this spot requires blocking, false otherwise
	 */
	protected boolean testForBlocking(int row, int col) {
		// Do basic check to see if someone already played in this spot, which makes the test false
		if (board.getMark(row, col) != SPACE_CHAR) {
			return false;
		}
		
		// Check for rows
		if (didOpponentPlay(0, col) + didOpponentPlay(1, col) + didOpponentPlay(2, col) == 2) {
			return true;
		}
		
		// Check for cols
		if (didOpponentPlay(row, 0) + didOpponentPlay(row, 1) + didOpponentPlay(row, 2) == 2) {
			return true;
		}

		// Check downwards diagonal (TL to BR)
		if ((row == col)) {
			if (didOpponentPlay(0, 0) + didOpponentPlay(1, 1) + didOpponentPlay(2, 2) == 2) {
				return true;
			}
		}

		// Check upwards diagonal (BL to TR)
		if (row+col == 2) {
			if (didOpponentPlay(0, 2) + didOpponentPlay(1, 1) + didOpponentPlay(2, 0) == 2) {
				return true;
			}
		}
		
		return false;
	
	}
	
	/**
	 * Checks if the opponent has played at a given row/col
	 * 
	 * @param row
	 * @param col
	 * @return 1 if opponent has played at given row/col, 0 otherwise
	 */
	private int didOpponentPlay(int row, int col) {
		if (board.getMark(row, col) == opponent.getMark()) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
