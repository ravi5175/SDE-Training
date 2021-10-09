import java.util.Scanner;


public class W1D6 {
    
    private static int[] array;
    private static int arraySize;
    private static int missingNumber;

    public static void main(String[] args){
        missingNumber = -1;
        takeInput();
        segregateArray();
        findMissingNumber();
        printOutput();
    }

    private static void segregateArray(){
        int swapPointer = 0;
        
        for(int i= arraySize-1;i>0;i--){
            if(array[i]>0){
                swapPointer = i;
                break;
            }
        }

        for(int i =0;i<swapPointer;i++){
            if(array[i]<=0){
                int temp = array[swapPointer];
                array[swapPointer] = array[i];
                array[i] = temp;
            }
        }
    }

    private static void findMissingNumber(){
        // Flipping Sign
        for(int i = 0 ;i<arraySize;i++){
            int num = Math.abs(array[i]);
            if(num < arraySize && num >0){
                if(array[num-1]>0){
                    array[num -1] = -array[num -1];
                }
               
            }
        }
        // First Positive Number
        for(int i=0;i<arraySize;i++){
            if(array[i]>=0){
                missingNumber = i+1;
                break;
            }
        }
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Size of Array : ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];
        
        for(int i = 0 ; i< arraySize; i++){
            System.out.printf("Enter %d th element: ",i);
            array[i] = scanner.nextInt();
        }
        scanner.close();
    }

    private static void printOutput(){
        System.out.printf("Least Positive Missing Number : %d\n",missingNumber);
    }
}
