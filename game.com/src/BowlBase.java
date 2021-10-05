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

	protected BowlBase getKahala() {
		if (this instanceof Kalaha) {
			return this;
		}
		return next.getKahala();
	}
}
