import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

public class PlayerTest {
	@Test
	public void constructorTest() {
		Player player = new Player("Ozone");
		assertNotNull(player);
	}
}