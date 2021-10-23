public class W3D18 {

    private static Node head;
    private static Node loopStart;
    private static int loopNodeIndex = 0;
    private static int tailLength = 0;
    public static void main(String[] args){
        createCircularLinkedList();

        //Loop Detection
        // if(detectLoop()){
        //     System.out.println("Loop Detected");
        //     System.out.printf("Loop Started at  : %d \n",loopStart.key);
        // }else{
        //     System.out.println("No Loop Detected");
        // }

        //Increment Integer
        createLinkedList123();
        printLinkedList();
        addOneToLinkedList();

        createLinkedList0();
        printLinkedList();
        addOneToLinkedList();
    }

    static class Node{
        int key;
        Node next;

        Node(int value, Node node){
            this.key = value;
            this.next = node;
        }

        Node(int value){
            this.key = value;
            this.next = null;
        }
    }

    private static Boolean detectLoop(){
        Node slowPointer = head, fastPointer = head;
        while(slowPointer!= null && fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
                slowPointer = head;
                detectLoopStartingPoint(slowPointer, fastPointer);
                return true;
            }
        }
        return false;
    }

    private static void detectLoopStartingPoint(Node slowPointer,Node fastPointer){
        while(slowPointer!=fastPointer){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        loopStart = slowPointer;
    }

    private static void addOneToLinkedList(){
        reverseLinkedList();
        Node temp = head;
        while(temp!=null){
            if(temp.key<9){
                temp.key = temp.key+1;
                reverseLinkedList();
                return;
            }

            if(temp.key == 9){
                temp.key = 0;
                temp = temp.next;
            }
        }
    }

    private static void createCircularLinkedList(){
        Node node1 = new Node(10);
        Node node2 = new Node(20,node1);
        Node node3 = new Node(30,node2);
        Node node4 = new Node(40,node3);
        Node node5 = new Node(50,node4);
        Node node6 = new Node(60,node5);
        Node node7 = new Node(70,node6);
        Node node8 = new Node(80,node7);
        node1.next = node8;
        head = node8;
    }

    private static void createLinkedList123(){
        Node node11 = new Node(3);
        Node node12 = new Node(2,node11);
        Node node13 = new Node(1,node12);
        head = node13;
    }

    private static void createLinkedList0(){
        Node node14 = new Node(0);
        head = node14;
    }

    private static void reverseLinkedList(){
        Node curr = head, prev = null;

        if(curr == null){
            return; 
        }

        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        printLinkedList();
    }

    private static void printLinkedList(){
        Node temp = head;
        if(temp == null){
            return;
        }

        while(true){
            if(temp.next!=null){
                System.out.printf("%d->",temp.key);
            }else{
                System.out.printf("%d",temp.key);
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
