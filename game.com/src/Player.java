public class Player {
	private final String name;
	private Player otherPlayer;
	private Player currentPlayer;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Player getOtherPlayer() {
		return this.otherPlayer;
	}

	public void setCurrentPlayer(Player player) {
		currentPlayer = player;
		if (otherPlayer.getCurrentPlayer() != player) {
			otherPlayer.setCurrentPlayer(player);
		}
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setOtherPlayer(Player player) {
		otherPlayer = player;
	}
}
