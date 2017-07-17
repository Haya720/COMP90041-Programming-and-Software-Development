
/**
 * Project A of COMP90041
 * @author Name: Hongyao Wei, Student ID: 741027
 */

import java.util.*;

public class TicTacToe {

	// ======================== Main method ========================
	public static void main(String[] args) {
		// create an instance of object of the TicTacToe class
		TicTacToe game = new TicTacToe();

		// run the game
		game.run();
	}

	// ======================== Variables ==========================
	public Scanner keyboard = new Scanner(System.in); // scanner object

	private String playerName1, playerName2; // two players'name

	private int moveRow, moveCol; // enter numbers for player's move

	private String gameState; // state of game: O win, X win, draw or continue

	public static final int EMPTY = 0; // mark of empty element
	public static final int OMARK = 1; // mark of player O moves
	public static final int XMARK = 2; // mark of player X moves

	public static final int ROWS = 3; // matrix rows number
	public static final int COLS = 3; // matrix columns number

	public int board[][] = new int[ROWS][COLS]; // game matrix board in 2D

	public static final int FULLELEMENT = ROWS * COLS; // full elements in matrix board

	// ======================== Functions =========================
	/**
	 * Constructors
	 */
	public TicTacToe() {
	}

	/**
	 * set the name of player O
	 * 
	 * @param playerName1
	 */
	public void setPlayerName1(String playerName1) {
		this.playerName1 = playerName1;
	}

	/**
	 * get the name of player O
	 * 
	 * @return playerName1
	 */
	public String getPlayerName1() {
		return playerName1;
	}

	/**
	 * set the name of player X
	 * 
	 * @param playerName2
	 */
	public void setPlayerName2(String playerName2) {
		this.playerName2 = playerName2;
	}

	/**
	 * get the name of player X
	 * 
	 * @return playerName2
	 */
	public String getPlayerName2() {
		return playerName2;
	}

	/**
	 * function run
	 */
	public void run() {
		System.out.println("Welcome to Tic Tac Toe!");// welcome sentences
		System.out.println("\nEnter Player O's name:");
		setPlayerName1(keyboard.nextLine()); // name of player 'O'
		System.out.println("Enter Player X's name:");
		setPlayerName2(keyboard.nextLine()); // name of player 'X'

		// print out the game grid
		printGrid();

		// game loop
		do {
			// Player O moves first
			player1Move();
			// check result
			if (getGameState() == "continue")
				// Player X moves
				player2Move();

		} while (getGameState() == "continue");

		// loop ends, print result
		if (getGameState() == "draw") {
			System.out.println("Game over. It was a draw!"); // draw
		} else
			System.out.println("Game over. " + getGameState() + "!"); // O or X win
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
	 * player 'O' move
	 */
	public void player1Move() {
		System.out.println(getPlayerName1() + "'s move:");
		moveRow = keyboard.nextInt();
		moveCol = keyboard.nextInt();
		board[moveRow][moveCol] = OMARK; // input into matrix
		printGrid(); // print out the game grid
	}

	/**
	 * player 'X' move
	 */
	public void player2Move() {
		System.out.println(getPlayerName2() + "'s move:");
		moveRow = keyboard.nextInt();
		moveCol = keyboard.nextInt();
		board[moveRow][moveCol] = XMARK; // input into matrix
		printGrid(); // print out the game grid
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
				return gameState = getPlayerName1() + " won";
			if (board[row][0] == XMARK && board[row][1] == XMARK && board[row][2] == XMARK)
				return gameState = getPlayerName2() + " won";
		}
		// 3-in-the-column
		for (int col = 0; col < COLS; col++) {
			if (board[0][col] == OMARK && board[1][col] == OMARK && board[2][col] == OMARK)
				return gameState = getPlayerName1() + " won";
			if (board[0][col] == XMARK && board[1][col] == XMARK && board[2][col] == XMARK)
				return gameState = getPlayerName2() + " won";
		}
		// 3-in-the-diagonal
		if (board[0][0] == OMARK && board[1][1] == OMARK && board[2][2] == OMARK)
			return gameState = getPlayerName1() + " won";
		if (board[0][0] == XMARK && board[1][1] == XMARK && board[2][2] == XMARK)
			return gameState = getPlayerName2() + " won";

		// 3-in-the-opposite-diagonal
		if (board[0][2] == OMARK && board[1][1] == OMARK && board[2][0] == OMARK)
			return gameState = getPlayerName1() + " won";
		if (board[0][2] == XMARK && board[1][1] == XMARK && board[2][0] == XMARK)
			return gameState = getPlayerName2() + " won";

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
