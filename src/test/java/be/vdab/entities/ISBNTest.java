package be.vdab.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ISBNTest {
	@Test(expected = IllegalArgumentException.class)
	public void ibsn_initializeWith0_exception() {
		new ISBN(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ibsn_initializeWithLessThan0_exception() {
		new ISBN(-9783161484100L);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void ibsn_moreThan13Digits_exception() {
		new ISBN(97845678901234L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ibsn_lessThan13Digits_exception() {
		new ISBN(978456789012L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ibsn_3FirstDigitsLessThan978_exception() {
		new ISBN(9774567890123L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ibsn_3FirstDigitsMoreThan979_exception() {
		new ISBN(9804567890123L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ibsn_1OfInControl_exception() {
		new ISBN(9789027439643L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ibsn_1UpInControl_exception() {
		new ISBN(9789027439641L);
	}
	
	@Test
	public void isbn_sumOfNumbersEquals10LastDigitIs0_valid(){
		new ISBN(9783161484100L);
	}
	
	@Test
	public void isbn_validISBN_valid(){
		new ISBN(9789027439642L);
	}
	
	@Test
	public void equals_sameNumber_true() {
		assertTrue(new ISBN(9789027439642L).equals(new ISBN(9789027439642L)));
	}
	
	@Test
	public void equals_differentNumber_false() {
		assertFalse(new ISBN(9789027439642L).equals(new ISBN(9783161484100L)));
	}
	
	@Test
	public void hashCode_sameNumber_sameHash() {
		assertEquals(new ISBN(9789027439642L).hashCode(), new ISBN(9789027439642L).hashCode());
	}
	
	@Test
	public void toString_returnString_true() {
		assertTrue(new ISBN(9789027439642L).toString() instanceof String);
	}
}
