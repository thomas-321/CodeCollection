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
