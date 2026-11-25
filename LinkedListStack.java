public class LinkedListStack {
    
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top = null;
    private int size = 0;
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;  
        top = newNode;      
        size++;
        System.out.println("Pushed: " + data);
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        }
        int value = top.data;
        top = top.next; 
        size--;
        return value;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return -1;
        }
        return top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top -> bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        
        System.out.println("=== Linked List Stack Demo ===\n");
        
        System.out.println("--- Push Operations ---");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        System.out.println();
        stack.display();
        System.out.println("Size: " + stack.size());
        System.out.println("Top element (peek): " + stack.peek());
        
        System.out.println("\n--- Pop Operations ---");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        
        System.out.println();
        stack.display();
        System.out.println("Size: " + stack.size());
        System.out.println("Top element (peek): " + stack.peek());
        
        System.out.println("\n--- Check Empty ---");
        System.out.println("Is stack empty? " + stack.isEmpty());
        
        System.out.println("\n--- Pop All Elements ---");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        
        System.out.println();
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Size: " + stack.size());
        
        System.out.println("\n--- Pop on Empty Stack ---");
        System.out.println("Popped: " + stack.pop());
    }
}