//Jacob McAfoos
public class ArrayQueue<T> implements Queue<T> {
  private T[] queue;
  private int front;
  private int back;
  private int capacity;

  public ArrayQueue(){
    queue = (T[]) new Object[1];
    front = 0;
    back = 0;
    capacity = queue.length;
  }
  /*----------------------------------------------------------------------------
   *removes the front item from the Queue
   *returns the value removed from the Queue
   */
  public T remove(){}

  /*----------------------------------------------------------------------------
   *returns the value in the front of the Queue
   */
  public T peek(){
    return queue[front];
  }

  /*----------------------------------------------------------------------------
   *adds an item to the back of the Queue
   */
  public void add(T thing){//read/write through method later
    if(back == front && size !=0){
      ensureCapacity();//WRITE THIS METHOD!
    }
    queue[back] = thing;
    size++;
    if (back == capacity - 1)
      back = 0;
    else
      back++;
  }

  /*----------------------------------------------------------------------------
   *checks if the Queue is empty
   */
  public boolean isEmpty(){}
}
