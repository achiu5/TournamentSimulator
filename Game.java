public class Game {
	
	Player player1;
	Player player2;
	
	
	public Game(Player play1, Player play2) {
		player1 = play1;
		player2 = play2;
		
		System.out.println(String.format("Match beginning between %s and %s", player1.getName(), player2.getName())); 			
	}
	
	public Player simulate() {
		int score1, score2;
		score1 = score2 = 0;
		
		while (score1 != 7 && score2 != 7) {
			double coinFlip = Math.random();
			
			if (coinFlip < 0.5) {
				score1++;
				System.out.println(String.format("%s has scored", player1.getName()));
			}
			else {
				score2++;
				System.out.println(String.format("%s has scored", player2.getName()));
			}
			
//			try {
//				Thread.sleep(1000);
//			}
//			catch (InterruptedException e) {
//				Thread.currentThread().interrupt();
//			}
			System.out.println(String.format("Score is %d - %d", score1, score2));
		}
		
		if (score1 == 7) {
			System.out.println(String.format("%s has won!", player1.getName()));
			return player1;
		}
		else {
			System.out.println(String.format("%s has won!", player2.getName()));
			return player2;
		}
	}
	
}
