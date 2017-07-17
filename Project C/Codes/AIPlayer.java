/**
 * Project C of COMP90041
 * 
 * @author Name: Hongyao Wei, Student ID: 741027
 */

public class AIPlayer extends Player {
	// constructor 1
	public AIPlayer(String username, String familyName, String givenName) {
		super(username, familyName, givenName);
		
	}
	// constructor 2
	public AIPlayer(String user, String family, String given, int games, int drawn, int won) {
		super(user, family, given, games, drawn, won);
		
	}

	@Override
	// dummy makeMove method for AI player
	public Move makeMove(int[][] gameBoard) {
		Move AIMove = null;
		for (int row = 0; row < GameManager.ROWS; row++) {
			for (int col = 0; col < GameManager.COLS; col++) {
				if (gameBoard[row][col] == GameManager.EMPTY) {
					AIMove = new Move(row, col);
					//return AIMove;
				}
			}
		}
		return AIMove;
	}

}
