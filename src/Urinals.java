import java.io.File;

//package src;

// Author: Sri Harsha Gajavalli
// ASU ID: 1225891175
// ASUrite: sgajaval
// Class: SER 515
// Last Modified Date: 03/02/2023



public class Urinals {
    private File file;

    public boolean goodString(String str) {
        return str.length() <= 16;
    }

    public void openFile(String fileName) {
        file = new File(fileName);
        // code to open file
    }

    public void closeFile() {
        // code to close file
    }

    public String getString() {
        // code to read string from file
        return "10101"; // example string for testing
    }

    public int countUrinals(String urinals){
        if (urinals.contains("11")) return -1;
            if (urinals.equals("0")) return 1;
            if (urinals.equals("1")) return 0;
    
            char[] chars = urinals.toCharArray();
            int counter = 0;
    
            for (int i = 0; i < chars.length - 1; i++) {
                if (i == 0) {
                    if (chars[i] == '0' && chars[i + 1] == '0') {
                        chars[i] = '1';
                        counter++;
                    }
                }
                if (i > 0) {
                    if (chars[i] == '0' && chars[i - 1] == '0' && chars[i + 1] == '0') {
                        chars[i] = '1';
                        counter++;
                    }
                }
            }
            if (chars[chars.length - 1] == '0' && chars[chars.length - 2] == '0') {
                counter++;
            }
            return counter;
      }
}
