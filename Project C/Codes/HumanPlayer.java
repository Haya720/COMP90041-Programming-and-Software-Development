/**
 * Project C of COMP90041
 * 
 * @author Name: Hongyao Wei, Student ID: 741027
 */

public class HumanPlayer extends Player {
	// ======================== Variables ===========================
	// username, family name and given name of one player
	private String username, familyName, givenName;
	// played, won and draw game numbers of one player
	private int playedNO, wonNO, drawNO;

	// ======================== Functions ==========================
	// constructor 1
	public HumanPlayer(String user, String family, String given, int games, int drawn, int won) {
		super(user, family, given, games, drawn, won);
		this.username = user;
		this.familyName = family;
		this.givenName = given;
		this.playedNO = games;
		this.drawNO = drawn;
		this.wonNO = won;
	}
	// constructor 2
	public HumanPlayer(String username, String familyName, String givenName) {
		super(username, familyName, givenName);
		this.username = username;
		this.familyName = familyName;
		this.givenName = givenName;
	}

	@Override
	// makeMove method for human player
	public Move makeMove(int[][] gameBoard) {
		// take input data
		int moveRow = TicTacToe.keyboard.nextInt();
		int moveCol = TicTacToe.keyboard.nextInt();
		Move humanMove = null;
		TicTacToe.keyboard.nextLine();
		// check valid move
		if ((moveRow < 0 || moveRow > 2) || (moveCol < 0 || moveCol > 2)) {
			System.out.println("Invalid move. You must place at a cell within {0,1,2} {0,1,2}.");
			humanMove = makeMove(gameBoard);
		} else if (gameBoard[moveRow][moveCol] != GameManager.EMPTY) {
			System.out.println("Invalid move. The cell has been occupied.");
			humanMove = makeMove(gameBoard);
		} else {
			humanMove = new Move(moveRow, moveCol);
			return humanMove;
		}
		return humanMove;
	}

}
