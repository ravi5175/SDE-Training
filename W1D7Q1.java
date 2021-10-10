// Juggling Algorithm
import java.util.Scanner;

public class W1D7Q1 {

    private static int arraySize;
    private static int[] array;
    private static int rotateBy;
    public static void main(String[] args){
        takeInput();
        printOutput();
    }

    
    private static int findGCD(int a,int b){
        if(a == 0){
            return b;
        }else{
            findGCD(b,a%b);
        }
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        arraySize = scanner.nextInt();

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


