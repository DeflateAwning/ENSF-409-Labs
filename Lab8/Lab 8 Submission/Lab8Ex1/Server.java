import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implements a server for accessing from the client. The server returns
 * information about whether or not a palindrome was provided from the client.
 * 
 * @author Parker Link
 * @version 1.0.0
 * @since Mar. 25, 2020
 *
 */
public class Server {
	/**
	 * Provides a socket that the reader and writer can connect to directly.
	 */
	private Socket aSocket;
	
	/**
	 * Provides a socket that the client can connect to, that the local Socket can
	 * connect to.
	 */
	private ServerSocket serverSocket;
	
	/**
	 * Provides an interface to send data to the client.
	 */
	private PrintWriter socketOut;
	
	/**
	 * Provides an interface to read data from the client.
	 */
	private BufferedReader socketIn;
	
	/**
	 * Creates a new server, with default settings. This server is used to
	 * tell the client whether or not a word is a palindrome.
	 * 
	 * Creates the socket.
	 */
	public Server(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Handles a connection by parsing the input and returning whether or 
	 * not it is a palindrome.
	 */
	private void handleConnection() {
		String line = null;
		
		while (true) {
			try {
				// Read an Input Line from Client (remove leading/trailing whitespaces)
				line = socketIn.readLine().trim();
				
				// Check if the line wants to quit
				if (line.equals("QUIT")) {
					line = "Good Bye!";
					socketOut.println(line);
					break;
				}
				
				// Print the word back and to console (DEBUG)
				//socketOut.println(line);
				//System.out.println("Received Word: " + line);
				
				// Check if word is palindrome
				if (isPalindrome(line)) {
					socketOut.println(line + " is a palindrome.");
				}
				else {
					socketOut.println(line + " is not a palindrome.");
				}
				
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
	}
	
	/**
	 * Inits the server by waiting for an incoming connection,
	 * then creating the socketIn and socketOut reader/writer.
	 */
	public void acceptConnection() {
		try {
			aSocket = serverSocket.accept();
			System.out.println("Accepted connection from client.");
			
			socketIn = new BufferedReader (new InputStreamReader (aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
		}
		
		catch (IOException e) {
			System.err.println("Error accepting connection.");
			e.printStackTrace();
		}
		
		// Handle the Connection
		handleConnection();
	}
	
	/**
	 * Returns whether or not a word is a palindrome. This method assuming the
	 * input is already lowercase (as per lab spec).
	 * 
	 * @param word The word to check
	 * @return Whether or not the word is a palindrome
	 */
	private boolean isPalindrome(String word) {
		for (int i = 0; i < (word.length() / 2) + 1; i++) {
			if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Closes all open connections/sockets/readers.
	 */
	public void close() {
		try {
			socketIn.close();
			socketOut.close();
		}
		catch (IOException e) {
			System.err.println("Error closing server.");
			e.printStackTrace();
		}
	}

	/**
	 * Creates a server and runs it.
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		System.out.println("Server is now running.");
		
		// Make a new server
		Server server = new Server(8099);

		// Accept connections on the server
		server.acceptConnection();
	}

}
