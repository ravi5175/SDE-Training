// Detect cycle in linked list

import java.util.HashSet;

public class W3D17P1 {

    private static Node head = null;
    
    public static void main(String[] args){
        
        if(testCall(1)){
            System.out.println("Cycle exist in 1st test case");
        }else{
            System.out.println("Cycle not exist in 1st test case");
        }

        if(testCall(2)){
            System.out.println("Cycle exist in 2nd test case");
        }else{
            System.out.println("Cycle not exist in 2nd test case");
        }

        if(testCall(3)){
            System.out.println("Cycle exist in 3rd test case");
        }else{
            System.out.println("Cycle not exist in 3rd test case");
        }

    }

    private static Boolean testCall(int testNumber){
        
        Node temp;
        HashSet<Node> set = new HashSet<Node>();

        switch (testNumber){
            case 1 :
                testCase1();
                temp = head;
                while(temp != null){
                    if(set.contains(temp)){
                        return true;
                    }else{
                        set.add(temp);
                    }
                    temp = temp.next;
                }
                return false;
            
            case 2 :  
                testCase2();
                temp = head;
                while(temp != null){
                    if(set.contains(temp)){
                        return true;
                    }else{
                        set.add(temp);
                    }
                    temp = temp.next;
                }
                return false;
            
            case 3 :  
                testCase3();
                temp = head;
                while(temp != null){
                    if(set.contains(temp)){
                        return true;
                    }else{
                        set.add(temp);
                    }
                    temp = temp.next;
                }
                return false;
        }
        return false;
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

    private static void testCase1(){
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

    private static void testCase2(){
        Node node1 = new Node(10);
        Node node2 = new Node(20,node1);
        Node node3 = new Node(30,node2);
        Node node4 = new Node(40,node3);
        Node node5 = new Node(50,node4);
        Node node6 = new Node(60,node5);
        Node node7 = new Node(70,node6);
        Node node8 = new Node(80,node7);
        head = node8;
    }

    private static void testCase3(){
        Node node1 = new Node(10);
        Node node2 = new Node(20,node1);
        Node node3 = new Node(30,node2);
        Node node4 = new Node(40,node3);
        Node node5 = new Node(50,node4);
        Node node6 = new Node(60,node5);
        Node node7 = new Node(70,node6);
        Node node8 = new Node(80,node7);
        node1.next = node4;
        head = node8;
    }


}
