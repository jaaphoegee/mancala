import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class PlayerTest {
	@Test
	public void constructorTest() {
		Player player= new Player();
		assertNotNull(player);
	}
}