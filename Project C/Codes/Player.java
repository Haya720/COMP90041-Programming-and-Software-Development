import java.io.Serializable;

/**
 * Project C of COMP90041
 * 
 * @author Name: Hongyao Wei, Student ID: 741027
 */
public abstract class Player implements Serializable {
	// ======================== Variables ===========================
	// username, family name and given name of one player
	private String username, familyName, givenName;
	// played, won and draw game numbers of one player
	private int playedNO, wonNO, drawNO;

	// ======================== Functions ===========================
	// constructor 1
	public Player(String username, String familyName, String givenName) {
		this.username = username;
		this.familyName = familyName;
		this.givenName = givenName;
	}
	// constructor 2
	public Player(String user, String family, String given, int games, int drawn, int won) {
		this.username = user;
		this.familyName = family;
		this.givenName = given;
		this.playedNO = games;
		this.drawNO = drawn;
		this.wonNO = won;
	}

	/**
	 * abstract method
	 * 
	 * @param gameBoard
	 */
	public abstract Move makeMove(int[][] gameBoard);

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @param givenName
	 *            the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * @return the playedNO
	 */
	public int getPlayedNO() {
		return playedNO;
	}

	/**
	 * @param playedNO
	 *            the playedNO to set
	 */
	public void setPlayedNO(int playedNO) {
		this.playedNO = playedNO;
	}

	/**
	 * @return the wonNO
	 */
	public int getWonNO() {
		return wonNO;
	}

	/**
	 * @param wonNO
	 *            the wonNO to set
	 */
	public void setWonNO(int wonNO) {
		this.wonNO = wonNO;
	}

	/**
	 * @return the drawNO
	 */
	public int getDrawNO() {
		return drawNO;
	}

	/**
	 * @param drawNO
	 *            the drawNO to set
	 */
	public void setDrawNO(int drawNO) {
		this.drawNO = drawNO;
	}

	// get the win ratio of the player
	public double getWinRatio() {
		if (getWonNO() == 0)
			return 0;
		else {
			double win = getWonNO();
			double play = getPlayedNO();
			return (win / play) * 100;
		}
	}

	// get the draw ratio of the player
	public double getDrawRatio() {
		if (getDrawNO() == 0)
			return 0;
		else {
			double draw = getDrawNO();
			double play = getPlayedNO();
			return (draw / play) * 100;
		}
	}

	// add the draw number of player if game is draw
	public void gameDraw() {
		this.drawNO += 1;
	}

	// add the win number of player if player win
	public void gameWon() {
		this.wonNO += 1;
	}

	// add the played number of player after one game over
	public void gamePlayed() {
		this.playedNO += 1;
	}

	// output the display information of player
	public String toStringUserName() {
		return username + "," + familyName + "," + givenName + "," 
				+ playedNO + " games," + wonNO + " wins," + drawNO
				+ " draws";
	}

	// output the raking information of player
	public void toStringRank() {
		System.out.print(" ");
		System.out.printf("%3.0f", getWinRatio());
		System.out.print("% | ");
		System.out.printf("%3.0f", getDrawRatio());
		System.out.print("% | ");
		System.out.printf("%2d", playedNO);
		System.out.println("   | " + username);
	}

}
