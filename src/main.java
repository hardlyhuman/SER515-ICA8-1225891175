import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//package src;

public class main{
/**
 * @param args
 * @throws IOException
 */
public static void main(final String[] args) throws IOException {
    Urinals urinals = new Urinals();
    System.out.println("Enter 0 to read the input from the file or 1 to enter the input from CLI");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    if(choice == 1){
        System.out.println("Enter the input string");
        String str = sc.next();
        int count = urinals.countUrinals(str);
        System.out.println("The number of urinals that can be used is "+count);
    }
    else if(choice == 0){
        System.out.println("Enter the input file name");
        String fileName = sc.next();
        System.out.println("Enter the output file name");
        String outputFileName = sc.next();
        List<String> inputList = urinals.readFileToList(fileName);
        if (inputList == null) {
            System.out.println("File not found.");
        } else {
            System.out.println("Input list: " + inputList);
            File file = new File(outputFileName);
                
                // Create a new FileWriter object with the file
            FileWriter writer;
            writer = new FileWriter(file);
            
            for (String element : inputList) {
            Boolean isValid = urinals.goodString(element);
            if (!isValid) {
                System.out.println("Invalid input string");
                continue;
            }
            else {
            int count = urinals.countUrinals(element);
            
            try{
                writer.write(Integer.toString(count) + "\n");
            }
            catch(IOException e){
                System.out.println("Error writing to file: " + e.getMessage());
            }
            System.out.println("The number of urinals that can be used is "+count);
            }
        }
            writer.close();
    }
        
    }
    
    else{
        System.out.println("Invalid choice");
    }
}
   // urinals.openFile("testfile.txt");
    //String str = urinals.getString();
   // int count = urinals.countUrinals(str);
   // urinals.writeToFile(Integer.toString(count));
   // urinals.closeFile();
    
}
