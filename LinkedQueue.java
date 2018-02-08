//Jacob McAfoos
public class LinkedQueue<T> implements Queue<T> {
  //private variables for a LinkedQueue
  private Node<T> front; //first in first out: always what is removed.
  private Node<T> back; //last in last out: always what is added.
  private int size; //keeps track of how many items are in the Queue.

  //constructor
  public LinkedQueue(){
    front = new Node<T>();
    back = front;
    size = 0;
  }

  /*----------------------------------------------------------------------------
   *removes the front item from the Queue
   *returns the value removed from the Queue
   */
  public T remove(){
    if (size != 0){
      T obj =  front.value;
      front = front.next;
      size--;
      return obj;
    }else{
      throw new UnsupportedOperationException();
    }
  }

  /*----------------------------------------------------------------------------
   *returns the value in the front of the Queue
   */
  public T peek(){
    return front.value;
  }

  /*----------------------------------------------------------------------------
   *adds an item to the back of the Queue
   */
  public void add(T thing){
    Node<T> obj = new Node<T>(thing);
     if (size == 0){
       front = obj;
       back = obj;
     }else if(size > 0){
       back.setNext(obj);
       back = obj;
     }
    size++;
  }

  /*----------------------------------------------------------------------------
   *checks if the Queue is empty
   */
  public boolean isEmpty(){
    return size == 0;
  }
}

/*------------------------------------------------------------------------------
 *------------------------------------------------------------------------------
 * Node class for linked data
 */
class Node<T>{
  T value = null;
  Node<T> next = null;//only a one way link

  //constructor 1: (no parameters)
  public Node(){
  }

  //constructor 2: (one parameter)
  public Node(T value){
    this.value = value;
  }

  //constructor 3: (two parameters)
  public Node(T value, Node<T> next){
    this.value = value;
    this.next = next;
  }

  //determines if the node is linked to another node, if null, return false
  public boolean hasNext(){
    return this.next != null;
  }

  //sets the linked node
  public void setNext(Node<T> newNext){
    this.next = newNext;
  }
}
