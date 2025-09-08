package Queue;

public class Queue<T> {
    QueueNode<T> head;
    QueueNode<T> tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void enqueue(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    public T dequeue() {
        if (head == null) {
            System.out.println("A fila está vazia");
            return null;
        }
        else{
            T data = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }
            return data;
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print(){
        QueueNode<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}