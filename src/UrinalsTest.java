import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UrinalsTest {
    private Urinals urinals;

    @Before
    public void setUp() {
        urinals = new Urinals();
    }

    @Test
    public void testGoodString() {
        assertFalse(urinals.goodString("0123456789ABCDEF1"));
    }

    
}
