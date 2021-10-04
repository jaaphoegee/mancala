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
			if(isKalaha() && !this.owner.equals(player)) {
				return getNext().play(player, distributeStones);
			}
			if (distributeStones - 1  > 0 ) {
				numberOfStones++;
				return getNext().play(player, --distributeStones);
			}
			if(numberOfStones == 0 && this.owner.equals(player)) {
				// steal
				// optellen bij eigen steen
				// add to Kalaha
			}
			if(isKalaha()) {
				return player;
			}
			return player.getOtherPlayer();
	}

	private boolean isKalaha() {
		return Kalaha.class.isInstance(this);
 	}
}
