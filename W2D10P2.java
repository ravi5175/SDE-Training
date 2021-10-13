import java.util.Scanner;

public class W2D10P2 {


    private static int rows;
    private static int columns;

    private static int[][] matrix ;

    private static int topBound;
    private static int bottomBound;
    private static int leftBound;
    private static int rightBound;

    private static int direction;

    public static void main(String[] args){
        
        takeInput();

        topBound = 0;
        bottomBound = rows-1;
        leftBound = 0;
        rightBound = columns-1;

        direction = 0;
        
        spiralTraversal();

        
    }

    private static void spiralTraversal(){
        
        while(topBound <= bottomBound && leftBound <= rightBound){
            switch (direction){
                case 0:
                    // Left to Right
                    for(int i=leftBound;i<=rightBound;i++){
                        System.out.print(matrix[topBound][i]+", ");
                    }
                    topBound+=1;
                    ;break;
                case 1:
                    //Top to Bottom
                    for(int i=topBound;i<=bottomBound;i++){
                        System.out.print(matrix[i][rightBound]+", ");
                    }
                    rightBound-=1;
                    ;break;
                case 2:
                    // Right to Left
                    for(int i=rightBound;i>=leftBound;i--){
                        System.out.print(matrix[bottomBound][i]+", ");
                    }
                    bottomBound-=1;
                    ;break;
                case 3:
                    // Bottom to Top
                    for(int i=bottomBound;i>=topBound;i--){
                        System.out.print(matrix[i][leftBound]+", ");
                    }
                    leftBound+=1;
                    ;break;
            } 

            direction = (direction+1)%4;
        }
        System.out.println();
    }
    
    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter dimension in x : ");
        rows = scanner.nextInt();
        System.out.print("enter dimension in y : ");
        columns = scanner.nextInt();
        System.out.println("feed array ");
        
        matrix = new int[rows][columns];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.printf("Enter [%d,%d] pixel: ",i,j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }
}
