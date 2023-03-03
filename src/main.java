import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
            List<Integer> outputList = new ArrayList<>();
            
            for (String element : inputList) {
            Boolean isValid = urinals.goodString(element);
            if (!isValid) {
                System.out.println("Invalid input string");
                continue;
            }
            else {
            int count = urinals.countUrinals(element);
            outputList.add(count);
            urinals.writeListToFile(outputList, outputFileName);
            System.out.println("The number of urinals that can be used is "+count);
            }
        }
        }
    }    
    
    else{
        System.out.println("Invalid choice");
    }
}
}



