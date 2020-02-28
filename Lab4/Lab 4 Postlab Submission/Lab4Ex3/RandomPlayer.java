
public class RandomPlayer extends Player {

	public RandomPlayer(String name, char mark) {
		super(name, mark);
	}
	
	/**
	 * Makes a valid random move.
	 * This method can assume that there is always a move that can be made.
	 * 
	 */
	protected void makeMove() {
		int moveCol, moveRow;
		
		do {
			// Make a Random Generator
			RandomGenerator ranGen = new RandomGenerator();
			
			// Generate a random row and col
			moveCol = ranGen.discrete(0, 2);
			moveRow = ranGen.discrete(0, 2);
			
		} while (super.board.getMark(moveRow, moveCol) != SPACE_CHAR);

		// Add the mark to that row/column location
		super.board.addMark(moveRow, moveCol, super.getMark());	
	}
}
