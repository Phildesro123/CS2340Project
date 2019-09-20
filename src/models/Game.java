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
	//display startButton
	/*if(startButton.isPressed()) {
		//change to Config screen
	}

	//Config screen
		//display nameBox (text input)
		String tempName = nameBox.output(); //can be blank
		//maybe implement using a "set" button to set it to player.setName()?
			//would need a way to keep name despite changing difficulty
		//later on the confirm selection button will update game.player.setName()

		//based on which button is pressed, the Game object is created, which creates the appropriate player
		Game game;
		Player player = new Player("", 0, 0.0);

		//display difficuly as blank

		//display easyButton
		//display medButton
		//display hardButton
		if(easyButton.isPressed()) {
			game = new Game(16, tempName);
			player = game.getPlayer();
			//update difficulty as Easy
			//update unallocated
			//update pilot
			//update fighter
			//update merchant
			//update engineer
		} 
		if(medButton.isPressed()) {
			game = new Game(12, tempName);
			player = game.getPlayer();
			//update difficulty as Medium
			//update unallocated
			//update pilot
			//update fighter
			//update merchant
			//update engineer
		}
		if(hardButton.isPressed()) {
			game = new Game(8, tempName);
			player = game.getPlayer();
			//update difficulty as Hard
			//update unallocated
			//update pilot
			//update fighter
			//update merchant
			//update engineer
		}

		//display "Unallocated: " + player.getSkillPoints();

		//display "Pilot: " + player.getSkillSet()[0];
		//display pilotUp
		//display pilotDown
		if(pilotUp.isPressed()) {
			if(player.getSkillPoints() > 0) { //no adding if you have no points
				player.addToSkillSet(0);
				//update unallocated to show new skill point amount
				//update pilot to show added point
			}
		}
		if(pilotDown.isPressed()) {
			if (player.getSkillSet()[0] > 0) { //no removing points if at 0
				player.removeFromSkillSet(0);
				//update unallocated to show new skill point amount
				//update pilot to show removed point
			}
		}

		//display "Fighter: " + player.getSkillSet()[1];
		//display fighterUp
		//display fighterDown
		if(fighterUp.isPressed()) {
			if(player.getSkillPoints() > 0) { //no adding if you have no points
				player.addToSkillSet(1);
				//update unallocated to show new skill point amount
				//update fighter to show added point
			}
		}
		if(fighterDown.isPressed()) {
			if (player.getSkillSet()[1] > 0) { //no removing points if at 0
				player.removeFromSkillSet(1);
				//update unallocated to show new skill point amount
				//update fighter to show removed point
			}
		}

		//display "Merchant: " + player.getSkillSet()[2];
		//display merchantUp
		//display merchantDown
		if(merchantUp.isPressed()) {
			if(player.getSkillPoints() > 0) { //no adding if you have no points
				player.addToSkillSet(2);
				//update unallocated to show new skill point amount
				//update merchant to show added point
			}
		}
		if(merchantDown.isPressed()) {
			if (player.getSkillSet()[2] > 0) { //no removing points if at 0
				player.removeFromSkillSet(2);
				//update unallocated to show new skill point amount
				//update merchant to show removed point
			}
		}

		//display "Engineer: " + player.getSkillSet()[3];
		//display engineerUp
		//display engineerDown
		if(engineerUp.isPressed()) {
			if(player.getSkillPoints() > 0) { //no adding if you have no points
				player.addToSkillSet(3);
				//update unallocated to show new skill point amount
				//update engineer to show added point
			}
		}
		if(engineerDown.isPressed()) {
			if (player.getSkillSet()[3] > 0) { //no removing points if at 0
				player.removeFromSkillSet(3);
				//update unallocated to show new skill point amount
				//update engineer to show removed point
			}
		}

		//display confirmButton
		if(confirmButton.isPressed()) {
			if(player.getCredits() == 0.0) { //no difficulty was ever selected to override this
				//display error message "Difficulty must be chosen"
			} else if(tempName = "") {
				//display error message "Name cannot be blank"
			} else {
				player.setName(tempName); //setName doesn't exist?
				game.setPlayer(player);
				//change to Build Display screen
			}
		}

	//Build Display screen
		//display "Name: " + game.getPlayer().getName();
		if (game.getDifficulty() == 16) {
			//display "Difficulty: Easy";
		} 
		if (game.getDifficulty() == 12) {
			//display "Difficulty: Medium";
		}
		if (game.getDifficulty() == 8) {
			//display "Difficulty: Hard";
		}
		//display "Pilot: " + game.getPlayer().getSkillSet()[0];
		//display "Fighter: " + game.getPlayer().getSkillSet()[1];
		//display "Merchant: " + game.getPlayer().getSkillSet()[2];
		//display "Engineer: " + game.getPlayer().getSkillSet()[3];

		//display "Credits: " + game.getPlayer().getCredits();

	*/

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getDifficulty() {
		return difficulty;
	}

}