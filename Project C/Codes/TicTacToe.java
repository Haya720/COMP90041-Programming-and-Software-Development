
/**
 * Project C of COMP90041
 * @author Name: Hongyao Wei, Student ID: 741027
 */

import java.util.*;

public class TicTacToe {

	// ======================== Main method ========================
	public static void main(String[] args) throws Exception {
		// create an instance of object of the TicTacToe class
		TicTacToe gameSystem = new TicTacToe();

		// run the game
		gameSystem.run();
	}

	// ======================== Variables ===========================
	public static Scanner keyboard = new Scanner(System.in); // scanner object
	private String input; // receive user inputs
	private String username, familyName, givenName;
	private String player1name, player2name; // name of 2 players
	private int gameState; // result state of 2 game players
	public static final int DRAW = 0; // draw
	public static final int player1Win = 1; // player 1 win
	public static final int player2Win = 2; // player 2 win

	// ======================== Functions ===========================
	public void run() {
		System.out.println("Welcome to Tic Tac Toe!\n");

		// manage the players in the game system
		PlayerManager PM = new PlayerManager();

		// read file
		PM.readFile();

		// loop to take input commands until "exit"
		do {
			input = keyboard.nextLine(); // take user inputs
			String[] inputs = input.split(" |,"); // split commands words into an array
			String invalidArgument = ">Incorrect number of arguments supplied to command.\n";
			String invalidCommand = ">'" + inputs[0] + "'" + " is not a valid command.\n";

			try {
				// case syntax "addplayer" to add a new player
				if (inputs[0].equals("addplayer")) {
					if (inputs.length != 4) {
						throw new InvalidArgument(invalidArgument);
					} else {
						username = inputs[1];
						familyName = inputs[2];
						givenName = inputs[3];
						PM.addPlayer(username, familyName, givenName);
					}

				}

				// case syntax "addaiplayer" to add a new player
				else if (inputs[0].equals("addaiplayer")) {
					if (inputs.length != 4) {
						throw new InvalidArgument(invalidArgument);
					} else {
						username = inputs[1];
						familyName = inputs[2];
						givenName = inputs[3];
						PM.addAIPlayer(username, familyName, givenName);
					}
				}

				// case syntax "removeplayer" to delete an exist player
				else if (inputs[0].equals("removeplayer")) {
					if (inputs.length == 2) {
						username = inputs[1];
						PM.removePlayer(username);
					} else
						PM.removePlayer();
				}

				// case syntax "editplayer" to change player's family and given name
				else if (inputs[0].equals("editplayer")) {
					if (inputs.length != 4) {
						throw new InvalidArgument(invalidArgument);
					} else {
						username = inputs[1];
						familyName = inputs[2];
						givenName = inputs[3];
						PM.changePlayerName(username, familyName, givenName);
					}
				}

				// case syntax "displayplayer" to display one or all players' information
				else if (inputs[0].equals("displayplayer")) {
					if (inputs.length == 2) {
						username = inputs[1];
						PM.displayplayer(username);
					} else
						PM.displayplayer();
				}

				// case syntax "rankings" to display players ranking information
				else if (inputs[0].equals("rankings")) {
					PM.displayRanking();
				}

				// case syntax "resetstats" to reset one or all players game data
				else if (inputs[0].equals("resetstats")) {
					if (inputs.length == 2) {
						username = inputs[1];
						PM.reset(username);
						;
					} else
						PM.reset();
				}

				// case syntax "playgame" to operate a game between 2 exist players
				else if (inputs[0].equals("playgame")) {
					if (inputs.length != 3) {
						throw new InvalidArgument(invalidArgument);
					} else {
						player1name = inputs[1];
						player2name = inputs[2];

						// check whether either players exist
						Player player1 = PM.searchPlayer(player1name);
						Player player2 = PM.searchPlayer(player2name);

						if (player1 == null || player2 == null)
							System.out.println(">Player does not exist.\n");
						else {
							System.out.print(">");

							// both players exit, start game
							GameManager GM = new GameManager(player1, player2);

							// 0 for draw, 1 for player 1 win, 2 for player 2 win
							gameState = GM.playGame();

							// update game result data
							if (gameState == DRAW) {
								PM.playerDraw(player1name, player2name);
							} else if (gameState == player1Win) {
								PM.playerWin(player1name);
								PM.playerLose(player2name);
							} else if (gameState == player2Win) {
								PM.playerWin(player2name);
								PM.playerLose(player1name);
							}
						}
					}
				}

				// exit
				else if (inputs[0].equals("exit")) {
					// write file
					PM.writeFile();
				}

				// invalid command
				else
					throw new InvalidCommand(invalidCommand);
			} catch (InvalidCommand c) {
				System.out.println(c.getMessage());
			} catch (InvalidArgument a) {
				System.out.println(a.getMessage());
			}

		} while (!input.equals("exit"));

		System.out.println(">");
	}

}