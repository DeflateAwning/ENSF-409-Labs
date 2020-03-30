package inlab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Implements a client that can be used to access the DateServer provided for this lab.
 * Connects to the server running on Port 9090.
 * 
 * @author Parker Link
 * @version 1.0.1
 * @since Mar. 30, 2020
 * 
 */
public class DateClient {
	/**
	 * Interface for sending data out of the socket (client to server).
	 */
	private PrintWriter socketOut;
	
	/**
	 * Interface for receiving data into the socket (server to client).
	 */
	private BufferedReader socketIn;
	
	/**
	 * The main socket itself, for communicating with the server.
	 */
	private Socket socket;
	
	/**
	 * Reader for reading from stdin (standard input), from the user.
	 */
	private BufferedReader stdinReader;

	/**
	 * Creates a new DateClient, which access a DateServer to get the current date on the server.
	 * 
	 * @param serverAddress The server address to access (ex: localhost, 192.168.0.43)
	 * @param serverPort The port to access the server at (ex: 9090)
	 */
	public DateClient(String serverAddress, int serverPort) {
		// Create the user input reader
		stdinReader = new BufferedReader(new InputStreamReader(System.in));

		// Create socket, reader, and writer
		try {
			socket = new Socket(serverAddress, serverPort);
			socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketOut = new PrintWriter((socket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println("Error creating sockets, readers, and writers.");
			System.err.println(e.getStackTrace());
		}
	}
	
	/**
	 * Communicates with the server by prompting the user for input, and completing the request with the server.
	 * This method runs infinitely.
	 */
	public void communicate() {
		String lineFromUser = "";
		String serverResponse = "";
		boolean continueRunning = true;
		
		while (continueRunning) {
			System.out.println("Please select an option (DATE or TIME): ");
			try {
				// Read the line from the user
				lineFromUser = stdinReader.readLine().trim();
				
				// Check for quit option
				if (lineFromUser.toLowerCase() == "quit") {
					continueRunning = false;
				}
				else {
					// DEBUG: Print the line read back
					System.out.println("Read: " + lineFromUser);
					
					// Send to Server
					socketOut.println(lineFromUser);
					
					// Read Response from Server
					serverResponse = socketIn.readLine();
					
					// Print the Server's Response
					System.out.println(serverResponse);
				}
			}
			
			catch (IOException e) {
				System.err.println("Error sending to server: " + e.getMessage());
			}
			
		}
		
		// Close all Connections
		close();
		System.out.println("Exiting...");
		
	}
	
	/**
	 * Closes all socket and reader connections.
	 * Prints an error message if it fails.
	 * 
	 */
	public void close() {
		try {
			stdinReader.close();
			socketIn.close();
			socketOut.close();
		}
		
		catch (IOException e) {
			System.err.println("Closing Error: " + e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Opening connection from client to server...");
		
		// Create the DateClient object for accessing the server
		DateClient client = new DateClient("localhost", 9090);
		
		// Communicate with the server forever
		client.communicate();
		
	}

}
