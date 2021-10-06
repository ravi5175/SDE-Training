import java.util.Scanner;

public class W1D3 {


    private static int arraySize;       // Array Size
    private static int[] array;         // Array
    private static int findNumber;      // Number we need to find
    
    private static int index; 
    private static int pivot;

    public static void main(String[] args){
        // Input
        takeInput();

        index = -1;     // initial index
        pivot = 0;      // initial pivot

        // Check if Array is rotated on a pivot
        if(!(array[0]< array[arraySize-1])){
            // Calculate Pivot Point
            pivotPoint(0,arraySize-1);

            if(findNumber > array[pivot] || findNumber < array[pivot+1] ){
                System.out.println("Element Out of Range");
                return;
            }
            
            if(findNumber <= array[pivot] && findNumber>= array[0]){
                System.out.println("this called");
                binarySearch(0,pivot);
            }else{
                System.out.println("that called");
                binarySearch(pivot+1,arraySize-1);
            }

        }else{
            // Array is not rotated
            // Element Lies in Array's Range
            if(findNumber < array[0] || findNumber>array[arraySize-1]){
                System.out.println("Element Out of Range");
                return;
            }
            binarySearch(0,arraySize-1);
        }

        // Output
        System.out.printf("Pivot Found at %d\n",pivot);
        if(index != -1){
            System.out.printf("Element %d found at index %d\n",findNumber,index);
        }else{
            System.out.println("Element Not Found");
        }
    }

    private static void pivotPoint(int low,int high){
        if(low < high){
            int mid = (low+high)/2;
            if(!(array[mid]<array[mid+1])){
                pivot = mid;
                return;
            }
            if(array[0]<=array[mid]){
                pivotPoint(mid, high);
            }else{
                pivotPoint(0,mid);
            }
        }
    }

    /**
     * Binary Search By Recursion (lower index, higher index)
     */
    private static void binarySearch(int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            if (array[mid] == findNumber){
                index = mid;
                return;
            }else if(array[mid]>findNumber){
                binarySearch(low,mid-1);
            }else{
                binarySearch(mid+1,high);
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
