package be.vdab.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.repositories.KostRepository;
import be.vdab.repositories.OpbrengstRepository;

public class WinstServiceTest {
	private KostRepository kostRepository;
	private OpbrengstRepository opbrengstRepository;
	private WinstService winstService;
	
	@Before
	public void before() {
		kostRepository = mock(KostRepository.class);
		opbrengstRepository = mock(OpbrengstRepository.class);
		when(kostRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(59.99));
		when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(105.99));
		winstService = new WinstService(opbrengstRepository, kostRepository);
	}
	
	@Test
	public void getWinst_withStubParameters_bigDecimal90() {
		assertEquals(0,BigDecimal.valueOf(46).compareTo(winstService.getWinst()));
		verify(kostRepository).findTotaleKost();
		verify(opbrengstRepository).findTotaleOpbrengst();
	}
}
