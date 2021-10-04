public class Kalaha extends BowlBase {

	Kalaha(Player owner) {
		super(owner);
		numberOfStones = 0;
	}

	Kalaha(Player owner, int numberOfStones) {
		super(owner, numberOfStones);
	}

	public int steal(Player player, int steps) {
		return next.steal(player, steps);
	}
}
