import java.util.Scanner;

public class W1D4 {

    private static int[] array;     // Input Array
    private static int arraySize;   // Input Array Size
    private static int findSum;     // Required Sum
    private static int firstIndex;  // First Index
    private static int secondIndex; // Second Index



    public static void main(String[] args){
        firstIndex =  -1;
        secondIndex = -1;

        takeInput();
        findPair();

        if(firstIndex != -1){
            System.out.printf("Required Indices are %d and %d\n",firstIndex,secondIndex);
        }else{
            System.out.println("No Pair present in Array for given Sum");
        }
    }

    private static void findPair(){
        for(int i = 0;i<=arraySize -2;i++ ){
            for (int j = i+1; j<=arraySize -1;j++){
                if(findSum - array[i] == array[j]){
                    firstIndex = i;
                    secondIndex = j;
                    break;
                }
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

        System.out.print("Enter Sum of Pair: ");
        findSum = scanner.nextInt();
        scanner.close();
    }
}
