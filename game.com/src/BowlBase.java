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
			numberOfStones++;
			if ( --distributeStones  > 0 ) {
				return getNext().play(player, distributeStones);
			}

			// todo switch player?
			return player.getOtherPlayer();
	}
}
