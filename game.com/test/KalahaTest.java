import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

public class KalahaTest {

	@Test
	public void constructorTest() {
		Player player = new Player("Ozone");
		Kalaha kalaha = new Kalaha(player);
		assertNotNull(kalaha);
	}
}