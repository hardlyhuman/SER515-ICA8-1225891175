//package src;

public class main{
/**
 * @param args
 */
public static void main(final String[] args) {
    Urinals urinals = new Urinals();
    urinals.openFile("testfile.txt");
    String str = urinals.getString();
    int count = urinals.countUrinals(str);
    urinals.writeToFile(Integer.toString(count));
    urinals.closeFile();
    
}
}