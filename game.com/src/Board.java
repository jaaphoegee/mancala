

//         6 5 4 3 2 1
//       k1           k2
//         1 2 3 4 5 6

public class Board {
	private class CircularLinkedList {
		private BowlBase head = null;
		private BowlBase tail = null;

		public BowlBase getHead() {
			return head;
		}

		public BowlBase getTail() {
			return tail;
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

	private Player player1;
	private Player player2;
	private CircularLinkedList clc;

	public Board(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		clc = createBoard();
	}

	private CircularLinkedList createBoard() {
		CircularLinkedList clc = new CircularLinkedList();
		clc.add(new Bowl(player1));
		clc.add(new Bowl(player1));
		clc.add(new Bowl(player1));
		clc.add(new Bowl(player1));
		clc.add(new Bowl(player1));
		clc.add(new Bowl(player1));
		clc.add(new Kalaha(player1));
		clc.add(new Bowl(player2));
		clc.add(new Bowl(player2));
		clc.add(new Bowl(player2));
		clc.add(new Bowl(player2));
		clc.add(new Bowl(player2));
		clc.add(new Bowl(player2));
		clc.add(new Kalaha(player2));
		return clc;
	}

	public BowlBase getHead() {
		return clc.getHead();

	}

}
