package data_structures;

public class DoublyLinkedList<T> {
    class Node{
        T data;
        Node next = null;
        Node prev = null;

        public Node(T data){
            this.data = data;
        }

        public Node(T data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int length = 0;

    public int length(){
        return length;
    }

    public Node head(){
        return head;
    }

    public Node tail(){
        return tail;
    }

    public void addStart(T element){
        if(length==0){
            head = tail = new Node(element);
        }else{
            head.prev = new Node(element, head, null);
            head = head.prev;
        }
        length++;
    }

    public void addEnd(T element){
        if(length==0){
            head = tail = new Node(element);
        }else{
            tail.next = new Node(element, null, tail);
            tail = tail.next;
        }
        length++;
    }

    public void insert(int index, T element){
        if(index>length) throw new IllegalArgumentException("cannot inser at index "+index+" if length of list is "+length);
        else if (index<0) throw new IllegalArgumentException("index shoud be positive integer");
        else if(index==0) addStart(element);
        else if(index==length) addEnd(element);
        else {
            if(index<=(length/2)+1){
                Node trav = head;
                for (int i = 0; i < index; i++) {
                    trav=trav.next;
                }
                Node node = new Node(element, trav, trav.prev);
                trav.prev.next = node;
                trav.prev = node;
                length++;
            }else{
                Node trav = tail;
                for (int i = length-1; i < index; i--) {
                    trav=trav.prev;
                }
                Node node = new Node(element, trav, trav.prev);
                trav.prev.next = node;
                trav.prev = node;
                length++;
            }
        }
    }

    public T removeStart(){
        if(length==0) throw new RuntimeException("Empty list");
        T data = head.data;
        head=head.next;
        if(head!=null){
            head.prev = null;
        }
        length--;
        if(length==0) tail = null;
        return data;
    }

    public T removeEnd(){
        if(length==0) throw new RuntimeException("Empty list");
        T data = tail.data;
        tail=tail.prev;
        if(tail!=null){
            tail.next = null;
        }
        length--;
        if(length==0) head = null;
        return data;
    }

    public T removeAt(int index){
        if(index>=length) throw new IndexOutOfBoundsException(index);
        if(index==0) return removeStart();
        if(index==length-1) return removeEnd();
        Node trav;
        T data;
        if(index<(length/2)+1){
            trav = head;
            for(int i=0; i<index;i++){
                trav=trav.next;
            }
            data = trav.data;
        }else{
            trav = tail;
            for(int i=length-1; i>index; i--){
                trav=trav.prev;
            }
            data = trav.data;
        }
        trav.prev.next = trav.next;
        trav.next.prev = trav.prev;
        length--;
        return data;
    }

    public void clear(){
        int l = length;
        for (int i = 0; i < l; i++) {
            removeStart();
        }
    }

    public void display(){
        Node trav = head;
        while (trav != null) {
            System.out.print(trav.data+", ");
            trav = trav.next;
        }
        System.out.println();
    }

    public void displayReverse(){
        Node trav = tail;
        while (trav != null) {
            System.out.print(trav.data+", ");
            trav = trav.prev;
        }
        System.out.println();
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
}
