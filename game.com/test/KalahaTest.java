import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class KalahaTest {

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
		Kalaha kalaha = new Kalaha(player);
		assertNotNull(kalaha);
	}

	@Test
	public void voidTestEndPlayInOwnKalahaShouldUpdate1AndReturnSamePlayer() {
		Kalaha kalaha = new Kalaha(player1);

		Player player = kalaha.play(player1, 1);
		assertEquals(1, kalaha.getNumberOfStones());
		assertEquals(player1, player);
	}

	@Test
	public void voidTestPassingOwnKalahaShouldUpdateWithOne() {
		Kalaha kalaha = new Kalaha(player1);
		kalaha.setNext(new Bowl(player2));

		kalaha.play(player1, 2);
		assertEquals(1, kalaha.getNumberOfStones());
	}

	@Test
	public void voidTestPlayOtherPlayersKalahaShouldNotUpdate() {
		Kalaha kalaha = new Kalaha(player1);
		kalaha.setNext(new Bowl(player2));
		assertEquals(0, kalaha.getNumberOfStones());
	}
}