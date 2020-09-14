package Laboration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testPalindrome {

	@Test
	void palindromeFail() {
		
		Palindrome pal = new Palindrome();
		assertTrue(pal.isPalindrome("test"));
	}
	
	@Test
	void palindromeTrue() {
		Palindrome pal = new Palindrome();
		assertTrue(pal.isPalindrome("abba"));
	}
	
	@Test
	void palindromeFalseEquals() {
		Palindrome pal = new Palindrome();
		assertEquals("anna", pal.palindromeString("alla"));
	}
	
	@Test
	void palindromeTrueEquals() {
		Palindrome pal = new Palindrome();
		assertEquals("anna", pal.palindromeString("anna"));
	}

}
