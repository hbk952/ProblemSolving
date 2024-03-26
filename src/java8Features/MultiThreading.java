package java8Features;

import java.util.Random;

class Player{ //class with methods having interruption of thread sleep()
	void playGame(String game) throws InterruptedException{
		System.out.println(game+" Game starts");
		Thread.sleep(5000); //game played for 5 secs
		System.out.println(game+" Game Ends");
	}
	void playMusic(String music) throws InterruptedException {
		System.out.println(music+" Music Starts");
		Thread.sleep(5000);
		System.out.println(music+" Music Ends");
	}
}

public class MultiThreading {
	public static void main(String[] args) {
		String games[]= {"cricket", "football", "Hockey"};
		String musics[] = {"indian", "classical", "Pop"};
		
		Random random= new Random();//to choose random games and musics from array.
		Player randomPlayer = new Player();
		Runnable gameRunner=()->{ //runnable interface to run thread
			try {
				randomPlayer.playGame(games[random.nextInt(games.length)]);
			}
			catch(InterruptedException e) {
				System.out.println("Interrupted Exception: "+e);
			}
		};
		Player randomMusic = new Player();
		Runnable musicRunner= () ->{
			try {
				randomMusic.playMusic(musics[random.nextInt(musics.length)]);
			}
			catch(InterruptedException e) {
				System.out.println("Interrupted Exception: "+e);
			}
		};
		//instantiating two threads
		Thread game = new Thread(gameRunner);
		Thread music = new Thread(musicRunner);
		game.start(); //starting the thread
		music.start();
	}
}
