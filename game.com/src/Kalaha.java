public class Kalaha extends BowlBase {

	Kalaha(Player owner) {
		this(owner, 0);
	}

	Kalaha(Player owner, int numberOfStones) {
		super(owner, numberOfStones);
	}

	@Override
	public int steal(Player player, int steps) {
		return next.steal(player, steps);
	}

	@Override
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

	@Override
	protected BowlBase getKahala() {
		return this;
	}

	public void add(int stones) {
		numberOfStones += stones;
	}

	@Override
	public BowlBase getWinner() {
		Kalaha otherKalaha = (Kalaha)next.getKahala();
		if (numberOfStones > otherKalaha.getNumberOfStones()) {
			return this;
		}
		if (numberOfStones < otherKalaha.getNumberOfStones()) {
			return otherKalaha;
		}
		return null; // equal (no winner)
	}

	@Override
	public boolean canPlay(Player player) {
		if (isOwner(player)) {
			return false;
		}
		return next.canPlay(player);
	}

	@Override
	public void collectStones(Player player, int stonesToCollect) {
		if (!isOwner(player)) {
			next.collectStones(player, stonesToCollect);
		}
		numberOfStones += stonesToCollect;
	}
}
