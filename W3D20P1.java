public class W3D20P1 {
    public static void main(String[] args){
        int[] arr = {2,2,2,0,1};
        int leastElement = findLeastElement(arr);
        System.out.printf("Least Element : %d\n",leastElement);
    }

    private static int findLeastElement(int[] arr){
        int lIndex = 0;
        int rIndex=arr.length-1;
        while(lIndex<rIndex){
            int mIndex = (lIndex+rIndex)/2;
            int lValue = arr[lIndex];
            int rValue = arr[rIndex];
            int mValue = arr[mIndex];
            
            if(mValue==rValue){
                rIndex--;
            }
            else if(mValue>rValue){
                lIndex = mIndex+1;
            }else{
                rIndex = mIndex;
            }
        }
        return arr[rIndex];
    }
}
