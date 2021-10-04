public class Bowl extends BowlBase {

	Bowl(Player owner) {
		super(owner);
		numberOfStones = 4;
	}

	Bowl(Player owner, int numberOfStones) {
		super(owner, numberOfStones);
	}

	public Player distribute(Player player, int bowlNumber) {

		if (owner == player && --bowlNumber == 0) {
			int distributeStones = numberOfStones;
			numberOfStones = 0;
			return getNext().play(player, distributeStones);
		}
		return ((Bowl)getNext()).distribute(player, bowlNumber);
	}
}
