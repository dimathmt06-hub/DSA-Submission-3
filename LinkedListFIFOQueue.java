public class LinkedListFIFOQueue {
    
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node front = null;
    private Node rear = null;
    private int size = 0;
    
    public void enqueue(int data) {
        Node newNode = new Node(data);
        
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;  
            rear = newNode;       
        }
        size++;
        System.out.println("Enqueued: " + data);
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int value = front.data;
        front = front.next;  
        
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot peek.");
            return -1;
        }
        return front.data;
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front -> rear): ");
        Node current = front;
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
        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();
        
        System.out.println("=== Linked List FIFO Queue Demo ===\n");
        
        System.out.println("--- Enqueue Operations ---");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        System.out.println();
        queue.display();
        System.out.println("Size: " + queue.size());
        System.out.println("Front element (peek): " + queue.peek());
        
        System.out.println("\n--- Dequeue Operations ---");
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        
        System.out.println();
        queue.display();
        System.out.println("Size: " + queue.size());
        System.out.println("Front element (peek): " + queue.peek());
        
        System.out.println("\n--- Enqueue More ---");
        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();
        
        System.out.println("\n--- Check Empty ---");
        System.out.println("Is queue empty? " + queue.isEmpty());
        
        System.out.println("\n--- Dequeue All Elements ---");
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        
        System.out.println();
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
        
        System.out.println("\n--- Dequeue on Empty Queue ---");
        System.out.println("Dequeued: " + queue.dequeue());
    }
}