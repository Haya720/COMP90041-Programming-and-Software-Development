/**
 * Project C of COMP90041
 * 
 * @author Name: Hongyao Wei, Student ID: 741027
 */

public class GameManager {
	// ======================== Variables ===========================
	private String gameState; // state of game: O win, X win, draw or continue

	public static final int EMPTY = 0; // mark of empty element
	public static final int OMARK = 1; // mark of player O moves
	public static final int XMARK = 2; // mark of player X moves

	public static final int ROWS = 3; // matrix rows number
	public static final int COLS = 3; // matrix columns number

	public int board[][] = new int[ROWS][COLS]; // game matrix board in 2D

	public static final int FULLELEMENT = ROWS * COLS; // full elements in
														// matrix board
	private Player player1, player2;

	// ======================== Functions ===========================
	// constructor 1
	public GameManager() {
	}

	// constructor 2
	public GameManager(Player Player1, Player Player2) {
		this.player1 = Player1;
		this.player2 = Player2;

	}

	public int playGame() {
		// print out the game grid
		printGrid();
		// game loop
		do {
			// Player 1 moves first
			player1Move(player1);
			// check result
			if (getGameState() == "continue")
				// Player 2 moves
				player2Move(player2);

		} while (getGameState() == "continue");

		// loop ends, print result
		if (getGameState() == "draw") {
			System.out.println("Game over. It was a draw!" + "\n");// draw
		} else
			System.out.println("Game over. " + getGameState() + "!\n");

		// return the result state
		if (getGameState().equals(player1.getGivenName() + " won"))
			return 1;
		if (getGameState().equals(player2.getGivenName() + " won"))
			return 2;

		return 0;
	}

	/**
	 * player 1 move
	 */
	public void player1Move(Player player) {
		System.out.println(player.getGivenName() + "'s move:");
		Move playerMove = player.makeMove(board);
		board[playerMove.getMoveRow()][playerMove.getMoveCol()] = OMARK;
		printGrid(); // print out the game grid

	}

	/**
	 * player 2 move
	 */
	public void player2Move(Player player) {
		System.out.println(player.getGivenName() + "'s move:");
		Move playerMove = player.makeMove(board);
//		System.out.println(playerMove.getMoveRow() + " " + playerMove.getMoveCol());
		board[playerMove.getMoveRow()][playerMove.getMoveCol()] = XMARK;
		printGrid(); // print out the game grid
	}

	/**
	 * print out the game grid
	 */
	public void printGrid() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				// print content in each of the cells
				if (board[row][col] == EMPTY)
					System.out.print(" ");
				else if (board[row][col] == OMARK)
					System.out.print("O");
				else if (board[row][col] == XMARK)
					System.out.print("X");

				if (col != COLS - 1)
					System.out.print("|"); // horizontal separator
			}
			System.out.println(); // move to next line

			if (row != ROWS - 1)
				System.out.println("-----"); // vertical separator
		}
	}

	/**
	 * check the state of game
	 * 
	 * @return game state
	 */
	public String getGameState() {
		gameState = "continue";
		int count = 0;

		// 3-in-the-row
		for (int row = 0; row < ROWS; row++) {
			if (board[row][0] == OMARK && board[row][1] == OMARK && board[row][2] == OMARK)
				return gameState = player1.getGivenName() + " won";
			if (board[row][0] == XMARK && board[row][1] == XMARK && board[row][2] == XMARK)
				return gameState = player2.getGivenName() + " won";
		}
		// 3-in-the-column
		for (int col = 0; col < COLS; col++) {
			if (board[0][col] == OMARK && board[1][col] == OMARK && board[2][col] == OMARK)
				return gameState = player1.getGivenName() + " won";
			if (board[0][col] == XMARK && board[1][col] == XMARK && board[2][col] == XMARK)
				return gameState = player2.getGivenName() + " won";
		}
		// 3-in-the-diagonal
		if (board[0][0] == OMARK && board[1][1] == OMARK && board[2][2] == OMARK)
			return gameState = player1.getGivenName() + " won";
		if (board[0][0] == XMARK && board[1][1] == XMARK && board[2][2] == XMARK)
			return gameState = player2.getGivenName() + " won";

		// 3-in-the-opposite-diagonal
		if (board[0][2] == OMARK && board[1][1] == OMARK && board[2][0] == OMARK)
			return gameState = player1.getGivenName() + " won";
		if (board[0][2] == XMARK && board[1][1] == XMARK && board[2][0] == XMARK)
			return gameState = player2.getGivenName() + " won";

		// draw
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (board[row][col] != EMPTY)
					count++;
			}
		}
		if (count == FULLELEMENT) // all elements are occupied
			return gameState = "draw";

		return gameState;
	}

}
