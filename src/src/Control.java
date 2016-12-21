/**
 *  @author Gradonski Janusz
 *  @Version 3.0
 *   Notizbuch V3
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TreeSet;

public class Control implements ActionListener, MouseListener {

	View v;
	Notizbuch notizbuch;

	public Control() {
		v = new View(this, notizbuch);
		notizbuch = new Notizbuch();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.v.isNeu(e)) {

			this.v.title.setText("Title");
			this.v.inhalt.setText("");

		}

		if (this.v.isDel(e)) {
			this.notizbuch.delNotiz((String) this.v.titles.getSelectedValue());
			this.v.dlm.removeElementAt(v.titles.getSelectedIndex());
			this.v.title.setText("Titel");
			this.v.inhalt.setText("");
		}

		if (this.v.isSave(e)) {
			if (this.notizbuch.neueNotiz(v.title.getText(), v.inhalt.getText())) {
				this.v.dlm.addElement(v.title.getText());

			} else {
				this.notizbuch.setNotiz((String) v.titles.getSelectedValue(),
						v.inhalt.getText());
			}
		}
		if (this.v.isAtoz(e)) {
			this.v.dlm.removeAllElements();
			TreeSet<Notiz> list = this.notizbuch.changeSort(1);
			for (Notiz n : list) {

				this.v.dlm.addElement(n.getTitel());
			}

		}
		if (this.v.isZtoa(e)) {
			this.v.dlm.removeAllElements();
			TreeSet<Notiz> list = this.notizbuch.changeSort(-1);
			for (Notiz n : list) {

				this.v.dlm.addElement(n.getTitel());
			}

		}
	}

	public void mouseClicked(MouseEvent e) {
		this.v.title.setText(this.notizbuch.getNotiz(
				(String) this.v.titles.getSelectedValue()).getTitel());
		this.v.inhalt.setText(this.notizbuch.getNotiz(
				(String) this.v.titles.getSelectedValue()).getInhalt());
	}

	public static void main(String[] args) {

		new Control();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
