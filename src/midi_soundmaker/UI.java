package midi_soundmaker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UI extends JFrame implements KeyListener {

	JLabel label;

	public static int note = 0;
	public static JLabel LabelLeft;
	public static String numOfNotes = "amount: 0";
	String noteString = "notes ";
	int counter;
	int typeRight;

	public UI(String s) {
		super(s);

		JPanel p = new JPanel();
		label = new JLabel("notes");
		LabelLeft = new JLabel(numOfNotes);

		p.add(label);
		p.add(LabelLeft);

		add(p);
		addKeyListener(this);
		setSize(200, 100);
		setVisible(true);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		typeRight = 0;

		if (e.getKeyCode() == KeyEvent.VK_A) {
			System.out.println("c typed");
			noteString += "C ";
			label.setText(noteString);
			Midi_soundmaker.notes.add(60);
			typeRight = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("d typed");
			noteString += "D ";
			label.setText(noteString);
			Midi_soundmaker.notes.add(62);
			typeRight = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println("e typed");
			noteString += "E ";
			label.setText(noteString);
			Midi_soundmaker.notes.add(64);
			typeRight = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			System.out.println("f typed");
			noteString += "F ";
			label.setText(noteString);
			Midi_soundmaker.notes.add(65);
			typeRight = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_G) {
			System.out.println("g typed");
			noteString += "G ";
			label.setText(noteString);
			Midi_soundmaker.notes.add(67);
			typeRight = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_H) {
			System.out.println("a typed");
			noteString += "A ";
			label.setText(noteString);
			Midi_soundmaker.notes.add(69);
			typeRight = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			System.out.println("b typed");
			noteString += "B ";
			label.setText(noteString);
			Midi_soundmaker.notes.add(71);
			typeRight = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Midi_soundmaker player = new Midi_soundmaker();
			player.setUpPlayer(counter);
			Midi_soundmaker.notes.clear();
			counter = 0;
			UI.LabelLeft.setText("amount: 0");

		}

		if (typeRight == 1) {
			counter++;
			numOfNotes = Integer.toString(counter);
			UI.LabelLeft.setText("amount: " + numOfNotes);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}