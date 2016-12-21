/**
 *  @author Gradonski Janusz
 *  @Version 3.0
 *   Notizbuch V3
 *   
 */

public class Notiz implements Comparable<Notiz> {
	
// Die Attribute sort ,titel und inhalt werden erstellt. 	
	private int sort;
	private String titel;
	private String inhalt;

// *** Konstruktor (Die Attribute werden initialisiert) *** //
	public Notiz(String t, String i) {
		setTitel(t);
		setInhalt(i);
		this.sort = 1;
	}
// Getter-und Setter-Methoden
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
// Override von hashCode methode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
		return result;
	}
// Override von equals methode
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

	/* Override von der compareTo methode.
	* Die Methode compareTo() ist nützlich, wenn Objekte eines Typs in einem baum-basierten Container wie java.util.TreeSet oder java.util.TreeMap 
	* abgelegt werden sollen oder wenn Sequenzen solcher Objekte (mit Hilfe von Sortiermethoden wie  Arrays.sort()) sortiert werden sollen. 
	*/
	
	@Override
	public int compareTo(Notiz n2) {
		return (this.getTitel().toLowerCase()
				.compareTo(n2.getTitel().toLowerCase()) * this.sort);
	}

}
