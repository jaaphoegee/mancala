public class Bowl extends BowlBase {

	Bowl(Player owner) {
		super(owner);
		numberOfStones = 4;
	}

	Bowl(Player owner, int numberOfStones) {
		super(owner, numberOfStones);
	}

	public Player distribute(Player player, int bowlNumber) {
		if (isOwner(player) && --bowlNumber == 0) {
			int distributeStones = numberOfStones;
			numberOfStones = 0;
			return getNext().play(player, distributeStones);
		}
		return ((Bowl)getNext()).distribute(player, bowlNumber);
	}

	@Override
	public int steal(Player player, int steps) {
		if (isOwner(player)) {
			return next.steal(player, ++steps);
		}
		if (steps - 1 == 0) {
			int stolenStones = numberOfStones;
			numberOfStones = 0;
			return stolenStones;
		}
		return next.steal(player, --steps);
	}

	@Override
	public Player play(Player player, int distributeStones) {
		if (distributeStones == 1 && numberOfStones == 0 && isOwner(player)) {
			int stolen = steal(player, 0);
			((Kalaha)next.getKahala()).add(stolen + 1);
			return player.getOtherPlayer();
		}
		numberOfStones++;
		if (distributeStones - 1 > 0) {
			return next.play(player, --distributeStones);
		}
		return player.getOtherPlayer();
	}

	public BowlBase getKahala() {
		return next.getKahala();
	}

	public BowlBase getWinner() {
		return next.getWinner();
	}

	public boolean canPlay(Player player) {
		if (isOwner(player) && numberOfStones > 0) {
			return true;
		}
		return next.canPlay(player);
	}

	public void collectStones(Player player) {
		((Kalaha)getKahala()).add(numberOfStones); //#todo not nice using Kalaha
		numberOfStones = 0;
		next.collectStones(player);
	}
}
