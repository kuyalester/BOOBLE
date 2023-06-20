import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.AudioClip;

/**
 * A class that handles the music of the game.
 * @see Main
 */
public class Music {

	boolean isMusicOn = true;
	
	AudioClip backgroundMusic;
	AudioClip effectsButtonClick;
	AudioClip effectsCorrect;
	AudioClip effectsWrong;
	AudioClip effectsWin;
	AudioClip effectsLose;
	
	/**
	 * This constructor initializes the audio clips.
	 */
	public Music() {
		
		ArrayList<String> songs = new ArrayList<String>();
		songs.add("music/background.mp3");					//0
		songs.add("music/buttonClick.wav");					//1
		songs.add("music/correct.wav");						//2
		songs.add("music/wrong.wav");						//3
		songs.add("music/WinSoundEffect.mp3");				//4
		songs.add("music/LostSoundEffect.mp3");				//5
		
		backgroundMusic = new AudioClip(new File(songs.get(0)).toURI().toString());
		backgroundMusic.setVolume(.1);
		backgroundMusic.setCycleCount(20);
	
		effectsButtonClick = new AudioClip(new File(songs.get(1)).toURI().toString());
		effectsCorrect = new AudioClip(new File(songs.get(2)).toURI().toString());
		effectsWrong = new AudioClip(new File(songs.get(3)).toURI().toString());
		effectsWin = new AudioClip(new File(songs.get(4)).toURI().toString());	
		effectsLose = new AudioClip(new File(songs.get(5)).toURI().toString());
		
	}
	
	/**
	 * Plays the background music.
	 */
	public void playBackgroundMusic() {
		backgroundMusic.play();
	}
	
	/**
	 * Stop playing the background music.
	 */
	public void stopBackgroundMusic() {
		backgroundMusic.stop();
	}
	
	/**
	 * plays the button click sound effect.
	 */
	public void playButtonClick() {
		if(isMusicOn) {
			effectsButtonClick.play();
		}
	}
	
	/**
	 * plays the correct answer sound effect.
	 */
	public void playCorrect() {
		if(isMusicOn) {
			effectsCorrect.play();
		}
	}
	
	/**
	 * plays the wrong answer sound effect.
	 */
	public void playWrong() {
		if(isMusicOn) {
			effectsWrong.play();
		}
	}
	
	/**
	 * plays the winning the game sound effect.
	 */
	public void playWin() {
		if(isMusicOn) {
			effectsWin.play();
		}
	}
	
	/**
	 * stops playing the winning the game sound effect.
	 */
	public void stopWin() {
		effectsWin.stop();
	}
	
	/**
	 * plays the losing the game sound effect.
	 */
	public void playLose() {
		if(isMusicOn) {
			effectsLose.play();
		}
	}
	
	/**
	 * stops playing the losing the game sound effect.
	 */
	public void stopLose() {
		effectsLose.stop();
	}
	
	/**
	 * toggles the music on and off
	 */
	public void toggleMusic() {
		if(isMusicOn) {
			backgroundMusic.stop();
			isMusicOn = false;
		}else {
			backgroundMusic.play();
			isMusicOn = true;
		}
	}

}
