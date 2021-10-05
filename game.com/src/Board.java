

//         6 5 4 3 2 1
//       k1           k2
//         1 2 3 4 5 6

public class Board {

	static private class CircularLinkedList {
		private BowlBase head = null;
		private BowlBase tail = null;


		public BowlBase getHead() {
			return head;
		}

		public void add(BowlBase node) {
			if (head == null) {
				head = node;
			} else {
				tail.setNext(node);
			}
			tail = node;
			tail.setNext(head);
		}
	}

	private static final int[] defaultStones =  new int[] { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };
	private final Player player1;
	private final Player player2;
	private final CircularLinkedList list;
	protected Bowl bowl1Player1;

	public Board(Player player1, Player player2, int[] stones) {
		this.player1 = player1;
		this.player2 = player2;
		list = createBoard(stones);
		bowl1Player1 = (Bowl)list.getHead();
	}

	public Board(Player player1, Player player2) {
		this(player1, player2, defaultStones);
	}

	public BowlBase getHead() {
		return list.getHead();
	}

	private CircularLinkedList createBoard(int[] stones) {
		CircularLinkedList clc = new CircularLinkedList();
		clc.add(new Bowl(player1, stones[0]));
		clc.add(new Bowl(player1, stones[1]));
		clc.add(new Bowl(player1, stones[2]));
		clc.add(new Bowl(player1, stones[3]));
		clc.add(new Bowl(player1, stones[4]));
		clc.add(new Bowl(player1, stones[5]));
		clc.add(new Kalaha(player1, stones[6]));
		clc.add(new Bowl(player2, stones[7]));
		clc.add(new Bowl(player2, stones[8]));
		clc.add(new Bowl(player2, stones[9]));
		clc.add(new Bowl(player2, stones[10]));
		clc.add(new Bowl(player2, stones[11]));
		clc.add(new Bowl(player2, stones[12]));
		clc.add(new Kalaha(player2, stones[13]));
		return clc;
	}

}
