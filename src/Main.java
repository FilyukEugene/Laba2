import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.module.FindException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath;
        ArrayOperation arrayOperation = new ArrayOperation(2, 2);
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.printf("Enter file path to write:");
            filePath = in.nextLine();
            arrayOperation.fillArray(15,20);
            if (arrayOperation.checkFilePath(filePath)){
                arrayOperation.fillArray(filePath);
                arrayOperation.printArray();
                System.out.printf("\n");
                arrayOperation.sortArray();
                arrayOperation.printArray();
                break;
            }
            System.out.printf("You input incorrent file path! Please, Try again\n");
        }
    }
}