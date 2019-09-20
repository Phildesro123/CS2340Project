package models;

public class Game {
	private int difficulty; //16 = Easy, 12 = Medium, 8 = Hard
	private Player player;

	public Game(int difficulty, String name) {
		if (difficulty == 16) {
			player = new Player(name, 16, 1000.0);
		} else if (difficulty == 12) {
			player = new Player(name, 12, 500.0);
		} else if (difficulty == 8) {
			player = new Player(name, 8, 100.0);
		} else {
			throw new IllegalArgumentException("Invalid difficulty");
		}
		this.difficulty = difficulty;
	}

	//main method shows the welcome screen?

	/*if(startButton.isPressed()) {
		screen = configScreen; //????
	}

	String tempName = nameBox.output(); //can be blank
	//later on the confirm selection button will update game.player.setName()

	//based on which button is pressed, the Game object is created, which creates the appropriate player
	Game game;
	if(easyButton.isPressed()) {
		game = new Game(16, tempName);
	} 
	if(medButton.isPressed()) {
		game = new Game(12, tempName);
	}
	if(hardButton.isPressed()) {
		game = new Game(8, tempName);
	}



	*/

}