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

	public Player play(Player player, int distributeStones) {
		if(!isOwner(player)) {
			return next.play(player, distributeStones);
		}
		numberOfStones++;
		if(distributeStones > 1) {
			return next.play(player, --distributeStones);
		}
		return player;
	}

	public void add(int stones) {
		numberOfStones += stones;
	}
}
