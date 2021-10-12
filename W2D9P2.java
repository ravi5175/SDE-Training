// Matrix minimum sum traversal;

import java.util.Scanner;

public class W2D9P2 {

    private static int rows;
    private static int columns;

    private static int[][] matrix ;
    private static int sum = Integer.MAX_VALUE;

    public static void main(String[] args){
        takeInput();
        traverseMatrix(0,0,0);
        printOutput();
    }

    public static void traverseMatrix(int row,int column, int total){

        if(row > rows-1 || row<0){
            return;
        }

        if(column <0 || column> columns-1){
            return;
        }

        total = total + matrix[row][column];

        if(row == rows-1 && column == columns-1){
            if(total<sum){
                sum = total;
                return;
            }
        }

        traverseMatrix(row+1, column, total);
        traverseMatrix(row, column+1, total);
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter dimension in x : ");
        rows = scanner.nextInt();
        System.out.print("enter dimension in y : ");
        columns = scanner.nextInt();
        System.out.println("feed pixel array ");
        
        matrix = new int[rows][columns];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.printf("Enter [%d,%d] pixel: ",i,j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
    }

    private static void printOutput(){
        System.out.printf("Minimum Sum : %d\n",sum);
    }

}
