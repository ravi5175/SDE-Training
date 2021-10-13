import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class W2D10P1 {
    private static int arraySize;
    private static String[] array;
    private static HashMap<String, ArrayList<String>> map;

    public static void main(String[] args){
        takeInput();
        anagramMapper();
        printOutput();
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        arraySize = scanner.nextInt();
        array = new String[arraySize];

        scanner.nextLine();
        for(int i = 0 ; i< arraySize; i++){
            System.out.printf("Enter %d th element: ",i);
            array[i] = scanner.nextLine();
        }
        scanner.close();
    }

    private static void anagramMapper(){
        map = new HashMap<String,ArrayList<String>>();
        for(String word : array){
            String tempKey = sortWord(word);
            if(!map.containsKey(tempKey)){
                ArrayList<String> anagramList = new ArrayList<String>();
                anagramList.add(word);
                map.put(tempKey,anagramList);
            }else{
                map.get(tempKey).add(word);
            }
        }
    }

    private static String sortWord(String word){
        char[] temp = word.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    private static void printOutput(){
        for(String key : map.keySet()){
            ArrayList<String> anagrams = map.get(key);
            
            for(String anagram : anagrams){
                System.out.printf("%s ",anagram);
            }
            System.out.println();
        }
    }
}
