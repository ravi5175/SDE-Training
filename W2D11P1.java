import java.util.Scanner;

public class W2D11P1 {
    
    private static int arraySize;
    private static String[] array;

    private static int maxWidth;

    private static int startPointer;
    private static int endPointer;
    private static int characterCount;
    
    public static void main(String[] args){
        takeInput();
        stringJustification();
    }

    private static void stringJustification(){
        
        startPointer = 0;
        endPointer = 0;
        characterCount = 0;

        for(int i = 0;i<arraySize;i++){
            if(characterCount + array[i].length()>maxWidth){
                justify(false);
                startPointer = endPointer+1;
                endPointer = i;
                characterCount = array[i].length()+1;
            }else{
                characterCount += array[i].length()+1;
                endPointer = i;
            }

            if(i == arraySize-1){
                justify(true);
            }
        }
    }

    private static void justify(Boolean last){
        int wordCount = endPointer - startPointer + 1;
        //System.out.println("WordCount : "+wordCount);
        //System.out.println("charcterCount : "+characterCount);
        //System.out.println("SpaceCount : "+spaceCount);
        if(wordCount >1){
            int spaceCount =  maxWidth - characterCount +1 +(wordCount-1);
            int spaceDistribution = spaceCount/(wordCount-1);
            int spaceAlpha = spaceCount%(wordCount-1);

            
            String spaceStringAlpha = spaceString(spaceDistribution+spaceAlpha);
            String spaceStringBeta = spaceString(spaceDistribution);

            if(last){
                spaceStringAlpha = " ";
            }

            String result = "";
            for(int i = startPointer;i<=endPointer;i++){
                if(i == startPointer){
                    result = array[startPointer]+spaceStringAlpha;
                }else if(i == endPointer){
                    result += array[i];
                }else{
                    result += array[i]+spaceStringBeta;
                }
            }

            if(last){
                System.out.println("\""+result+spaceString(maxWidth-result.length())+"\"");
            }else{
                System.out.println("\""+result+"\"");
            }
            
        }else{
            System.out.println("\""+array[endPointer]+spaceString(maxWidth-array[endPointer].length())+"\"");
        }
        
        //System.out.println("SpaceDistribution : "+spaceDistribution);
        
        //System.out.println("SpaceDistributionAlpha : "+spaceAlpha);

    }

    private static String spaceString(int spaceCount){
        String space = " ";
        for(int i =0 ;i<spaceCount-1;i++){
            space+=" ";
        }
        return space;
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Word Count : ");
        
        arraySize = scanner.nextInt();
        array = new String[arraySize];
        
        scanner.nextLine();
        for(int i =0 ;i<arraySize;i++){
            System.out.printf("Enter string[%d] : ",i);
            array[i] = scanner.nextLine();
        }

        System.out.print("Enter Maximum Width : ");
        maxWidth = scanner.nextInt();
        scanner.close();
    }
}
