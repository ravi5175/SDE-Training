// Juggling Algorithm
import java.util.Scanner;

public class W1D7Q1 {

    private static int arraySize;
    private static int[] array;
    private static int rotateBy;
    public static void main(String[] args){
        takeInput();
        reverseArray(0, arraySize-(1+rotateBy));
        reverseArray(arraySize-rotateBy,arraySize-1);
        reverseArray(0,arraySize-1);
        printOutput();
    }

    
    private static void reverseArray( int start,int end){
        while(start<end){
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];
        for(int i=0;i<arraySize;i++){
            System.out.printf("Enter [%d] element : ",i);
            array[i] = scanner.nextInt();
        }

        System.out.print("Rotate array to right by :");
        rotateBy = scanner.nextInt();
        scanner.close();
    }

    private static void printOutput(){
        for(int i=0;i<arraySize;i++){
            System.out.printf("%d, ",array[i]);
        }
        System.out.println();
    }
}


