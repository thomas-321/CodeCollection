package Base.java;


/**
 * @author Thomas van Vliet
 * 
 * Generic doublelinkedlist of type T
 */
public class DoubleLinkedList<T> {
    private Node<T> first = null;
    private Node<T> last = null;
    private int size = 0;

    DoubleLinkedList() {}

    /**
     * Function splits the list in 2 and depending on the requested index and list size 
     * decides to loop from the front or from the back
     * @throws IndexOutOfBoundsException when the list is empty
    */
    public T get(int index){
        if (first == null || last == null || !(index < size)){
            throw new IndexOutOfBoundsException();
        }
        if (index < size / 2){
            return getFromFront(index);
        } else {
            return getFromBack(index);
        }
    }

    /**
     * Function starts looping at the first node in the list until the requested index is reached
     * @return object located in the requested index
    */
    private T getFromFront(int index){
        Node<T> node = first;
        for (int counter = 0; counter < index; counter++ ){
            node = node.next;
        }
        return node.object;
    }

    /**
     * Function starts looping at the last node in the list until the requested index is reached
     * @return object located in the requested index
    */
    private T getFromBack(int index){
        Node<T> node = last;
        for (int counter = size-1; counter > index; counter-- ){
            node = node.back;
        }
        return node.object;
    }

    /**
     * @return first element in the list
     * @throws IndexOutOfBoundsException when the item is null
    */
    public T getFirst(){
        if (last == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return last.object;
        }
    }

    /**
     * @return last element in the list
     * @throws IndexOutOfBoundsException when the item is null
    */
    public T getLast(){
        if (last == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return last.object;
        }
    }

    /**
     * @return the size of the list as an integer
    */
    public int getSize(){
        return size;
    }

    /**
     * Node<T> class which is used to store the object and 
     * to realize links between objects
     * 
    */
    private class Node<T> {
        private T object = null;
        private Node<T> back = null;
        private Node<T> next = null;
    
        Node(T object, Node<T> back, Node<T> next){
            this.object = object;
            this.back = back;
            this.next = next;
        }
    }
}
