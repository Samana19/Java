package Homework;

public class CircularImplementation {
    Node front;
    Node rear;

    int size;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public void enqueue(int data){
        Node newnode = new Node(data);
        if(front == null){
            newnode.next = newnode;
        }
        else{
            rear.next = newnode;
            rear = newnode;
            size++;
        }
        rear = newnode;
    }
    public int dequeue(){
        if(rear==null){
            System.out.println("Queue underflow");
        }
        int value = rear.next.data;
        if(rear.next == rear){
            rear = null;
        }
        else{
            rear.next = rear.next.next;
        }
        return value;
    }

    boolean isEmpty(){
        return size == 0;
    }
    public static void main(String[] args) {
        CircularImplementation C = new CircularImplementation();
        C.enqueue(10);
        C.enqueue(20);
        C.enqueue(30);
        System.out.println(C.dequeue());
    }
}
