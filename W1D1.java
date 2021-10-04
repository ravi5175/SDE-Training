import java.util.Scanner;

class W1D1{

    
    private static int arraySize;       // Array Size
    private static int[] array;         // Array
    private static int replaceNumber;   // No. needs to be Replaced

    public static void main(String args[]){
        // Take input
        takeInput();    
        
        // Set Replace Offset to Last Element of Array
        int replaceAt = arraySize-1;

        // Ajust Replace Offset in case Last element is one needs to be replaced.
        for(int i=arraySize-1;i>0;i--){
            if(array[i]!=replaceNumber){
                replaceAt = i;
                break;
            }
        }

        // Check if offset becomes 0.
        // i.e array is made of elements needs to be replaced
        if(replaceAt>0){

            // Perform a linear search from index 0
            for(int i=0;i<replaceAt;i++){

                // If element needs to be replaced found,
                // Then replace element with offset index untill i<replaceAt
                if(array[i]==replaceNumber){

                    // Number Swap Logic
                    int temp = array[i];
                    array[i] = array[replaceAt];
                    array[replaceAt] = temp;

                    // Update Offset Index
                    replaceAt--;
                }
            }
        }
        
        // Take Output
        System.out.println("Result Array : ");
        for(int i : array){
            System.out.printf("%d, ",i);
        }

    }

    /**
     *  Input Method
     *  -> Input Size of array
     *  -> Input Array Elements
     *  -> Input No. needs to be Replaced
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

        System.out.print("Enter Number to be replaced: ");
        replaceNumber = scanner.nextInt();
        scanner.close();
    
    }
}