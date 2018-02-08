//Jacob McAfoos
public class ArrayQueue<T> implements Queue<T> {
  private T[] queue;
  private int front;
  private int back;
  private int size;
  private int capacity;

  public ArrayQueue(){
    @SuppressWarnings("unchecked")
    T[] obj = (T[]) new Object[1];
    queue = obj;
    front = 0;
    back = 0;
    size = 0;
    capacity = queue.length;
  }

  /*----------------------------------------------------------------------------
   *On remove, add, if the capacity is filled, this will make room for new data
   *2 System.arraycopy()s ennsure that the information
   *is copied in the right order.
   */
  public void ensureCapacity(){
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[(capacity * 2) + 1];
    System.arraycopy(queue, front, temp, 0, size - front);
    System.arraycopy(queue, 0, temp, size - front, back);
    queue = temp;
    front = 0;
    back = size;
    capacity = queue.length;
  }

  /*----------------------------------------------------------------------------
   *removes the front item from the Queue
   *returns the value removed from the Queue
   */
  public T remove(){
    T obj = queue[front];
    if(size == 0){
      throw new UnsupportedOperationException();
    }else if(front == back)
      ensureCapacity();//Write Method!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    front++;
    size--;
    return obj;
  }

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
  public boolean isEmpty(){
    return size == 0;
  }
}
