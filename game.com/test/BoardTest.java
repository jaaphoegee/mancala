import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class BoardTest {

	@Test
	public void constructorTest() {
		Player player1 = new Player("Jaap");
		Player player2 = new Player("Marielle");
		Board board = new Board(player1, player2);
		assertNotNull(board);
		final int[] initialStones = new int[] { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };
		assertNumberOfStones(board, initialStones);
	}

	@Test
	public void createBoarTest() {
		Player player1 = new Player("Jaap");
		Player player2 = new Player("Marielle");
		final int[] testStones = new int[] { 6, 2, 0, 3, 3, 4, 6, 3, 3, 0, 6, 2, 4, 6 };
		Board board = new Board(player1, player2, testStones);
		assertNotNull(board);
		assertNumberOfStones(board, testStones);
	}

	private void assertNumberOfStones(Board board, int[] expectedStones) {
		assertArrayEquals(expectedStones, getStones(board));
	}

	private int[] getStones(Board board) {
		ArrayList<Integer> stones = new ArrayList<>();
		BowlBase head = board.getHead();
		BowlBase element = head;
		do {
			stones.add(element.getNumberOfStones());
			element = element.getNext();
		} while (element != head);

		return stones.stream().mapToInt(i -> i).toArray();
	}

	private String toString(Board board) {
		StringBuilder builder = new StringBuilder();
		BowlBase head = board.getHead();
		BowlBase element = head;
		do {
			builder.append(element.getClass().getName() + " " + element.owner.getName() + " "
					+ element.getNumberOfStones() + "\n");
			element = element.getNext();
		} while (element != head);

		return builder.toString();
	}
}