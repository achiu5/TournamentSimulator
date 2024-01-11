import java.util.ArrayList;

public class Bracket {
	final int NUM_OF_PLAYERS = 8;
	private int playersLeft = NUM_OF_PLAYERS;
	ArrayList<Player> playerArray;
	
	Bracket() {
		initializeBracket();
	}
	
	public void printBracket() {
		
			for (int i = 0; i < playersLeft - 1; i+= 2) {
				System.out.println("_______________");
				System.out.println(String.format(formatBracket(playerArray.get(i).getName(), true), playerArray.get(i).getName()));
				System.out.println("               |");
				System.out.println("               |");
				System.out.println("_______________|");
				System.out.println(String.format(formatBracket(playerArray.get(i+1).getName(), false), playerArray.get(i+1).getName()));
				
				
			}

	}
	
	public void initializeBracket() {
		playerArray = new ArrayList<Player>();
		playerArray.add(new Player("Sydney Wolfe", 0.5));
		playerArray.add(new Player("Jordan Kuo", 0.5));
		playerArray.add(new Player("Kei Kato", 0.5));
		playerArray.add(new Player("Jessica Chiu", 0.5));
		playerArray.add(new Player("Ann Kato", 0.5));
		playerArray.add(new Player("Keelie Beres", 0.5));
		playerArray.add(new Player("Yaz K.", 0.5));
		playerArray.add(new Player("Richard Chiu", 0.5));
	}
	
	public void randomBracket() {
		int i = 0;
		
		for (int j = 0; j < playerArray.size(); j++) {
			i = (int) (Math.random()*playerArray.size());
			Player temp = playerArray.get(j);
			playerArray.set(j, playerArray.get(i));
			playerArray.set(i, temp);
		}
	}
	
	public String formatBracket(String name, boolean hasDivider) {
		String s = "%s";
		for (int i = 0; i < 15 - name.length(); i++) {
			s += " ";
		}
		if (hasDivider) {
			s += "|";
		}
		return s;
	}
	
	public void startBracket() {
		while (playersLeft != 1) {
			for (int i = 0; i < playerArray.size() - 1; i++) {
				Game game = new Game(playerArray.get(i), playerArray.get(i+1));
				Player winner = game.simulate();
				playerArray.set(i, winner);
				playerArray.remove(i + 1);
			}
			playersLeft /= 2;
			printBracket();
		}
		System.out.println();
		System.out.println(String.format("%s has won!!! WOOT WOOT", playerArray.get(0).getName()));
	}
	
	
}
