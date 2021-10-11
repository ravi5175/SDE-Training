import java.util.Scanner;

public class W1D8P2 {
    private static int[][] array;
    private static int arraySize;

    public static void main(String[] args){
        takeInput();
        transposeMatrix();
        reverseMatrixByRow();
        printOutput();
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size (NxN) : ");
        arraySize = scanner.nextInt();

        array = new int[arraySize][arraySize];

        System.out.println("Feed Array");
        for(int i=0;i<arraySize;i++){
            for(int j =0 ;j<arraySize;j++){
                System.out.printf("Enter Array[%d,%d] element : ",i,j);
                array[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    private static void transposeMatrix(){
        for(int i=0;i<arraySize;i++){
            for(int j=0;j<=i;j++){
                int temp = array[j][i];
                array[j][i] = array[i][j];
                array[i][j] = temp;
            }
        }
    }

    private static void reverseMatrixByRow(){
        for(int i=0;i<arraySize;i++){
            int start = 0;
            int end = arraySize-1;
            while(start<end){
                int temp = array[i][end];
                array[i][end] = array[i][start];
                array[i][start] = temp;
                start++;
                end--;
            }
        }
    }

    private static void printOutput(){
        for(int i=0;i<arraySize;i++){
            for(int j=0;j<arraySize;j++){
                System.out.printf("%d ",array[i][j]);
            }
            System.out.println();
        }
    }
}
