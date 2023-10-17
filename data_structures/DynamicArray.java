package data_structures;
import java.util.Iterator;
@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T>{

    private T[] arr;
    private int length = 0;
    private int capacity = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index=0;
            public boolean hasNext(){ return index<length;}
            public T next(){ return arr[index++];}
        };
    }

    @Override
    public String toString(){
        if(length==0) return "[]";
        StringBuilder result = new StringBuilder("[");
        for (int i=0; i<length; i++) {
            result.append(arr[i]+", ");
        }
        result.append("]");
        return result.toString();
    }

    DynamicArray(int capacity){
        if (capacity<0){
            throw new IllegalArgumentException("Capacity should be positive integer");
        }
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    DynamicArray(){
        this(16);
    }

    public int size(){
        return length;
    }

    public T get(int index){
        return arr[index];
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void set(int index, T element){
        arr[index] = element;
    }

    public void clear(){
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
    }

    public void add(T element){
        if(length+1 > capacity){
            if(capacity==0) capacity=1;
            else capacity*=2;
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[length++] = element;
    }

    public T removeAt(int index){
        if(index >= length || index<0) throw new ArrayIndexOutOfBoundsException(index);
        T element = arr[index];
        T[] newArr = (T[]) new Object[capacity];
        for (int i=0,j=0; i < length; i++,j++) {
            if(i==index) j--;
            else newArr[j] = arr[i];
        }
        length--;
        capacity = length;
        arr = newArr;
        return element;
    }

    public boolean remove(T element){
        for (int i = 0; i < length; i++) {
            if(arr[i].equals(element)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element){
        for (int i = 0; i < length; i++) {
            if(arr[i].equals(element)) return i;
        }
        return -1;
    }

    public boolean contains(T element){
        return indexOf(element) != -1;
    }
}
