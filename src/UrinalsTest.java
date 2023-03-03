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

    @Test
    public void testOpenAndCloseFile() {
        urinals.openFile("testfile.txt");
        // code to test file opening and closing
        urinals.closeFile();
    }

    @Test
    public void testGetString() {
        urinals.openFile("testfile.txt");
        String str = urinals.getString();
        assertEquals("10101", str);
        urinals.closeFile();
    }

    @Test
    public void testCountUrinals() {
        assertEquals(1, urinals.countUrinals("10001"));
        assertEquals(0, urinals.countUrinals("1001"));
        assertEquals(3, urinals.countUrinals("00000"));
        assertEquals(2, urinals.countUrinals("0000"));
        assertEquals(1, urinals.countUrinals("01000"));
        assertEquals(-1, urinals.countUrinals("011"));
    }
}
