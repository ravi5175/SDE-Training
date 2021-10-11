// Longest Common Prefix

import java.util.Scanner;

public class W1D8P1 {

    private static int arraySize;
    private static String[] array;
    private static StringBuilder result;

    public static void main(String[] args){
        takeInput();
        sortArray();
        longestPrefix();
        printOutput();
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        arraySize = scanner.nextInt();
        array = new String[arraySize];
        scanner.nextLine();
        for(int i = 0;i<arraySize;i++){
            System.out.printf("Enter String[%d] : ",i);
            array[i] = scanner.nextLine();
        }
        scanner.close();
    }

    private static void sortArray(){
        for(int i=0;i<arraySize-1;i++){
            for(int j= i+1 ;j<arraySize;j++){
                if(array[i].compareTo(array[j]) > 0){
                    String temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    private static void longestPrefix(){

        int l1 = array[0].length();
        int l2 = array[arraySize-1].length();

        int maxPrefixRange = l1<l2?l1:l2;
        int pointerIndex = 0;

        result = new StringBuilder();

        while(pointerIndex<maxPrefixRange){
            if(array[0].charAt(pointerIndex) == array[arraySize-1].charAt(pointerIndex)){
                result.append(array[0].charAt(pointerIndex));
                pointerIndex++;
            }else{
                break;
            }
        }
    }

    private static void printOutput(){
        System.out.println("Sorted Array : ");
        for(int i=0;i<arraySize;i++){
            System.out.print(array[i]+", ");
        }
        System.out.println();
        System.out.println("Longest Common Prefix : " + result);
    }
}
