package Graph;

public class LinkedList {
    public static class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }

    }
    Node head=null;
    Node tail=null;
    int size=0;

    public void addNode(int data){
        size++;
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        

    }
    public int getSize(){
        return size;
    }

    public int getDataAtAnyPos(int pos){
        Node current= head;
        for(int i=1; i<pos; i++){
            current= current.next;
        }
        return current.data;

    }
    
}
