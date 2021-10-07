import java.util.Scanner;

public class W1D3 {


    private static int arraySize;       // Array Size
    private static int[] array;         // Array
    private static int findNumber;      // Number we need to find
    
    private static int index;           // Index of Number we need to find if exist else -1
    private static int pivot;           // Pivot point if exist in array else 0

    public static void main(String[] args){
        // Input
        takeInput();

        index = -1;     // initial index
        pivot = 0;      // initial pivot

        // Check if Array is rotated on a pivot
        if(!(array[0]< array[arraySize-1])){
            // Calculate Pivot Point
            pivotPoint(0,arraySize-1);

            // Check if element out of range
            if(findNumber > array[pivot] || findNumber < array[pivot+1] ){
                System.out.println("Element Out of Range");
                return;
            }
            
            // Check if element lie in left or right side of pivot
            if(findNumber <= array[pivot] && findNumber>= array[0]){
                // Element lies on left
                binarySearch(0,pivot);
            }else{
                // Element lies on right
                binarySearch(pivot+1,arraySize-1);
            }

        }else{
            // Array is not rotated
            // Element Lies in Array's Range
            if(findNumber < array[0] || findNumber>array[arraySize-1]){
                System.out.println("Element Out of Range");
                return;
            }

            // Apply Binary Search to find element
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

    /**
     * Binary Search By Recursion for Pivot Calculation
     * @param low -> lower index of range
     * @param high -> higher index of range
     */
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
     * Binary Search By Recursion for Element Search
     * @param low -> lower index of range
     * @param high -> higher index of range
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
     *  -> Input Array Elements [sorted ascending order with or without pivot point]
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
