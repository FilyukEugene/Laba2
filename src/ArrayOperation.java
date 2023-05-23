import java.io.*;
import java.util.*;

public class ArrayOperation {
    private static int [][] array;
    private static int rows;
    private static int colomns;

    public ArrayOperation(int countOfRows, int countOfColomns){
        rows = countOfRows;
        colomns = countOfColomns;
        array = new int [rows][colomns];
    }

    public boolean equals(int[][] firstArray, int[][] secondArray){
        if (firstArray.length != secondArray.length && firstArray[0].length != secondArray[0].length){
            return false;
        }

        for (int i = 0; i < firstArray.length; i++){
            for (int j = 0; j < firstArray[0].length; j++){
                if (firstArray[i][j] != secondArray[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
    @Override
    public String toString(){
        String arrayToString = "";
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colomns; j++){
                arrayToString += Integer.toString(array[i][j]) + " ";
            }
            arrayToString += ("\n");
        }
        return arrayToString;
    }

    public void sortArray(){
        int[] simpleArray = new int[rows*colomns];
        int index = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colomns; j++){
                simpleArray[index] = array[i][j];
                index++;
            }
        }
        Arrays.sort(simpleArray);
        index = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colomns; j++){
                array[i][j] = simpleArray[index];
                index++;
            }
        }
    }
    public void fillArray(){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colomns; j++) {
                System.out.printf("Enter value to the element[" + Integer.toString((i + 1)) + "]["
                        + Integer.toString((j + 1)) + "]:");
                array[i][j] = in.nextInt();
            }
        }
    }

    public void fillArray(int min , int max){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < colomns; j++){
                array[i][j] = (int) Math.floor(Math.random() *(max - min + 1) + min);
            }
        }
    }

    public void fillArray(String filePath){
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            rows = Integer.parseInt(br.readLine());
            colomns = Integer.parseInt(br.readLine());
            array = new int[rows][colomns];
            System.out.println ("Fill array by some data from file:" + filePath);
            System.out.printf("\n");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < colomns; j++) {
                    array[i][j] = Integer.parseInt(br.readLine());
                }
            };
        }
        catch (IOException e){
            System.out.printf("File path incorrect");
        }
    }

    public void printArray(){
        System.out.printf(this.toString());
    }

    public void printArray(String filePath){
        try{
            FileWriter fw = new FileWriter (filePath);
            BufferedWriter bw = new BufferedWriter (fw);
            System.out.println ("Print some data to file:" + filePath);
            bw.write(String.valueOf(rows));
            bw.newLine();
            bw.write(String.valueOf(colomns));
            bw.newLine();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < colomns; j++) {
                    bw.write(String.valueOf(array[i][j]));
                    bw.newLine();
                }
            }
            bw.close();
            System.out.printf("Done!\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkFilePath(String filePath){
        File f = new File(filePath);
        if (f.exists()){
            return true;
        }
        return false;
    }
}
