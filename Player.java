public class Player{
	private String name;
	private double winRate;
	
	Player(String nm, double rate) {
		name = nm;
		winRate = rate;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWinRate() {
		return winRate;
	}
}
