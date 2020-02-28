import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

	/**
	 * Creates a human player object, allowing interface with a human to play.
	 * 
	 * @param name Name of player
	 * @param mark Mark (symbol) of player
	 */
	public HumanPlayer(String name, char mark) {
		super(name, mark);
	}
	
	/**
	 * Prompts the user to make a move, and then makes that move in the game.
	 * 
	 */
	public void makeMove() throws IOException {
		int moveCol = -1, moveRow = -1;
		BufferedReader stdin;
		
		do {
			// Check for previous input error
			if (moveCol != -1 || moveRow != -1) {
				System.out.println("Please try entering a row and column again, as an invalid move was just made.");
			}
			
			// Init input buffer
			stdin = new BufferedReader(new InputStreamReader(System.in));
			
			// Read the Row/Column to make the move in
			System.out.print(getName() + ", enter the row to place \'" + getMark() + "\' mark in: ");
			moveRow = Integer.parseInt(stdin.readLine());
			System.out.print(getName() + ", enter the column to place \'" + getMark() + "\' mark in: ");
			moveCol = Integer.parseInt(stdin.readLine());
		} while (super.board.getMark(moveRow, moveCol) != SPACE_CHAR);
		
		
		// Add the mark to that row/column location
		super.board.addMark(moveRow, moveCol, super.getMark());
	}

}
