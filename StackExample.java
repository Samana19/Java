public class StackExample {

    char stk[];

    int top = -1;

    int size;

    StackExample(int size){

        stk = new char[size];

        this.size=size;

    }

   

    public boolean push(char data){

        if(isFull()){

            System.out.println("stack overflow");

            return false;

        }

        // top++; or

        stk[++top]=data;

        return true;

    }



    public char pop(){

        if(isEmpty()){

            System.out.println("stack underflow");

            return 'f';

        }

        return stk[top--];

    }





    public boolean isEmpty(){



        return top == -1;

    }

   

    public boolean isFull(){

       

        return top== size-1;

    }

}