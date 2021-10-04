public class Bowl extends BowlBase{

	Bowl(Player owner) {
		super(owner);
		numberOfStones = 4;
	}

	Bowl(Player owner, int numberOfStones) {
		super(owner, numberOfStones);
	}
}
