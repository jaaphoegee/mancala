public class Player {
	private String name;
	private Player otherPlayer;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Player getOtherPlayer() {
		return this.otherPlayer;
	}
}
