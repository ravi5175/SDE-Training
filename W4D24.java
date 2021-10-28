//Implementing Stack with Double Queue
class MyStack {
    
    Queue<Integer> L1;
    Queue<Integer> L2;
    
    public MyStack() {
        this.L1 = new LinkedList();
        this.L2 = new LinkedList();
    }
    
    public void push(int x) {
        this.L1.add(x);
        while(!this.L2.isEmpty()){
            L1.add(L2.element());
            L2.remove();
        }
        while(!this.L1.isEmpty()){
            L2.add(L1.element());
            L1.remove();
        }
    }
    
    public int pop() {
        int element = this.L2.element();
        this.L2.remove();
        return element ;
    }
    
    public int top() {
        return this.L2.element();
    }
    
    public boolean empty() {
        return this.L2.isEmpty();
    }
} 