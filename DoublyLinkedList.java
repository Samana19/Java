public class DoublyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    Node head=null;
    Node tail=null;
    public void append(int data){
        Node newnode = new Node(data);

        if(head==null){
            head = newnode;
            tail = newnode;
        }
        else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }
    public void print(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList list= new DoublyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.print();
    }
}
