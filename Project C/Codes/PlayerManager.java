import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Project C of COMP90041
 * 
 * @author Name: Hongyao Wei, Student ID: 741027
 */

public class PlayerManager {
	// ======================== Variables ===========================
	private ArrayList<Player> players; // ArrayList of object Player

	// ======================== Functions ===========================
	// constructor
	public PlayerManager() {
		this.players = new ArrayList<Player>(99);
	}

	// read file
	public void readFile() {
		try {
			// check whether file exists or not
			File file = new File("players.dat");
			if (!file.exists())
				return;
			
			// read file content
			FileInputStream fis = new FileInputStream("players.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// store into ArrayList
			ArrayList<Player> player = (ArrayList<Player>) ois.readObject();
			this.players = player;

			ois.close();

		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}

	// write file
	public void writeFile() {
		try {
			FileOutputStream fos = new FileOutputStream("players.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(players);
			oos.close();
		} catch (IOException e) {
			System.out.println("IOException error");
			e.printStackTrace();
		}
	}

	// Add a new player with username, family name and given name
	public void addPlayer(String userName, String familyName, String givenName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName)) {
				System.out.println(">The username has been used already.\n");
				return;
			}
		}
		players.add(new HumanPlayer(userName, familyName, givenName));
		System.out.println(">");
	}

	// Add a AI player with username, family name and given name
	public void addAIPlayer(String userName, String familyName, String givenName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName)) {
				System.out.println(">The username has been used already.\n");
				return;
			}
		}
		players.add(new AIPlayer(userName, familyName, givenName));
		System.out.println(">");
	}

	// Remove one exist player according to the username
	public void removePlayer(String userName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName)) {
				players.remove(i);
				System.out.println(">");
				return;
			}
		}
		System.out.println(">The player does not exist.\n");
	}

	// Remove all players
	public void removePlayer() {
		System.out.println(">Are you sure you want to remove all players? (y/n)");
		if (TicTacToe.keyboard.nextLine().equals("y")) {
			players.clear();
		}
		System.out.println("");
	}

	// Modify the family and given name of a exist player according to username
	public void changePlayerName(String userName, String newfamilyName, String newgivenName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName)) {
				players.get(i).setFamilyName(newfamilyName);
				players.get(i).setGivenName(newgivenName);
				System.out.println(">");
				return;
			}
		}
		System.out.println(">The player does not exist.\n");
	}

	// Reset the statistics of one player
	public void reset(String userName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName)) {
				players.get(i).setPlayedNO(0);
				players.get(i).setWonNO(0);
				players.get(i).setDrawNO(0);
				return;
			}
		}
		System.out.println(">The player does not exist.\n");
	}

	// Reset the statistics of all players
	public void reset() {
		System.out.println(">Are you sure you want to reset all player statistics? (y/n)");
		if (TicTacToe.keyboard.nextLine().equals("y")) {
			for (int i = 0; i < players.size(); i++) {
				reset(players.get(i).getUsername());
			}
		}
		System.out.println("");
	}

	// Display the information of one player
	public void displayplayer(String userName) {
		System.out.print(">");
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName)) {
				System.out.println(players.get(i).toStringUserName() + "\n");
				return;
			}
		}
		System.out.println("The player does not exist.\n");
	}

	// Display the information of all players
	public void displayplayer() {
		Collections.sort(players, comparator);
		System.out.print(">");
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).toStringUserName());
		}
		System.out.println("");
	}

	// Rank 10 top players based on winning history
	public void displayRanking() {
		Collections.sort(players, comparatorRank);

		System.out.println("> WIN  | DRAW | GAME | USERNAME");

		if (players.size() <= 10) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).toStringRank();
			}
		} else {
			for (int i = 0; i < 10; i++) {
				players.get(i).toStringRank();
			}
		}
		System.out.println("");
	}

	// check whether the userName exists
	public Player searchPlayer(String userName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName))
				return players.get(i);
		}
		return null;
	}

	// draw, update both players' data
	public void playerDraw(String userName1, String userName2) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName1) 
					|| players.get(i).getUsername().equals(userName2)) {
				players.get(i).gameDraw();
				players.get(i).gamePlayed();
			}
		}

	}

	// update the winner's data
	public void playerWin(String userName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName)) {
				players.get(i).gameWon();
				players.get(i).gamePlayed();
			}
		}
	}

	// update the loser's data
	public void playerLose(String userName) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUsername().equals(userName)) {
				players.get(i).gamePlayed();
			}
		}
	}

	// return givenName
	public String getPlayerGiveName(String userName) {
		for (int i = 0; i < players.size(); i++)
			if (players.get(i).getUsername().equals(userName)) {
				return players.get(i).getGivenName();
			}
		return null;
	}

	// order by win ratio, draw ration, then userName alphabetically
	Comparator<Player> comparatorRank = new Comparator<Player>() {
		public int compare(Player p1, Player p2) {
			// rank in winning ratio
			if (p1.getWinRatio() != p2.getWinRatio()) {
				return (int) (p2.getWinRatio() - p1.getWinRatio());
			} else {
				// rank in drawing ratio
				if (p1.getDrawRatio() != p2.getDrawRatio()) {
					return (int) (p2.getDrawRatio() - p1.getDrawRatio());
				} else {
					// rank in username
					return p1.getUsername().compareTo(p2.getUsername());
				}
			}
		}
	};

	// order by userName alphabetically
	Comparator<Player> comparator = new Comparator<Player>() {
		public int compare(Player p1, Player p2) {
			// rank in username
			if (!p1.getUsername().equals(p2.getUsername())) {
				return p1.getUsername().compareTo(p2.getUsername());
			} else {
				// rank in played times
				return p2.getPlayedNO() - p1.getPlayedNO();
			}
		}
	};

}
