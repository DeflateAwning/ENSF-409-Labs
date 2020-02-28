

import java.io.*;

/**
 * Creates one of two players in the game, who play the Game. Each player plays against a single opponent Player on a single Game/Board.
 * 
 * @author Parker Link
 * @version 2.0.0
 * @since Feb. 5, 2020
 */
abstract public class Player implements Constants {
	/**
	 * The name of the player
	 */
	protected String name;
	
	/**
	 * The board on which the game is played
	 */
	protected Board board;
	
	/**
	 * A reference to the opponent player
	 */
	protected Player opponent;
	
	/**
	 * Storage of the mark that this player makes
	 */
	protected char mark;
	
	/**
	 * Creates a new player, with a given name and given mark. This player is then able to play the game.
	 * 
	 * @param name The name of this player
	 * @param mark The type of mark this player makes
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	/**
	 * Prompts the user to make a move in the game, or has the computer make a move.
	 */
	abstract protected void makeMove() throws IOException;
	
	/**
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
	
	
	/**
	 * Set an opponent to play against.
	 * 
	 * @param opponent The Player to set as an opponent to play against
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	/**
	 * Set the board to play on.
	 * 
	 * @param board The Board to set as the board to play on
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * Gets the name of this player.
	 * 
	 * @returns The name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the mark of this player.
	 * 
	 * @returns The mark of the player
	 */
	public char getMark() {
		return mark;
	}

}
