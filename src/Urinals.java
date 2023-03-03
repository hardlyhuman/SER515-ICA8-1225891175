import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<String> readFileToList(String filename) {
        List<String> inputList = new ArrayList<>();
        
        try {
            File file = new File(filename);
            
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    inputList.add(line);
                }
                bufferedReader.close();
            } else {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    
        
        return inputList;
    }

    public void closeFile() {
        // code to close file
    }

    public void writeToFile(String str) {
        // code to write to file
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
