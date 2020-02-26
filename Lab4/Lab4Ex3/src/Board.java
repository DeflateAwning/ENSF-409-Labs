
/*
 * Creates a playing board, on which marks can be made by Players. This is the location that the game playing data is stored.
 * 
 * @author Parker Link
 * @version 2.0.0
 * @since Feb. 5, 2020
 */
public class Board implements Constants {
	/*
	 * Storage for the board's contents/marks
	 */
	private char theBoard[][];
	
	/*
	 * The count of the current number of marks made on the board
	 */
	private int markCount;

	/*
	 * Creates the board, and sets it to a simple known empty state.
	 * 
	 * TODO This method could be improved by making use of the clear() function to set the values of the empty board.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/*
	 * Gets what type of mark is at the given row and column
	 * 
	 * @param row The row to check at
	 * @param col The columns to check at
	 * @return The type of mark made at the given location
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/*
	 * Checks if every square on the board is full.
	 * 
	 * @return Has every square on the board been filled (i.e. all 9 marks have been made)?
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/*
	 * Checks if Player 'O' wins.
	 * 
	 * @return Has player O won (true if yes, false if no)
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/*
	 * Checks if Player 'O' wins.
	 * 
	 * @return Has player O won (true if yes, false if no)
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/*
	 * Displays the board, in an easy-to-read fashion. This method displays the entire board, including heads, columns, etc.
	 * This method allows the user to interpret the current state of the board, and therefore play the game.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/*
	 * Adds a mark to the current board, at a given row/col, with the given mark.
	 * 
	 * @param row The row to create the mark at
	 * @param col The column to create the mark at
	 * @param mark The mark to create at the given row/column
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/*
	 * Resets the game board by settings all spaces to an "unset" status. All spaces now contain SPACE_CHAR.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/*
	 * Checks the board to see if the current playing has created a winner. 
	 * Returns 0 if the mark is not a winner, and 1 if they are a winner. This function effectively behaves as though it has a boolean return value.
	 * 
	 * @param mark The type of mark to check if they are the winner
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
	
	/*
	 * Prints out columns headers for the game board. 3 columns are created.
	 */
	void displayColumnHeaders() {
		System.out.println(); // added to create more space/nicer appearance
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/*
	 * Prints out one row of hyphens for the game board. 3 columns in one row are created.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/*
	 * Prints out one row of spaces for the game board. 3 columns in one row are created.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
