package be.vdab.entities;

public class Woord {
	private String woord;

	public String getWoord() {
		return woord;
	}

	public void setWoord(String woord) {
		this.woord = woord;
	}

	public Woord(String woord) {
		this.woord = woord;
	}
	
	public boolean isPalindroom() {
		StringBuilder str = new StringBuilder(woord);
		return woord.equals(str.reverse().toString());
	}
}
