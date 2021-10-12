//Balanced Bracket
import java.util.Scanner;

public class W2D9P1 {
    
    private static String bracketSequence;
    private static Boolean balanced;

    public static void main(String[] args){
        takeInput();
        sequenceChecker();
        printOutput();
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bracket Sequence : ");
        bracketSequence = scanner.nextLine();
        scanner.close();
    }

    private static void sequenceChecker(){
        char[] tempStack = new char[bracketSequence.length()];
        int stackPointer = 0;

        for(int i=0;i<bracketSequence.length();i++){
            if(bracketSequence.charAt(i) == '{' ||
               bracketSequence.charAt(i) == '(' ||
               bracketSequence.charAt(i) == '[' 
            ){
                tempStack[stackPointer] = bracketSequence.charAt(i);
                stackPointer++;
            }else{
                if(bracketSequence.charAt(i) == '}' &&
                    tempStack[stackPointer-1] == '{'){
                        stackPointer--;
                }

                if(bracketSequence.charAt(i) == ')' &&
                    tempStack[stackPointer-1] == '('){
                        stackPointer--;
                }

                if(bracketSequence.charAt(i) == ']' &&
                    tempStack[stackPointer-1] == '['){
                        stackPointer--;
                }
            }
        }
        System.out.printf("Final Stackpointer location : %d\n",stackPointer);
        if(stackPointer == 0){
            balanced = true;
        }else{
            balanced = false;
        }
    }

    private static void printOutput(){
        if(balanced){
            System.out.println("Bracket Sequence is Balanced");
        }else{
            System.out.println("Bracket Sequence is not Balanced");
        }
    }
}
