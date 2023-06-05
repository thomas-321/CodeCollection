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
