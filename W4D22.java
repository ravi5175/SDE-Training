import java.util.Scanner;

class W4D22{

    private static boolean loop = true;

    private static int[] stack;
    private static int stackBottomPointer;
    private static int stackTopPointer;

    private static int[] queue;
    private static int queueFrontPointer;
    private static int queueBackPointer;

    private static Scanner scanner;


    public static void main(String[] args){

        scanner = new Scanner(System.in);
        System.out.println("Enter Size of Stack : ");
        stack = new int[scanner.nextInt()];
        stackBottomPointer = 0;
        stackTopPointer = 0;

        System.out.println("Enter Size of Queue : ");
        queue = new int[scanner.nextInt()];

        queueFrontPointer = 0;
        queueBackPointer = 0;

        String menu = """
        Select Operation - 
        1 - insert into stack
        2 - remove from stack
        3 - insert into queue
        4 - remove from queue 
        5 - display stack
        6 - display queue
        0 - quit
        """;

        while(loop){
            System.out.println(menu);
            int userInput = scanner.nextInt();
            switch(userInput){
                case 0 : 
                    loop = false;
                    break;
                
                case 1 :
                    insertIntoStack();
                    break;
                
                case 2 :
                    removeFromStack();
                    break;
                
                case 3 :
                    insertIntoQueue();
                    break;
                
                case 4 :
                    removeFromQueue();
                    break;

                case 5 :
                    displayStack();
                    break;

                case 6 :
                    displayQueue();
                    break;
            }

        }
        scanner.close();

    }


    private static void insertIntoStack(){
        if (stackTopPointer == stack.length) {
            System.out.println("Stack full, remove element first.");
            return;
        }

        stack[stackTopPointer] = scanner.nextInt();
        stackTopPointer+=1;
        return;
    }

    private static void removeFromStack(){
        if (stackTopPointer == 0) {
            System.out.println("Stack already empty, enter element first.");
            return;
        }
        stackTopPointer-=1;
        return;
    }

    private static void insertIntoQueue(){
        if (queueBackPointer == queue.length) {
            System.out.println("Queue full, remove element first.");
            return;
        }

        queue[queueBackPointer] = scanner.nextInt();
        queueBackPointer+=1;
        return;
    }

    private static void removeFromQueue(){
        if (queueBackPointer == 0) {
            System.out.println("Stack already empty, enter element first.");
            return;
        }

        for(int i =0 ;i<queueBackPointer-1;i++){
            queue[i] = queue[i+1];
        }
        queueBackPointer-=1;
        return;
    }

    private static void displayStack(){
        System.out.printf("Stack : ");
        for(int i =0;i<stackTopPointer;i++){
            System.out.printf("%d ",stack[i]);
        }
        System.out.println();
    }

    private static void displayQueue(){
        System.out.printf("Queue : ");
        for(int i =0;i<queueBackPointer;i++){
            System.out.printf("%d ",queue[i]);
        }
        System.out.println();
    }





}