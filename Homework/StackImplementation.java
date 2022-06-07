package Homework;

public class StackImplementation {
    Node head;
    int size;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
        }
        int finalvalue = head.data;
        head = head.next;
        size--;
        return finalvalue;
    }
    
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack underflow");
        }
        return head.data;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void print(){
        Node curret = head;
        while(curret != null){
            System.out.println(curret.data);
            curret = curret.next;
        }
    }
}
