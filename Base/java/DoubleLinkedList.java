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
     * @throws IndexOutOfBoundsException when there isn't an item at the requested index
    */
    public int add(T object, int index){
        if (index > size){
            throw new IndexOutOfBoundsException("Index out of range: " + index + "! last possible index = " + size);
        }
        if(index == size){
            return addLast(object);
        }
        if (index == 0){
            return addFirst(object);
        }
        if (index < size / 2){
            return addStartAtFirst(object, index);
        } else {
            return addStartAtLast(object, index);
        }
    }
    
    /**
     * function loops back starting at the last node until the requested index is reached
     * inserts the object in the requested index
     * @return the index in which the object is placed
    */
    public int addStartAtFirst(T object, int index){
        Node<T> node = first;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        Node<T> newNode = new Node<>(object, node.back, node);

        node.back.next = newNode;
        node.back = newNode;
        size++;
        return index;
    }

    /**
     * function loops forward starting at the first node until the requested index is reached
     * inserts the object in the requested index
     * @return the index in which the object is placed
    */
    public int addStartAtLast(T object, int index){
        Node<T> node = last;
        for (int i = size-1; i > index; i--){
            node = node.back;
        }
        Node<T> newNode = new Node<>(object, node.back, node);

        node.back.next = newNode;
        node.back = newNode;
        size++;
        return index;
    }

    /**
     * Function adds the given item to the front of the list
     * @return the index in which the item is saved
    */
    public int addFirst(T object){
        Node<T> newNode= new Node<>(object, null, first);
        Node<T> oldNode = first;
        if (last == null){
            last = newNode;
        }
        if (first == null){
            first = newNode;
        } else {
            oldNode.back = newNode;
            first = newNode;
        }
        size++;
        return 0;
    }

    /**
     * Function adds the given item to the end of the list
     * @return the index in which the item is saved
    */
    public int addLast(T object){
        Node<T> newNode= new Node<>(object, last, null);
        Node<T> oldNode = last;
        if (first == null){
            first = newNode;
        }
        if (last == null){
            last = newNode;
        } else {
            oldNode.next = newNode;
            last = newNode;
        }
        return size++;
    }

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
            throw new IndexOutOfBoundsException("The list is empty");
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
            throw new IndexOutOfBoundsException("The list is empty");
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
