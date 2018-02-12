package be.vdab.entities;

public class ISBN {
	private long nummer;
	private static final long lowestISBN = 978_0_000_000_000L;
	private static final long highestISBN = 979_9_999_999_999L;
	
	
	public ISBN(long nummer) {
		if(nummer < lowestISBN || nummer > highestISBN) {
			throw new IllegalArgumentException();
		}
		int eerste6Oneven = 0;
		int eerste6Even = 0;
		String nummerString = Long.toString(nummer);
		for(int i = 0; i < 12; i+=2) {
			eerste6Oneven += Character.getNumericValue(nummerString.charAt(i));
			eerste6Even += Character.getNumericValue(nummerString.charAt(i+1));
		}
		int somGetallen = eerste6Oneven + eerste6Even*3;
		int nearestTen = ((somGetallen+10)/10)*10;
		int rest = nearestTen - somGetallen;
		int lastDigit = Character.getNumericValue(nummerString.charAt(12));
		if(!(rest==10 ? lastDigit==0 : rest==lastDigit)) {
			throw new IllegalArgumentException();
		}
		this.nummer = nummer;
	}
	
	@Override
	public String toString() {
		return Long.toString(nummer);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (nummer ^ (nummer >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ISBN other = (ISBN) obj;
		if (nummer != other.nummer)
			return false;
		return true;
	}
	
	
}
