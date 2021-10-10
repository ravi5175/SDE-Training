// Flood Fill Algorithm

import java.util.Scanner;

public class W1D7Q2 {

    private static int dimX;
    private static int dimY;

    private static int[][] pixels;

    private static int sr;
    private static int sc;
    private static int oldPixel;
    private static int newPixel;

    public static void main(String[] args){
        takeInput();

        oldPixel = pixels[sr][sc];
        floodPixels(sr, sc);
        printOutput();
    }

    public static void floodPixels(int row,int column){
        if(row > dimX-1 || row<0){
            return;
        }

        if(column <0 || column> dimY-1){
            return;
        }

        if(pixels[row][column] == oldPixel){
            pixels[row][column] = newPixel;
            floodPixels(row-1,column);
            floodPixels(row+1,column);
            floodPixels(row,column-1);
            floodPixels(row,column+1);
        }
    }

    public static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter dimension in x : ");
        dimX = scanner.nextInt();
        System.out.print("enter dimension in y : ");
        dimY = scanner.nextInt();
        System.out.println("feed pixel array ");
        pixels = new int[dimX][dimY];
        for(int i=0;i<dimX;i++){
            for(int j=0;j<dimY;j++){
                System.out.printf("Enter [%d,%d] pixel: ",i,j);
                pixels[i][j] = scanner.nextInt();
            }
        }
        System.out.print("enter sr : ");
        sr = scanner.nextInt();
        System.out.print("enter sc : ");
        sc = scanner.nextInt();
        System.out.print("enter replaced pixel value : ");
        newPixel = scanner.nextInt();
        scanner.close();
    }

    public static void printOutput(){
        for(int i = 0;i<dimX;i++){
            for(int j =0;j<dimY; j++){
                System.out.printf("%d ",pixels[i][j]);
            }
            System.out.println();
        }
    }
    
}
