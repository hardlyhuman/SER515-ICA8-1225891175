import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    public void testWriteListToFile() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        String filename = "testfile.txt";

        // Call the method to write the list to file
        urinals.writeListToFile(list, filename);

        // Verify that the file was created and contains the correct data
        File file = new File(filename);
        assertTrue(file.exists());

        List<String> inputList = urinals.readFileToList(filename);
        assertNotNull(inputList);
        assertEquals(3, inputList.size());
        assertEquals("10", inputList.get(0));
        assertEquals("20", inputList.get(1));
        assertEquals("30", inputList.get(2));

        // Cleanup
        file.delete();
    }

    @Test
    public void testWriteEmptyListToFile() {
        List<Integer> list = new ArrayList<>();
        String filename = "testfile.txt";

        // Call the method to write the list to file
        urinals.writeListToFile(list, filename);

        // Verify that the file was created and is empty
        File file = new File(filename);
        assertTrue(file.exists());
        assertEquals(0, file.length());

        // Cleanup
        file.delete();
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
