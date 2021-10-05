import java.util.Scanner;

public class W1D2 {

    private static int arraySize;       // Array Size
    private static int[] array;         // Array
    private static int findNumber;      // Number we need to find
    
    private static int index;           // Output index

    public static void main(String[] args){
        takeInput();

        index = -1;                     // Set index to -1

        // Check if element out of range
        if(findNumber < array[0] || findNumber>array[arraySize-1]){
            System.out.println("Element Out of Range");
            return;
        }

        // Call Binary Search (0 , last index of array)
        BinarySearch(0,arraySize-1);

        // Output
        if(index != -1){
            System.out.printf("Element %d found at index %d\n",findNumber,index);
        }else{
            System.out.println("Element Not Found");
        }
    }


    /**
     * Binary Search By Recursion (lower index, higher index)
     */
    private static void BinarySearch(int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            if (array[mid] == findNumber){
                index = mid;
                return;
            }else if(array[mid]>findNumber){
                BinarySearch(low,mid-1);
            }else{
                BinarySearch(mid+1,high);
            }
        }
    }

    /**
     *  Input Method
     *  -> Input Size of array
     *  -> Input Array Elements
     *  -> Input No. we need to find
     * 
     *  Important - Array needs to be sorted in ascending order
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
        System.out.print("Enter Number to Find: ");
        findNumber = scanner.nextInt();
        scanner.close();
    }
}
