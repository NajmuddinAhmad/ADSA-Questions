// LeetCode 622. Design Circular Queue
// Brief: Circular buffer queue with modular arithmetic for enqueue/dequeue.

class Queue {

    int front, rear, size;
    int capacity;
    int[] queue;

    Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = size = 0;
        rear = capacity - 1;
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
        System.out.println(item + " enqueued");
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(item + " dequeued");
    }

    int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[rear];
    }

    
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        return; 

    
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
        System.out.print(queue[(front + i) % capacity] + " ");
    }

        System.out.println();
    }
}

    
public class main1 {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.dequeue();
        q.display();

        System.out.println("Front element: " + q.front());
        System.out.println("Rear element: " + q.rear());
    }
}
