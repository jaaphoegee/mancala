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
			// TODO move play implementation to subclasses
			if(isKalaha() && !this.owner.equals(player)) {
				return next.play(player, distributeStones);
			}
			if(numberOfStones == 0 && this.owner.equals(player)) {
				// TODO Ook checken op distributeStones (moet de laatste zijn)
				int stolen = steal(player, 1);
			 	//	next.getKahala().add(stolen + 1);
				return player.getOtherPlayer();
			}
			numberOfStones++;
			if (distributeStones - 1  > 0 ) {
				return next.play(player, --distributeStones);
			}

			if(isKalaha()) {
				return player;
			}
			return player.getOtherPlayer();
	}

	protected int steal(Player player, int steps) {
		throw new RuntimeException("Steal() should be implemented in subclasses.");
	}

	private boolean isKalaha() {
		return Kalaha.class.isInstance(this);
 	}
}
