package be.vdab.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WoordTest {
	@Test
	public void isPalindroom_geenPalindroomWoord_false() {
		Woord geenPalindroomWoord = new Woord("geenPalindroom");
		assertFalse(geenPalindroomWoord.isPalindroom());
	}
	
	@Test
	public void isPalindroom_eenPalindroomWoord_true() {
		Woord eenPalindroomWoord = new Woord("palindroom_moordnilap");
		assertTrue(eenPalindroomWoord.isPalindroom());
	}
	
	@Test
	public void isPalindroom_eenLeegWoord_true() {
		Woord eenPalindroomWoord = new Woord("");
		assertTrue(eenPalindroomWoord.isPalindroom());
	}
}
