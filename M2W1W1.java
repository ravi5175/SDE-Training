public class M2W1W1 {
    
    private static int maxCount = 0;
    
    private static int a = 12;
    private static int b = 9;
    private static int c = 11;
    private static int totalLength = 23;

    public static void main(String[] args){
        
        cutCount(totalLength,c,0);
        cutCount(totalLength,a,0);
        cutCount(totalLength,b,0);
        

        System.out.printf("Max cut possible %d",maxCount);
    }

    private static void cutCount(int remLength,int cut,int maxCut){

        if(remLength == 0){
            if(maxCut>maxCount){
                maxCount = maxCut;
                return;
            }
        }

        if(remLength>=cut){
            remLength = remLength - cut;
            maxCut = maxCut + 1;

            cutCount(remLength,a,maxCut);
            cutCount(remLength,b,maxCut);
            cutCount(remLength,c,maxCut);
            
        }
    }
}
