public class BowlBase {
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

	protected Player play(Player player, int distributeStones) {
		throw new RuntimeException("player() should be implemented in subclasses.");
	}

	protected int steal(Player player, int steps) {
		throw new RuntimeException("Steal() should be implemented in subclasses.");
	}

	protected BowlBase getKahala() {
		if (this instanceof Kalaha) {
			return this;
		}
		return next.getKahala();
	}
}
