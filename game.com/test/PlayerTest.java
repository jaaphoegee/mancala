import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PlayerTest {
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
}