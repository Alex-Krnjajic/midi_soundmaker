package midi_soundmaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class MessageListener implements ActionListener {

    private JTextArea origin;
    
    private String numOfNotes;
    private int counter;

    public MessageListener(JTextArea origin, String numOfNotes) {
        this.origin = origin;
        this.numOfNotes = numOfNotes;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    	
    	
		if(ae.getSource()==UI.addButton)
		{
    	
    	counter++;
    	numOfNotes = Integer.toString(counter);
    	
        this.origin.setText(numOfNotes);
    }
		else if (ae.getSource()==UI.playButton) {
			 Midi_soundmaker player = new Midi_soundmaker(); 
		     player.setUpPlayer(counter);
		     counter = 0;
		     numOfNotes = "0";
		}
	}
}