public abstract class BowlBase {
	protected BowlBase next;
	protected Player owner;
	protected int numberOfStones;

	protected BowlBase(Player owner, int stones) {
		this.owner = owner;
		this.numberOfStones = stones;
	}

	protected int getNumberOfStones() {
		return numberOfStones;
	}

	protected BowlBase getNext() {
		return next;
	}

	protected void setNext(BowlBase node) {
		next = node;
	}

	protected boolean isOwner(Player player) {
		return this.owner.equals(player);
	}

	abstract protected Player play(Player player, int distributeStones);

	abstract protected int steal(Player player, int steps);

	abstract protected BowlBase getKahala();

	abstract protected boolean canPlay(Player player);

	abstract protected void collectStones(Player player, int stonesToCollect);

	abstract protected BowlBase determineWinner();
}
