import java.io.Serializable;

/** 
 * Creates a simple class that represents a music record.
 * Used for Task 1 only.
 * 
 * This class simply stores the four attributes declared at the top, with getters/setters for each.
 * 
 * Started by M. Moussavi
 * Completed by: Parker Link
 * 
 * @author Parker Link
 * @since Mar. 1, 2015
 * @version 2.0.0
 */
class MusicRecord implements Serializable { // added Serializable

	private static final long serialVersionUID = 1L; // this should be changed at some point
	
	private int year_recorded;
	private String songName;
	private String singerName;
	private double purchase_price;
	
    /**
     * A default constructor that builds a record with blank data
     */
	public MusicRecord() {
		this( 0, "", "", 0.0 ); 
	} 
  
    /**
     * A constructor that initializes the music records with supplied 
     * data.
     */
	public MusicRecord( int year, String song, String singer, double value ) {
		setYear( year );
		setSongName( song );
		setSingerName( singer );
		setPrice( value );
	} 
	
    
    /**
     * Sets the data field year_recorded to supplied argument year
     * data.
     */
	public void setYear( int year ) {
		year_recorded = year;
	}
    
    
    /**
     * Returns the recording year
     */
	public int getYear() {
		return year_recorded; 
	}
    
    /**
     * Sets the data field songName to supplied argument song
     */
	public void setSongName( String song ) {
		songName = song;
	}
    
    
    /**
     * Returns the songName name
     */
	public String getSongName()  {
		return songName; 
	} 
	
    /**
     * Sets the data field sinterName to supplied argument singer
     */
	public void setSingerName( String singer ) {
		singerName = singer;
	}
    
    /**
     * Returns the singer's name
     */
	public String getSingerName() {
		return singerName; 
	}
    
    /**
     * Sets the data field purchase_price to supplied argument price
     */
	public void setPrice( double value ) {
		purchase_price = value;
	}
    
    /**
     * Returns the price
     */
	public double getPurchasePrice(){
		return purchase_price; 
	} 
	
	/**
	 * Creates a String representation of this MusicRecord.
	 * 
	 * @return String representation of this MusicRecord
	 */
	public String toString() {
		String out = "";
		//out = "Record: ";
		out += getYear();
		out += "\t";
		out += "$" + getPurchasePrice();
		out += "\t";
		out += "'" + getSongName() + "'";
		out += " by ";
		out += "'" + getSingerName() + "'";
		
		return out;
		
	}
} 
