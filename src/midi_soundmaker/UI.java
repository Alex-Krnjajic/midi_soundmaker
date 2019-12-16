package midi_soundmaker;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class UI implements Runnable {
	
	static String numOfNotes;

	private JFrame frame;
	static JButton addButton = new JButton("+");
	static JButton playButton = new JButton("play");

	public UI() {

	}

	@Override
	public void run() {
		frame = new JFrame("Title");
		frame.setPreferredSize(new Dimension(200, 100));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
	}

	private void createComponents(Container container) {

		GridLayout layout = new GridLayout(1, 3);
		container.setLayout(layout);

		JTextArea textAreaLeft = new JTextArea(numOfNotes);
		
		
		MessageListener copier = new MessageListener(textAreaLeft, numOfNotes);
		addButton.addActionListener(copier);
		playButton.addActionListener(copier);

		container.add(textAreaLeft);
		container.add(addButton);
		container.add(playButton);
		

	}

	public JFrame getFrame() {
		return frame;
	}

}