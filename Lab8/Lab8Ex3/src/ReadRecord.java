
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
     */
    private void readObjectsFromFile(String name)
    {
        MusicRecord record;
        
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
         * contains several reords.
         * Loop should terminate when an EOFException is thrown.
         */
        
        try
        {
            while ( true )
            {
                
                
                // TO BE COMPLETED BY THE STUDENTS
                
           
            }   // END OF WHILE
        }
        
        catch (Exception e) {
        	
        }

    }

    public static void main(String [] args)
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("mySongs.ser");
    }
}