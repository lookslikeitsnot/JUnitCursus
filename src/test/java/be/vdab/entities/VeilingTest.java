package be.vdab.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VeilingTest {
	@Test
	public void hoogsteBod_zonderBod_isNul() {
		Veiling veiling = new Veiling();
		assertEquals(0, veiling.getHoogsteBod());
	}
	
	@Test
	public void hoogsteBod_metEenBod_isHetBod() {
		Veiling veiling = new Veiling();
		veiling.doeBod(1000);
		assertEquals(1000, veiling.getHoogsteBod());
	}
	
	@Test
	public void hoogsteBod_metBiedingen_isHoogsteBod() {
		Veiling veiling = new Veiling();
		veiling.doeBod(1000);
		veiling.doeBod(2000);
		veiling.doeBod(500);
		assertEquals(2000, veiling.getHoogsteBod());
	}
}
