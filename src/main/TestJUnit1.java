import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit1 {
    @Test
    public void testSetup() {
        String str = "I am done with JUnit Setup!";
        assertEquals("I am done with JUnit Setup!", str);
    }
}
