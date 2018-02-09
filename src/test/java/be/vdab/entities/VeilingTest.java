package be.vdab.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VeilingTest {
	private Veiling veiling;
	@Before
	public void before() {
		veiling = new Veiling();
	}
	
	@Test
	public void hoogsteBod_zonderBod_isNul() {
		assertEquals(0, veiling.getHoogsteBod());
	}
	
	@Test
	public void hoogsteBod_metEenBod_isHetBod() {
		veiling.doeBod(1000);
		assertEquals(1000, veiling.getHoogsteBod());
	}
	
	@Test
	public void hoogsteBod_metBiedingen_isHoogsteBod() {
		veiling.doeBod(1000);
		veiling.doeBod(2000);
		veiling.doeBod(500);
		assertEquals(2000, veiling.getHoogsteBod());
	}
}
