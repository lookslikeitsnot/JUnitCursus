package be.vdab.entities;

import java.util.StringTokenizer;

public class Zin {
	private final String zin;
	public Zin(String zin) {
		if(!(zin instanceof String)) {
			throw new IllegalArgumentException();
		}
		if(zin.replaceAll(",", " ").trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.zin = zin;
	}
	
	public int getAantalWoorden() {
		return new StringTokenizer(zin, " ,").countTokens();
	}
}
