
import java.io.*;


/*
 * Creates a single Game, the highest level of game play. Each game contains a Board, two Players, a Referee, and is capable of assisting in playing the game.
 * Inputs are read inside the Game class.
 * 
 * @author Parker Link
 * @version 1.0.0
 * @since Feb. 5, 2020
 */
public class Game implements Constants {

	/*
	 * The board that the game is played on.
	 */
	private Board theBoard;
	
	/*
	 * The referee that assists in monitoring the game.
	 */
	private Referee theRef;
	
	/*
	 * Creates a new game, which instantiates a new Board (in a composition-type relationship).
	 */
    public Game() {
        theBoard  = new Board();
	}
    
    /*
     * Appoints a new referee to monitor the game. Throws an error if an IOException occurs.
     * 
     * @param r The Referee object to appoint as the new referee.
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
    /*
     * The main entry point of the entire game, which aids in running the entire system. IO is handled through this class via stin.
     * 
     * @param args Runtime arguments, currently unused.
     */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}
