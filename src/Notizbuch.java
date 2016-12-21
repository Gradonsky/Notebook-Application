/**
 *  @author Gradonski Janusz
 *  @Version 3.0
 *   Notizbuch V3
 */
import java.util.*;

public class Notizbuch {

	Notiz n1;
	Notiz n2;

	private TreeSet<Notiz> notizen;

	public Notizbuch() {
		this.notizen = new TreeSet<Notiz>();

	}

	/**
	 * Erstellt eine neue Notiz mit dem Inhalt und Betreff und speichert sie in
	 * den Treeset "notizen".
	 * 
	 * @param t
	 * @param i
	 */
	public boolean neueNotiz(String t, String i) {
		return this.notizen.add(new Notiz(t, i));
	}
	
	/**
	 * Holt sich eine Notiz von einer gewissen Stelle. Danach vergleicht die Methode
	 * die Titel und  liefert das Objekt Notiz zurück.
	 * @param titel
	 * @return
	 */
	public Notiz getNotiz(String titel) {
		for (Notiz n : notizen) {
			if (n.getTitel().equals(titel))
				return n;
		}
		return null;
	}

	public void setNotiz(String tOld, String i) {
		
		Notiz n = getNotiz(tOld);
		if(n != null){
		n.setInhalt(i);
		}
	}
	/**
	 *  Die gewählte Notiz wird gelöscht
	 * @param titel
	 * @return
	 */
	public void delNotiz(String titel) {
		notizen.remove(this.getNotiz(titel));
	}

	public TreeSet<Notiz> changeSort(int i){
		/*
		 * Sortieren 
		 */
		TreeSet<Notiz> temp = new TreeSet<Notiz>();
		temp.addAll(this.notizen);
		this.notizen.clear();
		for(Notiz n : temp) {
			n.changeSort(i);
			this.notizen.add(n);
		}
		return this.notizen;
	}
}
