import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

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
    public void testReadFileToList() {
        // Test case when file is present
        
        String filename = "/Users/hardlyhuman/Documents/ASU/Semester 2/SER 515/SER515-ICA8-1225891175/src/test.txt";
        List<String> inputList = urinals.readFileToList(filename);
        assertEquals(2, inputList.size());
        assertEquals("Hello", inputList.get(0));
        assertEquals("World", inputList.get(1));
    }

    @Test
    public void testReadFileToList_FileNotFound() {
        // Test case when file is not present
        String filename = "SER515-ICA8-1225891175/src/missing.txt";
        assertNull(urinals.readFileToList(filename));
    }

    @Test
    public void testReadFileToList_EmptyFile() {
        // Test case when file is present but empty
        String filename = "/Users/hardlyhuman/Documents/ASU/Semester 2/SER 515/SER515-ICA8-1225891175/src/empty.txt";
        List<String> inputList = urinals.readFileToList(filename);
        assertTrue(inputList.isEmpty());
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
