
import java.io.*;

/*
 * Creates a Referee that monitors the Game, helps set the board, and verifies that the game runs correctly.
 * 
 * @author Parker Link
 * @version 1.0.0
 * @since Feb. 5, 2020
 */
public class Referee {
	/*
	 * Reference to Player 'X'
	 */
	private Player xPlayer;
	
	/*
	 * Reference to Player 'O'
	 */
	private Player oPlayer;
	
	/*
	 * The board the game is played on
	 */
	private Board board;
	
	/* 
	 * Runs the Game. 
	 * Used as an entry point to the entire, from this class down.
	 * Sets the opponents of each player, then initiates the game by displaying the board, and calling the play method for the 'X' Player (who is always first)
	 * 
	 */
	public void runTheGame() throws IOException {
		// Set the Opponents
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		
		// Display the Board
		System.out.println("Referee started the game...");
		board.display();
		
		// Being the X Player playing the game
		xPlayer.play();
		
	}
	
	/*
	 * Setter method for board. Sets the board that the Referee is to reference.
	 * 
	 * @param board The board to set for the referee to monitor
	 */
	public void setBoard(Board board) {
		this.board = board;
		
	}
	
	/*
	 * Setter method for xPlayer. Sets the xPlayer for the referee to reference.
	 * 
	 * @param xPlayer The 'X' Player, playing the game
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
	
	/*
	 * Setter method for oPlayer. Sets the oPlayer for the referee to reference.
	 * 
	 * @param oPlayer The 'O' Player, playing the game
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}

	
}


