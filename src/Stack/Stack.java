package Stack;

public class Stack<T>{
    StackNode<T> head;

    public Stack() {
        head = null;
    }

    public void push(T value){
        StackNode<T> novoNode = new StackNode<>(value);

        novoNode.next = head;
        head = novoNode;

    }

    public T pop(){
        StackNode<T> novo = head;
        head = head.next;
        return novo.data;
    }

    public void clear(){
        while (head != null) {
            head = head.next;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void print(){
        if(head == null){
            System.out.println("A pilha está vazia");
        }
        StackNode<T> novo = head;

        while(novo != null){
            System.out.println(novo.data);
            novo = novo.next;
        }
    }

}