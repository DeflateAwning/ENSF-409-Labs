
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/** 
 * Started by M. Moussavi
 * Completed by: Parker Link
 * 
 * @author Parker Link
 * @since Mar. 1, 2015
 * @version 2.0.0
 */
public class ReadRecord {
    
    private ObjectInputStream input;
    
    /**
     * Opens an ObjectInputStream using a FileInputStream.
     * 
     * @param name The name of the file to read
     */
    private void readObjectsFromFile(String name)
    {
        MusicRecord record = null;
        
        try
        {
            input = new ObjectInputStream(new FileInputStream( name ) );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
        
        /* The following loop is supposed to use readObject method of
         * ObjectInputSteam to read a MusicRecord object from a binary file that
         * contains several records.
         * Loop should terminate when an EOFException is thrown.
         */
        
        try
        {
            while ( true )
            {
            	try {
            		record = (MusicRecord) input.readObject();
            	}
            	catch (EOFException e) {
            		// Reached end of items, just exit nicely
            		break;
                }
                
                System.out.println(record);
            }
        }
        
        catch (ClassNotFoundException e) {
        	System.err.println("Class Not Found Error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}

    }

    public static void main(String [] args)
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("allSongs.ser");
    }
}