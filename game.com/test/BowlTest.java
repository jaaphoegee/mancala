import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

public class BowlTest {
	@Test
	public void constructorTest() {
		Player player = new Player("Ozone");
		Bowl bowl = new Bowl(player);
		assertNotNull(bowl);
	}


}