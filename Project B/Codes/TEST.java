import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TEST {

	public static void main(String[] args) {
		
//		writeFile();
//		readFile();
		ArrayList<Player> players = new ArrayList<Player>(99);
		players.add(new Player("a", "a", "a"));
		players.add(new Player("a", "a", "a"));
		players.add(new Player("a", "a", "a"));
		
		System.out.println(players.size());
		
		

	}
	
	

//	// read file
//	public static void readFile() {
//		try {
//			FileReader fs = new FileReader("...\\players.dat");
//			BufferedReader br = new BufferedReader(fs);
//			String record = new String();
//			while ((record = br.readLine()) != null) {
//				String[] inputs = record.split(" ");
//				System.out.print(inputs[0]+ " || " + inputs[1] + " || " + inputs[2] + "\n");
//				//System.out.println(record);
//			}
//		} catch (Exception e) {
//			System.out.print(e.toString());
//		}
//	}
//
//	// write file
//	public static void writeFile() {
//		try {
//			FileWriter fw = new FileWriter("...\\players.dat", false);
//			PrintWriter out = new PrintWriter(fw);
//			//out.println(" ");
//			out.println("a b c d e f g");
//			out.println("a b c d e f g");
//			out.println("a b c d e f g");
//		out.println("a b c d e f g");
//			out.close();
//			fw.close();
//		} catch (IOException e) {
//			System.out.println("Uh oh, got an IOException error!");
//			e.printStackTrace();
//		}
//	}

}







