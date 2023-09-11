package data_structures;

public class LinkedList<T> {
    class Node{
        T data;
        Node next = null;

        public Node(T data){
            this.data = data;
        }

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    Node head = null;
    int length = 0;

    public void append(T value){
        if(head==null) head = new Node(value);
        else{
            Node trav = head;
            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = new Node(value);
        }
        length++;
    }

    public void insert(int index, T value){
        if(index == 0){
            head = new Node(value, head);
        }else if(index<length && index > 0){
            Node trav = head;
            for (int i = 0; i < index-1; i++) {
                trav = trav.next;
            }
            trav.next = new Node(value, trav.next);
            length++;
        }else throw new IllegalArgumentException("Enter a valid index, cannot insert at: "+index);
    }

    public String toString(){
        StringBuilder str = new StringBuilder("[");
        Node trav = head;
        while (trav != null) {
            str.append(trav.data+", ");
            trav = trav.next;
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        System.out.println(list);
        list.insert(0, 0);
        System.out.println(list);
        System.out.println(list.length);
    }
}
