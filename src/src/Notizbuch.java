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


	public boolean neueNotiz(String t, String i) {
		return this.notizen.add(new Notiz(t, i));
	}

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

	public void delNotiz(String titel) {
		notizen.remove(this.getNotiz(titel));
	}

	public TreeSet<Notiz> changeSort(int i){
		
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
