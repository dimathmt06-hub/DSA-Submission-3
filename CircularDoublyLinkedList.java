public class CircularDoublyLinkedList {
    
     static class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    
    public void add(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;  
            newNode.prev = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;    
            head.prev = newNode;    
            tail = newNode;         
        }
        size++;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }
    
    public boolean remove(int data) {
        if (head == null) {
            return false;
        }
        
        Node current = head;
        
        do {
            if (current.data == data) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } 
                else if (current == head) {
                    head = head.next;
                    head.prev = tail;
                    tail.next = head;
                }
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = head;
                    head.prev = tail;
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        } while (current != head);
        
        return false;
    }
    
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        System.out.print("Forward: ");
        Node current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }
    
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        
        System.out.print("Backward: ");
        Node current = tail;
        do {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        } while (current != tail);
        System.out.println("(back to tail)");
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        
        System.out.println("=== Circular Doubly Linked List Demo ===\n");
        
        System.out.println("Adding elements: 10, 20, 30, 40");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        
        list.displayForward();
        list.displayBackward();
        System.out.println("Size: " + list.size() + "\n");
        
        System.out.println("Adding 5 at the beginning");
        list.addFirst(5);
        list.displayForward();
        list.displayBackward();
        System.out.println("Size: " + list.size() + "\n");
        
        System.out.println("Removing 30");
        list.remove(30);
        list.displayForward();
        list.displayBackward();
        System.out.println("Size: " + list.size() + "\n");
        
        System.out.println("Removing 5 (head)");
        list.remove(5);
        list.displayForward();
        System.out.println("Size: " + list.size() + "\n");
        
        System.out.println("Removing 40 (tail)");
        list.remove(40);
        list.displayForward();
        list.displayBackward();
        System.out.println("Size: " + list.size() + "\n");
    }
}