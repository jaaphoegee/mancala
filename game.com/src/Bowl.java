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

	public int steal(Player player, int steps) {
		if(this.owner.equals(player)) {
			return next.steal(player, steps++);
		}
		if (steps - 1 == 0) {
			int stolenStones = numberOfStones;
			numberOfStones = 0;
			return stolenStones;
		}
		return next.steal(player, steps--);
	}
}
