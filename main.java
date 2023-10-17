import data_structures.DoublyLinkedList;

class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.addStart(9);
        list.addStart(5);
        list.addStart(6);
        list.addEnd(4);
        list.addEnd(3);
        list.insert(5, 8);
        list.clear();
        list.display();
        list.displayReverse();
        System.out.println(list.length());
    }
}
