package algo;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Son {

	private static Clip clip;

	public Son() {

	}

	public static void group1() {
		try {
			// Open an audio input stream.
			java.net.URL url = Son.class.getClassLoader().getResource("tasfikazra9.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			if (clip != null)
				clip.stop();

			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void phone() {
		try {
			// Open an audio input stream.
			java.net.URL url = Son.class.getClassLoader().getResource("phone.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			if (clip != null)
				clip.stop();

			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void group2() {
		try {
			// Open an audio input stream.
			java.net.URL url = Son.class.getClassLoader().getResource("tasfik.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			if (clip != null)
				clip.stop();

			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void group3() {
		try {
			// Open an audio input stream.
			java.net.URL url = Son.class.getClassLoader().getResource("rigoleBanqueji.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			if (clip != null)
				clip.stop();

			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public static void open() {
		try {
			// Open an audio input stream.
			java.net.URL url = Son.class.getClassLoader().getResource("open.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			if (clip != null)
				clip.stop();

			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public static void group4() {
		try {
			// Open an audio input stream.
			java.net.URL url = Son.class.getClassLoader().getResource("miliard.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			if (clip != null)
				clip.stop();

			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
