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

	abstract protected Player play(Player player, int distributeStones);

	abstract  protected int steal(Player player, int steps);

	protected boolean isOwner(Player player) {
		return this.owner.equals(player);
	}

	abstract protected BowlBase getKahala();

	private boolean isKalaha() {
		return Kalaha.class.isInstance(this);
	}
}
