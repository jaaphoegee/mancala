import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BowlTest {
	@Test
	public void constructorTest() {
		Player player = new Player("Ozone");
		Bowl bowl = new Bowl(player);
		assertNotNull(bowl);
	}


}