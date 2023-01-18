import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
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
	public void constructorTest() {
		Player player = new Player("Ozone");
		assertNotNull(player);
	}

	@Test
	public void testOtherPlayer() {
		Player player1 = new Player("Jaap");
		Player player2 = new Player("Marielle");

		player1.setOtherPlayer(player2);
		player2.setOtherPlayer(player1);

		assertEquals(player2, player1.getOtherPlayer());
		assertEquals(player1, player2.getOtherPlayer());
	}

	@Test
	public void setNextPlayerTest() {
		player1.setCurrentPlayer(player2);
		assertEquals(player2, player1.getCurrentPlayer());
		assertEquals(player2, player2.getCurrentPlayer());
		player1.setCurrentPlayer(player1);
		assertEquals(player1, player1.getCurrentPlayer());
		assertEquals(player1, player2.getCurrentPlayer());
	}
}