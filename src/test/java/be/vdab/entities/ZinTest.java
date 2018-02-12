package be.vdab.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZinTest {
	@Test(expected = IllegalArgumentException.class)
	public void Zin_emptyString_exception() {
		new Zin("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Zin_nullString_exception() {
		new Zin(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Zin_spacesString_exception() {
		new Zin(" ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Zin_commasString_exception() {
		new Zin(",");
	}
	
	@Test
	public void getAantalWoorden_noSeparators_1() {
		assertEquals(1, new Zin("word").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_spacesLeadAndTail_1() {
		assertEquals(1, new Zin(" word ").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_commasLeadAndTail_1() {
		assertEquals(1, new Zin(",word,").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_commaSeparator_2() {
		assertEquals(2, new Zin("word,other").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_spaceSeparator_2() {
		assertEquals(2, new Zin("word other").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_spaceAndCommaSeparator_3() {
		assertEquals(3, new Zin("word other,yetAnother").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_commaAndSpaceSeparator_3() {
		assertEquals(3, new Zin("word,other yetAnother").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_2SpacesSeparator_2() {
		assertEquals(2, new Zin("word  other").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_2CommasSeparator_2() {
		assertEquals(2, new Zin("word,,other").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_2Commas1SpaceSeparator_2() {
		assertEquals(2, new Zin("word, ,other").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_2Spaces1CommaSeparator_2() {
		assertEquals(2, new Zin("word , other").getAantalWoorden());
	}
	
	@Test
	public void getAantalWoorden_longPhrase_9() {
		assertEquals(9, new Zin("Dit, dames en heren, is een vrij lange zin.").getAantalWoorden());
	}
}
