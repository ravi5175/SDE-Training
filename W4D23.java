public class W4D23 {

    private static Node head1 = null;
    private static Node head2 = null;

    public static void main(String[] args){
        createLinkedList();
        breakListToHalf();
        reverseLinkedList();
        mergeList();
        displayList();
    }


    static class Node{
        int key;
        Node next = null;

        Node(int value){
            this.key = value;
        }

        Node(int value,Node next){
            this.key = value;
            this.next = next;
        }
    }

    private static void breakListToHalf(){
        Node prev = null;
        Node slowPointer = head1;
        Node fastPointer = head1;
        while(fastPointer!=null && fastPointer.next!=null){
            prev = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        if(fastPointer!=null){
            head2 = slowPointer.next;
            slowPointer.next = null;
        }else{
            head2 = slowPointer;
            prev.next = null;
        }
        System.out.println("Mid Point : "+ head2.key);
    }

    private static void reverseLinkedList(){
        Node prev = null;
        Node curr = head2;

        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head2 = prev;
    }

    private static void mergeList(){
        Node tCurr1 = head1;
        Node tCurr2 = head2;

        while(tCurr1!=null && tCurr2!=null){
            Node tTemp1 = tCurr1.next;
            Node tTemp2 = tCurr2.next;
            tCurr1.next = tCurr2;
            tCurr2.next = tTemp1;
            tCurr1 = tTemp1;
            tCurr2 = tTemp2;
        }
    }

    private static void displayList(){
        Node temp = head1;
        while(temp!=null){
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

    private static void createLinkedList(){
        Node node1 = new Node(10);
        Node node2 = new Node(20,node1);
        Node node3 = new Node(30,node2);
        Node node4 = new Node(40,node3);
        Node node5 = new Node(50,node4);
        Node node6 = new Node(60,node5);
        Node node7 = new Node(70,node6);
        Node node8 = new Node(80,node7);
        head1 = node8;
    }
}
