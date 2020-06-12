public class MyCustomString implements MyCustomStringInterface {
	
	private String string;
	
    @Override
    public String getString() {
        if(string==null)
        	return null;
        return string;
    }

    @Override
    public void setString(String string) {
    	this.string = string;
    }

    @Override
    public int countNumbers() {
        int count = 0;
        boolean isPrevADigit = false;
        
        if(string == null || string.isEmpty()) 
        	return 0;	
	    for(int i = 0; i < string.length(); i++) {
	    	if(Character.isDigit(string.charAt(i))) {
	    		if(!isPrevADigit) {
	    			count++;
	    			isPrevADigit = true;
	    		} 
	    	} else {
	    		isPrevADigit = false;
	    	}    	
	    }
	    return count;
    }

    @Override
    public String removeEveryNthCharacter(int n, boolean maintainSpacing) throws IndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
 
    	String newstring = "";
    	if(string == null)
    		throw new NullPointerException();
    	if(n > string.length())
        	throw new IndexOutOfBoundsException();
    	if(n <= 0)
    		throw new IllegalArgumentException();
    	
    	for(int i = 0; i < string.length(); i++) {
    		if((i+1) % n == 0) 
    		{
    			if(maintainSpacing==false) {
    				newstring+= "";
    			} 
    			else if(maintainSpacing==true) {
    				newstring+=" ";
    			}
    		} 
    		else {
    			newstring+= string.charAt(i);
    		}
    	}
    	return newstring;   	
    }
    
    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) throws NullPointerException, IndexOutOfBoundsException, IllegalArgumentException{
       	
    	if(string == null)
    		throw new NullPointerException();
    	if(startPosition > endPosition || endPosition > string.length())
    		throw new IndexOutOfBoundsException();
    	if((startPosition <= endPosition && startPosition < 1))
    		throw new IllegalArgumentException();  	
    		
    	String mystring = "";
    	String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	boolean isPreviousADigit = false;
    	for(int i = 0; i < string.length(); i++) {
    		if(i >= startPosition-1 && i < endPosition) {
			    		if(Character.isDigit(string.charAt(i))) {
			    			if(!isPreviousADigit) {
			    				mystring+=nums[string.charAt(i) - '0'];			   
			    				isPreviousADigit = true;
			    			} else {
			    				mystring+="-" + nums[string.charAt(i) - '0'];
			    				isPreviousADigit = true;
			    			}					    			
			    		} else {
			    			mystring+=string.charAt(i);
			    			isPreviousADigit = false;
			    		}		
    		} 
    		else {
    			mystring+=string.charAt(i);			
    			}  		
    	}
    	string = mystring;    	
    }
    
}
