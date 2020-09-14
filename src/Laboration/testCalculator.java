package Laboration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Answers to the questions:
 * Kolla upp vad “Annotation” och vad “@Test” är till för : Metadata som säger vad t.ex metoden skall göra
 * Kolla upp vad “Assertion" är och vad assertEquals gör: Assertion är ett påstående som kan användas för att kontrollera "värden"
 * assertEquals kollar upp ifall värdena som inmatas är lika, t.ex. att 1+1 är 2.
 */

class testCalculator {

	@Test
	void addition() {
		System.out.println(" adding test");
		Calculator calc = new Calculator();
		assertEquals(2, calc.add(1, 1));
	}
	
	@Test
	void additionButFails() {
		System.out.println(" adding failing test");
		Calculator calc = new Calculator();
		assertEquals(2, calc.add(2, 1));
	}
	
	@Test
	void additionFailsAssertionFalse() {
		System.out.println(" adding test bul fail with assertFalse");
		Calculator calc = new Calculator();
		assertFalse(2 == calc.add(1,1));
	}
	
}
