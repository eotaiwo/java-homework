import java.io.*;
import java.util.Date;

/**
 * Exercise 2: Write and read binary data
 * 
 * Requirements:
 * Part 1 - WRITE:
 * - Store an array of five int values: 1, 2, 3, 4, 5
 * - Store a Date object for the current time
 * - Store the double value 5.5
 * - Write all to file named Exercise17_02.dat
 * 
 * Part 2 - READ:
 * - In the same program, read the data back
 * - Display all values to verify they were stored correctly
 * 
 * @author Elizabeth Taiwo
 */
public class Exercise17_02 {
    
    public static void main(String[] args) throws IOException {
        
        // Data to write
        int[] numbers = {1, 2, 3, 4, 5};
        Date currentTime = new Date();
        double value = 5.5;
        
        // PART 1: WRITE DATA
        DataOutputStream output = new DataOutputStream(
            new FileOutputStream("Exercise17_02.dat"));
        
        // Write the array of integers
        for (int i = 0; i < numbers.length; i++) {
            output.writeInt(numbers[i]);
        }
        
        // Write the Date object
        output.writeLong(currentTime.getTime());
        
        // Write the double value
        output.writeDouble(value);
        
        output.close();
        
        System.out.println("Data written to Exercise17_02.dat");
        
        
        // PART 2: READ DATA
        DataInputStream input = new DataInputStream(
            new FileInputStream("Exercise17_02.dat"));
        
        // Read the array of integers
        int[] readNumbers = new int[5];
        for (int i = 0; i < readNumbers.length; i++) {
            readNumbers[i] = input.readInt();
        }
        
        // Read the Date object
        Date readDate = new Date(input.readLong());
        
        // Read the double value
        double readValue = input.readDouble();
        
        input.close();
        
        // Display all the data you read
        System.out.println("\nData read from Exercise17_02.dat:");
        System.out.print("Array: ");
        for (int i = 0; i < readNumbers.length; i++) {
            System.out.print(readNumbers[i] + " ");
        }
        System.out.println();
        System.out.println("Date: " + readDate);
        System.out.println("Double: " + readValue);
    }
}