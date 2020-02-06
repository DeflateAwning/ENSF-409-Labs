
import java.io.*;

/*
 * Creates one of two players in the game, who play the Game. Each player plays against a single opponent Player on a single Game/Board.
 * 
 * @author Parker Link
 * @version 1.0.0
 * @since Feb. 5, 2020
 */
public class Player implements Constants{
	/*
	 * The name of the player
	 */
	private String name;
	
	/*
	 * The board on which the game is played
	 */
	private Board board;
	
	/*
	 * A reference to the opponent player
	 */
	private Player opponent;
	
	/*
	 * Storage of the mark that this player makes
	 */
	private char mark;
	
	/*
	 * Creates a new player, with a given name and given mark. This player is then able to play the game.
	 * 
	 * @param name The name of this player
	 * @param mark The type of mark this player makes
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	/* 
	 * Make a play, if no one has won yet, and the board is not yet full. This calls makeMove(), and displays the board.
	 * 
	 */
	public void play() throws IOException {
		// Check if no one has won, and the board is not full yet
		if (!board.xWins() && !board.oWins() && !board.isFull()) {
			// Let a player make a move
			makeMove();
			
			// Display the board
			board.display();
			
			// Pass the turn to the other player
			opponent.play();
			
		}
		else {
			// Announce that the game is over, display who won
			System.out.print("The game is now over: ");
			
			String winnerName = "";
			char winnerMark = 0;
			
			if (board.xWins() || board.oWins()) {
				// Someone has won, who?
				
				if (board.xWins()) {
					winnerMark = LETTER_X;
					if (this.mark == LETTER_X) {
						winnerName = getName();
					}
					else {
						winnerName = opponent.getName();
					}
				}
				else if (board.oWins()) {
					winnerMark = LETTER_O;
					if (this.mark == LETTER_O) {
						winnerName = getName();
					}
					else {
						winnerName = opponent.getName();
					}
				}
				
				System.out.println("Player \'" + winnerMark + "\' (" + winnerName + ") wins the game!");
			}
			else {
				System.out.println("The game ended in a tie.");
			}
		}
		
	}
	
	/*
	 * Prompts the user to make a move in the game, asking for the row and column. This method would be better as private.
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
			System.out.print(name + ", enter the row to place \'" + mark + "\' mark in: ");
			moveRow = Integer.parseInt(stdin.readLine());
			System.out.print(name + ", enter the column to place \'" + mark + "\' mark in: ");
			moveCol = Integer.parseInt(stdin.readLine());
		} while (board.getMark(moveRow, moveCol) != SPACE_CHAR);
		
		
		// Add the mark to that row/column location
		board.addMark(moveRow, moveCol, mark);
		
		
	}
	
	/*
	 * Set an opponent to play against.
	 * 
	 * @param opponent The Player to set as an opponent to play against
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	/*
	 * Set the board to play on.
	 * 
	 * @param board The Board to set as the board to play on
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/*
	 * Gets the name of this player.
	 * 
	 * @returns The name of the player
	 */
	public String getName() {
		return name;
	}

}
