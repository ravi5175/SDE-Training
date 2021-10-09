import java.util.Scanner;

public class W1D5 {

    private static int[] array;
    private static int arraySize;
    private static int targetNumber;

    private static int startingIndex;
    private static int endingIndex;

    public static void main(String[] args){
        startingIndex = -1;
        endingIndex = -1;

        // Take Input
        takeInput();
        BinarySearchToLeft(0,arraySize-1);
        BinarySearchToRight(0,arraySize-1);
        printOutput();
    }

    private static void BinarySearchToLeft(int low,int high){

        if(low<=high){
            int mid = (low + high)/2;
            
            if(low == high){
                startingIndex = low;
                return;
            }
            if(array[mid] == targetNumber || array[mid] > targetNumber){
                BinarySearchToLeft(low, mid-1);
            }else{
                BinarySearchToLeft(mid+1,high);
            }
        }
    }

    private static void BinarySearchToRight(int low,int high){

        if(low<=high){
            
            int mid = (low + high)/2;

            if(low == high){
                endingIndex = low;
                return;
            }
            
            if(array[mid] == targetNumber || array[mid] < targetNumber){
                BinarySearchToRight(mid+1, high);
            }else{
                BinarySearchToRight(low,mid-1);
            }
        }
    }

     /**
     *  Input Method
     *  -> Input Size of array
     *  -> Input Array Elements
     *  -> Input Sum. we need to find
     * 
     */
    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Size of Array : ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];
        
        for(int i = 0 ; i< arraySize; i++){
            System.out.printf("Enter %d th element: ",i);
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter Target Number: ");
        targetNumber = scanner.nextInt();
        scanner.close();
    }

    private static void printOutput(){
        if(startingIndex == -1){
            System.out.println("Target Number Not Exist");
        }else if(startingIndex == endingIndex){
            System.out.printf("Target number lies on index : %d\n",startingIndex);
        }else{
            System.out.printf("Target number lies on index range : %d to %d\n",startingIndex,endingIndex);
        }
    }
}
