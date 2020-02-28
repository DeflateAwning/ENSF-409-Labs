

class Colour implements Cloneable
{
    private String colour;
    
	public Colour(String s) {
		colour = new String(s);
	}
	
	public Colour clone() throws CloneNotSupportedException {
		Colour obj = (Colour)super.clone();
		
		return obj;
		
	}
	
    public void setColour(String newColour){
    	colour = newColour;
    }
    
	@Override
	public String toString(){
		return colour;
	}

}
