package Graph;
public class QueueExample {
    int queues[];
    int front=-1;
    int rear=-1;
    int size;
    QueueExample(int size){
        this.size=size;
        queues=new int[size];

}

// capital class/ small function
public boolean enqueue(int data){
    if(isFull()){
        System.out.println("Queue overflow");
        return false;
    }
    if(front==-1){
        front=0;
    }
    queues[++rear]=data;
    return true;
}

public int dequeue(){
    if(isEmpty()){
        System.out.println("Queue underflow");
        return -999999;
    }
    int val=front;
    if(front==rear){
        front=rear=-1;
    }else{
        front++;
    }
    return queues[val];
}

public boolean isEmpty(){
    return front==-1;
}

public boolean isFull(){
    if(rear==size-1){
        return true;

    }
    return false;
 
}

public static void main(String[] args) {
    QueueExample q=new QueueExample(5);
    q.enqueue(10);
    q.enqueue(20);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());

}

}