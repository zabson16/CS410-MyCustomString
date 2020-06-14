import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @BeforeEach
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @AfterEach
    public void tearDown() {
        mycustomstring = null;
    }

    //This test checks if countNumbers returns correct number of numbers in the current string
    //having variation of single digits as well as contiguous sequence of digits to count as a number
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    //This test checks if countNumbers returns 0 if the current string is empty
    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    //This test checks if countNumbers returns 0 if the current string is unset(null)
    @Test
    public void testCountNumbers3() {
        assertEquals(0, mycustomstring.countNumbers());
    }

    //This test checks if countNumbers returns 0 for string with no digits (means proper counting)
    @Test
    public void testCountNumbers4() {
    	mycustomstring.setString("  hello-!@s");
        assertEquals(0, mycustomstring.countNumbers());
    }

    //This test checks if countNumbers returns 1 for a string with just a repeating digit (no spaces, letters, symbols)
    @Test
    public void testCountNumbers5() {
    	mycustomstring.setString("111111");
        assertEquals(1, mycustomstring.countNumbers());
    }


    //This test checks if removeEveryNthCharacter returns a string without every nth (here 3rd, 6th, 9th, etc) character
    //from a current string
    @Test
    public void testremoveEveryNthCharacter1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", mycustomstring.removeEveryNthCharacter(3, false));
    }

    //This test checks if removeEveryNthCharacter returns a string without every nth (here 3rd, 6th, 9th, etc) character
    //from a current string, replacing those with a whitespace
    @Test
    public void testremoveEveryNthCharacter2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", mycustomstring.removeEveryNthCharacter(3, true));
    }

    //This test checks if removeEveryNthCharacter throws IndexOutOfBoundsException if n is greater than string length
    @Test
    public void testremoveEveryNthCharacter3() {
    	mycustomstring.setString("My 0grandma0 is great!");
        assertThrows(IndexOutOfBoundsException.class, () -> mycustomstring.removeEveryNthCharacter(25, true));   
    }

    //This test checks if removeEveryNthCharacter throws NullPointerException if the current string is null
    @Test
    public void testremoveEveryNthCharacter4() {
        assertThrows(NullPointerException.class, () -> mycustomstring.removeEveryNthCharacter(5, true)); 
    }

    //This test checks if removeEveryNthCharacter throws IllegalArgumentException if n is equal to 0
    @Test
    public void testremoveEveryNthCharacter5() {
    	mycustomstring.setString("I love CS");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.removeEveryNthCharacter(0, false));
    }

    //This test checks if removeEveryNthCharacter throws IllegalArgumentException if n is less than 0
    @Test
    public void testremoveEveryNthCharacter6() {
    	mycustomstring.setString("My grandma is great!");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.removeEveryNthCharacter(-5, true));
    }

    //This test checks if removeEveryNthCharacter throws IllegalArgumentException if string is empty
    //and n is equal to 0
    @Test
    public void testremoveEveryNthCharacter7() {
    	mycustomstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.removeEveryNthCharacter(0, true));
    }
    
    //This test checks if removeEveryNthCharacter throws IllegalArgumentException if string is empty
    //and n is less than 0
    @Test
    public void testremoveEveryNthCharacter8() {
    	mycustomstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.removeEveryNthCharacter(-6, false));
    }

    //This test checks if removeEveryNthCharacter throws IndexOutOfBoundsException if string is empty
    //and n is greater than string length
    @Test
    public void testremoveEveryNthCharacter9() {
    	mycustomstring.setString("");
        assertThrows(IndexOutOfBoundsException.class, () -> mycustomstring.removeEveryNthCharacter(1, true));   
    }
    

    //This test checks if convertDigitsToNamesInSubstring returns a string with digit names in a correct format in place
    //of digits themselves within a given substring with starting position (here 17) and ending position (here 23) in a current string
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put szerome done-six1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    //This test checks if convertDigitsToNamesInSubstring throws IndexOutOfBoundsException if string is empty and
    //endPosition is greater than the current string length
    @Test
    public void testConvertDigitsToNamesInSubstring2() {
    	mycustomstring.setString("");
        assertThrows(IndexOutOfBoundsException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(1, 6));
    }

    //This test checks if convertDigitsToNamesInSubstring throws IllegalArgumentException if the string is empty and
    //startPosition is less than 1 and startPosition is less than endPosition
    @Test
    public void testConvertDigitsToNamesInSubstring3() {
    	mycustomstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(-2, 0));
    }

    //This test checks if convertDigitsToNamesInSubstring throws IllegalArgumentException if startPosition is less than 1
    //and startPosition is equal to endPosition
    @Test
    public void testConvertDigitsToNamesInSubstring4() {
    	mycustomstring.setString("Hello year 2020");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(0, 0));
    }
    
    //This test checks if convertDigitsToNamesInSubstring throws IllegalArgumentException if startPosition is less than 1
    //and startPosition is less then endPosition
    @Test
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.setString("My grandma is great!");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(-3, 0));
    }
    
    //This test checks if convertDigitsToNamesInSubstring throws IndexOutOfBoundsException if startPosition
    //is greater than endPosition
    public void testConvertDigitsToNamesInSubstring6() {	
    	mycustomstring.setString("This 7string45 is for my testing0");
        assertThrows(IndexOutOfBoundsException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(9, 4));
    }

    //This test checks if convertDigitsToNamesInSubstring throws IndexOutOfBoundsException if endPosition
    //is greater than the current string length
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
    	mycustomstring.setString("Just having 10fun");
        assertThrows(IndexOutOfBoundsException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(3, 22));
    	
    }
    
    //This test checks if convertDigitsToNamesInSubstring throws IndexOutOfBoundsException if string is empty and
    //startPosition is greater than endPosition
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
    	mycustomstring.setString("");
        assertThrows(IndexOutOfBoundsException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(4, 1));
    }

    //This test checks if convertDigitsToNamesInSubstring throws IllegalArgumentException if the string is empty and
    //startPosition is less than 1 and startPosition is equal to endPosition
    @Test
    public void testConvertDigitsToNamesInSubstring9() {
    	mycustomstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(0, 0));
    }
    
    //This test checks if convertDigitsToNamesInSubstring throws NullPointerException if the current string is null
    @Test
    public void testConvertDigitsToNamesInSubstring10() {
    	assertThrows(NullPointerException.class, () -> mycustomstring.convertDigitsToNamesInSubstring(1, 4));
    }

}
