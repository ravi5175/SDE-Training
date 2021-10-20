//Reverse linked list between a and b

import java.util.Scanner;

public class W3D16P1 {
    
    private static Node head = null;
    private static int lBound;
    private static int uBound;

    public static void main(String[] args){
        takeInput();
        controlledReverse();

        System.out.println("\n Reversed List");
        displayList();
    }

    private static class Node{
        int value;
        Node next = null;

        Node(int value){
            this.value = value;
        }
    }
    private static void takeInput(){
        System.out.println("Create a linked list -");
        System.out.println("Enter No. of Nodes Required -");
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        for(int i = 0;i<nodes;i++){
            insert(i);
        }
        System.out.print("Enter lower bound [0<lBound<listLength] : ");
        lBound = scanner.nextInt();

        System.out.print("Enter upper bound [lowerBound<uBound<listLength] : ");
        uBound = scanner.nextInt();

        scanner.close();
        displayList();
    }

    private static void insert(int key){
        Node node = new Node(key);
        if(head != null){
            Node temp = traverseList();
            temp.next = node;
        }else{
            head = node;
        }
    }

    private static Node traverseList(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    private static void displayList(){
        int count = 0;
        Node temp = head;

        if(temp==null){
            System.out.println("List is Empty");
        }

        while(temp!=null){
            count+=1;
            System.out.printf("Node %d: %d\n",count,temp.value);
            temp = temp.next;
        }
    }

    private static void controlledReverse(){
        Node current = head;
        Node prev = null;

        int count = 1;

        Node set1 = null;
        Node set2 = null;
        Node set3 = null;
        Node set4 = null;

        while(current!=null){
            if(count >= lBound && count<=uBound){
                if(count == lBound){
                    set1 = prev;
                    set2 = current;
                }

                if(count == uBound){
                    set3 = current;
                    set4 = current.next;
                }

                Node temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                count+=1;
            }else{
                prev = current;
                current = current.next;
                count+=1;
            }
        }

        set2.next = set4;
        if(set1 != null){
            set1.next = set3;
        }else{
            head = set3;
        }
        
    }
}
