/**
 *  @author Gradonski Janusz
 *  @Version 3.0
 *   Notizbuch V3
 */

public class Notiz implements Comparable<Notiz> {

	private int sort;
	private String titel;
	private String inhalt;

	public Notiz(String t, String i) {
		setTitel(t);
		setInhalt(i);
		this.sort = 1;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
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
		Notiz other = (Notiz) obj;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}

	public void changeSort(int i) {
		this.sort = i;
	}

	@Override
	public int compareTo(Notiz n2) {
	//	System.out.println(this.sort);
		return (this.getTitel().toLowerCase()
				.compareTo(n2.getTitel().toLowerCase()) * this.sort);
	}

}
