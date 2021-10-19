import java.util.Scanner;

class W3D15P1{

    private static Node head = null;
    private static boolean loop = true;

    public static void main(String[] args){
        takeInput();
    }

    private static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        while(loop){
            System.out.println(
                "Requests :\n"+
                "1 - Insertion and Display\n"+
                "2 - Delete a given key\n"+
                "3 - Delete at Position\n"+
                "4 - Delete entire list\n"+
                "5 - Print length of list (Itterative)\n"+
                "6 - Print length of list (Recursion)\n"+
                "7 - Search an element in list (Itterative\n"+
                "8 - Search an element in list (Recursive)\n"+
                "9 - Get n'th node in list\n"+
                "0 - Quit program\n");
            select = scanner.nextInt();
            driver(select,scanner);
        }
        scanner.close();
    }

    private static void driver(int option , Scanner scan){
        switch(option){
            case 1 :  
                System.out.printf("Enter value to insert : ");
                insert(scan.nextInt());
                System.out.println();
                break;
            
            case 2 :
                System.out.printf("Enter value to delete : ");
                deleteNode(scan.nextInt());
                System.out.println();
                break;

            case 3 :
                System.out.printf("Delete value at position : ");
                deleteNodeAtPosition(scan.nextInt());
                System.out.println();
                break;

            case 4 :
                System.out.println("Deleting entire list...");
                deleteList();
                System.out.println("Delete completed");
                break;
            
            case 5 :
                System.out.printf("Length of list : %d\n",listLength());
                break;

            case 6 :
                Node temp = head;
                System.out.printf("Length of list : %d\n",listLengthByRecursion(temp));
                break;

            case 7 :
                System.out.printf("Search Element in list : ");
                int position = searchKey(scan.nextInt());
                System.out.println();
                if(position == -1){
                    System.out.println("Element not found");
                }else{
                    System.out.println("Element Found at : "+position);
                }
                break;
            
            case 8 :
                System.out.printf("Search Element in list : ");
                Node tem = head;
                int pos = searchKeyByRecursion(tem,scan.nextInt(),1);
                System.out.println();
                if(pos == -1){
                    System.out.println("Element not found");
                }else{
                    System.out.println("Element Found at : "+pos);
                }
                break;

            case 9 :
                System.out.printf("Get n'th Node of list : ");
                int p = getKeyAt(scan.nextInt());
                System.out.println();
                if(p == -1){
                    System.out.println("Position out of bound");
                }else{
                    System.out.printf("Value at position is : %d \n",p);
                }
                break;

            case 0 :
                loop = false;
        }
    }

    static class Node{
        private int value;
        private Node address = null;

        Node(int value){
            this.value = value;
        }
    }

    private static Node traverseList(){
        Node temp = head;
        while(temp.address != null){
            temp = temp.address;
        }
        return temp;
    }

    private static void insert(int key){
        Node node = new Node(key);
        if(head != null){
            Node temp = traverseList();
            temp.address = node;
        }else{
            head = node;
        }

        displayList();
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
            temp = temp.address;
        }
    }

    private static void deleteNode(int key){
        Node temp = head;
        Node prevTemp = head;

        if(temp==null){
            return;
        }

        if(temp.value == key){
            head = temp.address;
            displayList();
            return;
        }

        while(temp!=null){
            if(temp.value == key){
                prevTemp.address = temp.address;
                temp = null;
                break;
            }
            prevTemp = temp;
            temp = temp.address;
        }
        displayList();
    }

    private static int listLength(){
        Node temp = head;
        if(temp!=null){
            int count = 1;
            while(temp.address!=null){
                count+=1;
                temp = temp.address;
            }
            return count;
        }else{
            return 0;
        }
    }

    private static int listLengthByRecursion(Node temp){
        if(temp == null){
            return 0;
        }else{
            return 1 + listLengthByRecursion(temp.address);
        }
    }

    private static void deleteNodeAtPosition(int position){
        Node temp = head;
        Node prevTemp = head;

        if(temp == null){
            return;
        }

        if(position == 1){
            head = head.address;
            displayList();
        }

        int count = 1;
        while(count <= position && temp != null){
            prevTemp = temp;
            temp = temp.address;
            count+=1;
            if(count==position){
                prevTemp.address = temp.address;
                temp = null;
                displayList();
                return;
            }
        }
    }

    private static void deleteList(){
        head = null;
    }
    
    private static int searchKey(int key){
        Node temp = head;
        int position = -1;
        int count = 0;
        while(temp!=null){
            count++;
            if(temp.value == key){
                return count;
            }
            temp = temp.address;
        }
        return position;
    }

    private static int searchKeyByRecursion(Node node,int key,int offset){
        if(node == null){
            return -1;
        }
        
        if(node.value == key){
            return offset;
        }
        
        offset = searchKeyByRecursion(node.address,key,offset+1);
        return offset;
    }

    private static int getKeyAt(int position){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            if(count == position){
                return temp.value;
            }
            temp = temp.address;
        }
        return -1;
    }

}