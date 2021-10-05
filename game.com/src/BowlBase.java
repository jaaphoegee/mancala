public abstract class BowlBase {
	protected BowlBase next;
	protected Player owner;
	protected int numberOfStones;

	BowlBase(Player owner) {
		this.owner = owner;
	}

	BowlBase(Player owner, int stones) {
		this(owner);
		this.numberOfStones = stones;
	}

	public int getNumberOfStones() {
		return numberOfStones;
	}

	public BowlBase getNext() {
		return next;
	}

	public void setNext(BowlBase node) {
		next = node;
	}

	protected boolean isOwner(Player player) {
		return this.owner.equals(player);
	}

	abstract protected Player play(Player player, int distributeStones);

	abstract protected int steal(Player player, int steps);

	abstract protected BowlBase getKahala();

	abstract protected boolean canPlay(Player player);

	abstract protected void collectStones(Player player);

	abstract protected BowlBase getWinner();
}
