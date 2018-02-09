package be.vdab.entities;

public class Veiling {
	private int bod;
	public void doeBod(int bedrag) {
		bod = bedrag>bod ? bedrag : bod;
	}
	public int getHoogsteBod() {
		return bod;
	}
}
