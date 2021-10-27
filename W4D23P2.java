import java.lang.Math;

public class W4D23P2 {
    public static void main(String[] args){
        int[] test = {1,-5,-20,4,-1,3,-6,-3};
        int k = 2;
        int sum = 0;
        int i =0;
        while(i<test.length){
            System.out.printf("%d : %d\n",i,test[i]);
            sum = sum+test[i];
            if(i!=test.length-1){
                int max = test[i+1];
                int index = i+1;
                for(int j = i+1; j<= i+k ;j++){
                    if(j<test.length){
                        if(test[j]>max){
                            max = test[j];
                            index = j;
                        }
                    }
                }
                i = index;
            }else{
                break;
            }
        }
        System.out.printf("Sum  : %d\n",sum);
    }    
}
