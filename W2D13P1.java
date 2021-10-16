import java.util.Scanner;

public class W2D13P1 {

    private static String s1;
    private static String s2;
    private static String s3;

    private static Boolean isStringInterleaving = true;
    
    public static void main(String[] args){
        takeInput();
        stringInterleaving();
        printOutput();
        
    }
    

    private static void stringInterleaving(){
        int s3Length = s3.length();

        int currentString = 1;
        int s1Pointer = 0;
        int s2Pointer = 0;

        for(int i =0;i<s3Length;i++){
            if(currentString == 1){
                if(s1Pointer<s1.length()){
                    if(s1.charAt(s1Pointer)!=s3.charAt(i)){
                        if(s2.charAt(s2Pointer) == s3.charAt(i)){
                            currentString = 2;
                            s2Pointer++;
                        }else{
                            isStringInterleaving = false;
                            return;
                        }
                    }else{
                        s1Pointer++;
                    }
                }else{
                    if(s1.charAt(s1Pointer) == s3.charAt(i)){
                        currentString = 1;
                        s1Pointer++;
                    }else{
                        isStringInterleaving = false;
                        return;
                    }
                }
                
            }else{
                if(s2Pointer<s2.length()){
                    if(s2.charAt(s2Pointer)!=s3.charAt(i)){
                        if(s1.charAt(s1Pointer) == s3.charAt(i)){
                            currentString = 1;
                            s1Pointer++;
                            System.out.printf("string switched at : %d",i);
                        }else{
                            isStringInterleaving = false;
                            return;
                        }
                    }else{
                        s2Pointer++; 
                    }
                }else{
                    if(s1.charAt(s1Pointer) == s3.charAt(i)){
                        currentString = 1;
                        s1Pointer++;
                        System.out.printf("string switched at : %d",i);
                    }else{
                        isStringInterleaving = false;
                        return;
                    }
                }
                
                
            }
        }
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String S1 : ");
        s1 = scanner.nextLine();
        System.out.println("Enter String S2 : ");
        s2 = scanner.nextLine();
        System.out.println("Enter String S3 : ");
        s3 = scanner.nextLine();
        scanner.close();
    }

    private static void printOutput(){
        if(isStringInterleaving){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
    }
}
