import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

public class BoardTest {

	@Test
	public void constructorTest() {
		Player player1 = new Player("Jaap");
		Player player2 = new Player("Marielle");
		Board board = new Board(player1, player2);
		assertNotNull(board);
		System.out.println(toString(board));
	}

	private void assertCircularLinkedList(int[] stones) {

	}

	private String toString(Board board) {
		StringBuilder builder = new StringBuilder();
		BowlBase head = board.getHead();
		BowlBase element = head.getNext();
		while (element != head) {
			builder.append(element.getClass().getName() + " " + element.owner.getName() + " "
					+ element.getNumberOfStones() + "\n");
			element = element.getNext();
		}
		return builder.toString();
	}
}