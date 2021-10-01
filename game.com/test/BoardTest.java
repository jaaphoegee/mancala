import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void constructorTest() {
		Board board= new Board();
		assertNotNull(board);
	}
}