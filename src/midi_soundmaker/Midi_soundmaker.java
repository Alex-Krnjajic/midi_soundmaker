package midi_soundmaker;

import javax.sound.midi.*;
import java.util.*;

public class Midi_soundmaker {

	static int numOfNotes = 0;
	static ArrayList<Integer> notes = new ArrayList<Integer>();
	int counter = 0;
	int timing = 0;

	public static void main(String[] args) {

		new UI("Key Listener Tester");

	}

	public void setUpPlayer(int numOfNotes) {

		try {

			// A static method of MidiSystem that returns
			// a sequencer instance.
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			// Creating a sequence.
			Sequence sequence = new Sequence(Sequence.PPQ, 4);

			// PPQ(Pulse per ticks) is used to specify timing
			// type and 4 is the timing resolution.

			// Creating a track on our sequence upon which
			// MIDI events would be placed
			Track track = sequence.createTrack();
			counter = 0;
			timing = 1;
			System.out.print(notes);
			System.out.println(numOfNotes);
			// Adding some events to the track
			for (int i = 0; i < numOfNotes; i++) {

				// Add Note On event
				track.add(makeEvent(144, 1, notes.get(counter), 100, timing));
				System.out.print("note on ");

				// Add Note Off event
				track.add(makeEvent(128, 1, notes.get(counter), 100, timing + 2));
				System.out.print("note off");

				counter++;
				timing += 3;
			}

			// Setting our sequence so that the sequencer can
			// run it on synthesizer
			sequencer.setSequence(sequence);

			// Specifies the beat rate in beats per minute.
			sequencer.setTempoInBPM(220);

			// Sequencer starts to play notes
			sequencer.start();

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	public MidiEvent makeEvent(int command, int channel, int note, int velocity, int tick) {

		MidiEvent event = null;

		try {

			ShortMessage a = new ShortMessage();
			a.setMessage(command, channel, note, velocity);

			event = new MidiEvent(a, tick);
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return event;
	}
}
