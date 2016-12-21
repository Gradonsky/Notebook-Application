/**
 *  @author Gradonski Janusz
 *  @Version 3.0
 *   Notizbuch V3
 *   Die Notizbuch-App aus A04 soll verändert werden, dass ein HashSet/TreeSet statt einer ArrayList verwendet wird. 
 *   Das Programm soll weiterhin die selben Funktionalitäten bieten,
 *   allerdings die Set-Eigenschaft, gleiche Notizen nicht zu speichern verwenden.
 *   
 */

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;

public class View extends JFrame {


	// Erstellen der Attribute 
		
	public JList<String> titles;
	public DefaultListModel<String> dlm;
	
	// ** CONTROL UND NOTIZBUCH ** //
	Control control;
	Notizbuch notizbuch;
	
	//** JPANEL ** //
	public JPanel screen;
	public JPanel right;
	public JPanel left;
	public JPanel buttons;
	public JLabel labeltitle;
	

	// ** JBUTTON ** //
	public JButton jneu;
	public JButton jrem;
	public JButton jspei;
	public JButton sortaz;
	public JButton sortza;

	// ** TEXT ** //
	public JTextArea inhalt;
	public JTextField title;

	// Konstruktor (Initialisierung der Attribute)
	public View(Control control, Notizbuch notizbuch) {
		this.control = control;
		this.notizbuch = notizbuch;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setTitle("Notizbuch");
		setLayout(new BorderLayout());
		
		// ** Neues JPanel ** //
		screen = new JPanel();
		right = new JPanel();
		left = new JPanel();
		buttons = new JPanel();

		// ** DIE LAYOUTS INITIALISIEREN ** //
		screen.setLayout(new GridLayout(0, 2));
		buttons.setLayout(new GridLayout(0, 5));
		right.setLayout(new BorderLayout());
		left.setLayout(new BorderLayout());

		inhalt = new JTextArea();

		dlm = new DefaultListModel<String>();

		titles = new JList<String>(dlm);

		title = new JTextField("Titel");

		labeltitle = new JLabel("Titel", JLabel.CENTER);

		// ** JButtons ** /
		//** INITIALISIERuNG ** //
		sortaz = new JButton("Sortieren a-z");
		sortza = new JButton("Sortieren z-a");
		jneu = new JButton("neue Notiz");
		jrem = new JButton("Notiz Loschen");
		jspei = new JButton("Speichern");

		// ** ActionListeners ** //
		jneu.addActionListener(control);
		jrem.addActionListener(control);
		jspei.addActionListener(control);
		titles.addMouseListener(control);
		sortaz.addActionListener(control);
		sortza.addActionListener(control);

		right.add(title, BorderLayout.NORTH);
		right.add(inhalt, BorderLayout.CENTER);
		left.add(labeltitle, BorderLayout.NORTH);
		left.add(titles, BorderLayout.CENTER);
		buttons.add(jneu);
		buttons.add(jrem);
		buttons.add(jspei);
		buttons.add(sortaz);
		buttons.add(sortza);

		screen.add(left);
		screen.add(right);
		add(screen, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);

		inhalt.setBackground(Color.decode("#ffdead"));
		;

		setVisible(true);
	}

	
	 /**
	  * Methode Neu
	  * @param e
	  * @return
	  */
	public boolean isNeu(ActionEvent e) {
		if (e.getSource() == jneu) {
			return true;
		}
		return false;
	}
	
	/**
	 * Methode Löschen
	 * @param e
	 * @return
	 */
	public boolean isDel(ActionEvent e) {
		if (e.getSource() == jrem) {
			return true;
		}
		return false;
	}

	/**
	 * Methode Speichern
	 * @param e
	 * @return
	 */
	public boolean isSave(ActionEvent e) {
		if (e.getSource() == jspei) {
			return true;
		}
		return false;
	}
	/**
	 * Methode Sortieren A-Z
	 * @param e
	 * @return
	 */
	public boolean isAtoz(ActionEvent e) {
		if (e.getSource() == sortaz) {
			return true;
		}
		return false;
	}
	/**
	 * Methode Sortieren Z-A
	 * @param e
	 * @return
	 */
	public boolean isZtoa(ActionEvent e) {
		if (e.getSource() == sortza) {
			return true;
		}
		return false;
	}

}
