// Stack using array

public class Stack {

    int maxSize;
    int[] arr;
    int top;

    public Stack(int size) {
        maxSize = size;
        arr = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }

    public void push(int data){
        if(top == maxSize - 1){
            System.out.println("Stack overflow : ");
            return;
        }
        top++;
        arr[top] = data;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow : ");
            return -1;
        }
        return arr[top--] ;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();

        stack.printStack();
    }
}