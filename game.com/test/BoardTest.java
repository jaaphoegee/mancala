import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

	private final int[] initialStones = new int[] { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };
	private static Player player1;
	private static Player player2;

	@BeforeClass
	public static void init() {
		player1 = new Player("Jaap");
		player2 = new Player("Marielle");

		player1.setOtherPlayer(player2);
		player2.setOtherPlayer(player1);
	}

	@Test
	public void createDefaultBoardTest() {
		Board board = new Board(player1, player2);
		assertNotNull(board);
		assertNumberOfStones(board, initialStones);
	}

	@Test
	public void createBoardWithSpecificNumberOfStonesTest() {
		final int[] testStones = new int[] { 6, 2, 0, 3, 3, 4, 6, 3, 3, 0, 6, 2, 4, 6 };
		Board board = new Board(player1, player2, testStones);
		assertNotNull(board);
		assertNumberOfStones(board, testStones);
	}

	@Test
	public void playStonesEndInOwnBowl() {
		Board board = new Board(player1, player2, initialStones);
		Player nextPlayer = board.play(player1, 2);
		final int[] expectedStones = new int[] { 4, 0, 5, 5, 5, 5, 0, 4, 4, 4, 4, 4, 4, 0 };
		assertNumberOfStones(board, expectedStones);
		assertEquals(player2, nextPlayer);
	}

	@Test
	public void playStonesEndInOwnKalaha() {
		Board board = new Board(player1, player2, initialStones);
		Player nextPlayer = board.play(player1, 3);
		final int[] expectedStones = new int[] { 4, 4, 0, 5, 5, 5, 1, 4, 4, 4, 4, 4, 4, 0 };
		assertNumberOfStones(board, expectedStones);
		assertEquals(player1, nextPlayer);
	}

	@Test
	public void playStonesAndPassOwnKalaha() {
		Board board = new Board(player1, player2, initialStones);
		Player nextPlayer = board.play(player1, 6);
		final int[] expectedStones = new int[] { 4, 4, 4, 4, 4, 0, 1, 5, 5, 5, 4, 4, 4, 0 };
		assertNumberOfStones(board, expectedStones);
		assertEquals(player2, nextPlayer);
	}

	@Test
	public void playStonePassingOppositeKalaha() {
		final int[] testStones = new int[] { 1, 1, 1, 1, 1, 8, 5, 1, 1, 1, 1, 1, 1, 5 };
		Board board = new Board(player1, player2, testStones);
		Player nextPlayer = board.play(player1, 6);
		final int[] expectedStones = new int[] { 2, 1, 1, 1, 1, 0, 6, 2, 2, 2, 2, 2, 2, 5  };
		assertNumberOfStones(board, expectedStones);
		assertEquals(player2, nextPlayer);
	}

	@Test
	public void play1stoneAndSteal() {
		final int[] testStones = new int[] { 1, 1, 1, 0, 1, 8, 5, 1, 1, 4, 1, 1, 1, 5 };
		final int[] expectedStones = new int[] { 1, 1, 0, 0, 1, 8, 10, 1, 1, 0, 1, 1, 1, 5 };
		Board board = new Board(player1, player2, testStones);
		Player nextPlayer = board.play(player1, 3);
		assertNumberOfStones(board, expectedStones);
		assertEquals(player2, nextPlayer);
	}

	@Test
	public void testEndGameWhileThereAreStillStonesToPlay() {
		final int[] testStones = new int[] { 1, 1, 1, 0, 1, 8, 5, 1, 1, 4, 1, 1, 1, 5 };
		Board board = new Board(player1, player2, testStones);
		/*
		 * assertTrue( board.canPlay(player1));
		 * assertTrue( board.canPlay(player2));
		 */
	assertFalse(true);
	}

	@Test
	public void testEndGameWhenThereAreNoStonesToPlay() {
		final int[] testStones = new int[] { 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 1, 5 };
		Board board = new Board(player1, player2, testStones);
		/*
		 * assertFalse( board.canPlay(player1));
		 * assertTrue( board.canPlay(player2));
		 */

		assertFalse(true);
	}

	@Test
	public void determineWinner()
	{
		final int[] testStones = new int[] { 0, 0, 0, 0, 0, 8, 5, 1, 1, 4, 1, 1, 1, 5 };
		Board board = new Board(player1, player2, testStones);
		/*
		 * winner = board.GetWinner();
		 * assertEquals(player2, winner);
		 * stones = board.getKalaha(winner);
		 * assertEquals(14, stones);
		 */
		assertFalse(true);
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