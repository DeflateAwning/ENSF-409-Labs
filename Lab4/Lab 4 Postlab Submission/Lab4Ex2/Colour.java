
class Colour
{
    private String colour;
    
	public Colour(String s) {
		colour = new String(s);
	}


    public void setColour(String newColour){
    	colour = newColour;
    }
    
	@Override
	public String toString(){
		return colour;
	}
	
	public int compareTo(Colour c) {
		return colour.compareTo(c.toString());
	}

}
