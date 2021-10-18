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
            System.out.println("Requests : \n
                                1 - Insertion and Display\n
                                2 - Delete a given key\n
                                3 - Delete at Position\n
                                4 - Delete entire list\n
                                5 - Print length of list\n
                                6 - Search an element in list\n
                                7 - Get n'th node in list\n
                                8 - Quit program
                                ");
            
            select = scanner.nextInt(); 
        }
        scanner.close();
    }

    private static void driver(int option , Scanner scan){
        switch(option){
            case 1 :  
                System.out.printf("Enter value to insert : ");
                insert(scan.nextInt());
                System.out.println()
                break;
            
            case 2 :
                System.out.printf("Enter value to delete : ");
                deleteNode(scan.nextInt());
                System.out.println()
                break;

            case 3 :
                System.out.printf("Delete value at position : ");
                deleteNodeAtPosition(scan.nextInt());
                System.out.println()
                break;

            case 4 :
                System.out.printf("Deleting entire list...");
                deleteList()
                System.out.printf("Delete completed");
                break;
            
            case 5 :
                System.out.printf("Length of list : %d\n",listLength());
                break;

            case 6 :
                System.out.printf("Search Element in list : ");
                searchKey(scan.nextInt())
                System.out.printf();
                break;

            case 7 :
                System.out.printf("Get n'th Node of list : ");
                getKeyAt(scan.nextInt())
                System.out.printf();
                break;

            case 8 :
                loop = false;
        }
    }

    private class Node{
        private int value = null;
        private int address = null;

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
        if(head!=null){
            Node temp = head;
            while(temp.address != null){
                count+=1;
                System.out.printf("Node %d: %d : %d",count,temp.value,temp.address);
            }
            System.out.println();
        }
    }

    private static void deleteNode(int key){
        Node temp = head;
        Node prevTemp = head;

        if(temp!=null){
            while(temp.address!=null){

                if(temp.value == key){
                    tempPrev.address = temp.address;
                    temp = null;
                    break;
                }

                prevTemp = temp;
                temp = temp.address;
            }
        }
    }

    private static int listLength(){
        Node temp = head;
        if(temp!=null){
            int count = 1
            while(temp.address!=null){
                count+=1;
                temp = temp.address;
            }
            return count;
        }else{
            return 0;
        }
    }

    private static int listLengthByRecursion(Node head,int count){
        Node temp = head;
        if(temp == null){
            return count;
        }
        count++;
        listLengthByRecursion(temp.address,count);
    }

    private static void deleteNodeAtPosition(int key){
        Node temp = head;
        Node prevTemp = head;
        if(temp!=null){
            int count = 0;
            while(count <= key && temp !=null){
                count+=1
                if(count==key){
                    prevTemp = temp.address;
                    temp = null;
                }
                prevTemp = temp;
                temp = temp.address;
            }

        }
    }

    private static void deleteList(){
        head = null;
    }
    
    private static int searchKey(int key){
        Node temp = head;
        int position = -1;
        if(temp!=null){
            int count = 1;

            if(temp.value == key){
                return count;
            }

            while(temp.address !=null){
                temp = temp.address;
                count++;
                if(temp.value == key){
                    return count;
                }
            }

            return position;
        }else{
            return position;
        }
    }

    private static Node searchKeyByRecursion(Node head,int key){
        Node temp = head; 
        if(temp.value == key){
            return temp;
        }
        if(temp.address !=null){
            searchKeyByRecursion(temp.address,key);
        }
    }

    private static int getKeyAt(int position){
        Node temp = head;
        count = 0
        while(temp!=null){
            count++
            if(count == position){
                return temp.value;
            }
            temp = temp.address;
        }
        return -1;
    }

}