import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implements a server for accessing from the client, hosting many games of TicTacToe. The server
 * returns information on the game, and hosts itself via a thread pool.
 * 
 * Heavily adapted from Lab8Ex1/Server.java.
 * 
 * @author Parker Link
 * @version 2.0.0
 * @since Mar. 30, 2020
 *
 */
public class TTTServer {

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
	 * Creates a new server, with default settings.
	 * 
	 * Creates the socket.
	 */
	public TTTServer(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Handles a connection by parsing the input
	 * 
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
		TTTServer server = new TTTServer(8099);

		// Accept connections on the server
		server.acceptConnection();
	}

}
