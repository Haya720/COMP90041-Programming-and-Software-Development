import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TEST {
	private static ArrayList<Player> players = new ArrayList<Player>(99); // ArrayList
																			// of
																			// object
																			// Player
	private ArrayList<Player> players2 = new ArrayList<Player>(99);

	public static void main(String[] args) {
		readFile2();
		writeFile2();
		readFile2();

		// Player playerTest = new HumanPlayer("user", "family", "given", 100,
		// 50, 50);
		// System.out.println(playerTest.toStringUserName());
		//
		// playerTest.toStringRank();

	}

	// read file
	public static void readFile() {
		try {
			// read player data from a file
			FileReader fs = new FileReader("...\\players.dat");
			BufferedReader br = new BufferedReader(fs);
			String record = new String();

			// addPlayer
			while ((record = br.readLine()) != null) {
				// players2 = record;
				System.out.println(record);
				String[] inputs = record.split(" ");
				System.out.println();

			}
		} catch (Exception e) {
			System.out.print(e.toString());
		}

		// System.out.println("Fail");
	}

	// write file
	public static void writeFile() {
		try {
			FileWriter fw = new FileWriter("...\\players.dat", false);
			PrintWriter out = new PrintWriter(fw);

			players.add(new HumanPlayer("user", "family", "given", 100, 50, 50));
			players.add(new AIPlayer("userAI", "family", "given", 100, 50, 50));

			out.println(players.get(0).getClass());
			out.println(players.get(1).getClass());
			// out.println(players.get(0));
			// out.println(players.get(1));

			out.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Uh oh, got an IOException error!");
			e.printStackTrace();
		}
	}

	// read file
	public static void readFile2() {
		try {
			FileInputStream fis = new FileInputStream("tt.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			ArrayList<Player> players = (ArrayList<Player>) ois.readObject();

			System.out.println(players.get(0).toString());
			System.out.println(players.get(1).toString());
			System.out.println(players.get(0).getUsername());
			System.out.println(players.get(1).getUsername());
			System.out.println(players.get(0).getClass());
			System.out.println(players.get(1).getClass());

			ois.close();

			// // read player data from a file
			// FileReader fs = new FileReader("...\\players.dat");
			// BufferedReader br = new BufferedReader(fs);
			// String record = new String();
			//
			// // addPlayer
			// while ((record = br.readLine()) != null) {
			// //players2 = record;
			// System.out.println(record);
			// String[] inputs = record.split(" ");
			// System.out.println();

			// }
		} catch (Exception e) {
			System.out.print(e.toString());
		}

		// System.out.println("Fail");
	}

	// write file
	public static void writeFile2() {
		try {

			players.add(new HumanPlayer("user", "family", "given", 100, 50, 50));
			players.add(new AIPlayer("userAI", "family", "given", 100, 50, 50));

			FileOutputStream fos = new FileOutputStream("tt.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(players);
			oos.close();

			// FileWriter fw = new FileWriter("...\\players.dat", false);
			// PrintWriter out = new PrintWriter(fw);
			//
			//
			//
			// out.println(players.get(0).getClass());
			// out.println(players.get(1).getClass());
			// //out.println(players.get(0));
			// //out.println(players.get(1));
			//
			// out.close();
			// fw.close();
		} catch (IOException e) {
			System.out.println("Uh oh, got an IOException error!");
			e.printStackTrace();
		}
	}

}
