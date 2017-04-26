package TreePackage;

/**
 * A class that implements the ADT queue by using an expandable
 * circular array with one unused location.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */

public class ArrayQueue<T> implements QueueInterface<T>, 
                                      java.io.Serializable
{
    private T[] queue; // circular array of queue entries and one unused
                       // location
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
  
    public ArrayQueue() {
	this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor
  
    public ArrayQueue(int initialCapacity) {
	queue = (T[]) new Object[initialCapacity + 1];
	frontIndex = 0;
	backIndex = initialCapacity;
    } // end constructor
		
    // 24.12
    public void enqueue(T newEntry) {
	if (isArrayFull()) // isArrayFull and 
	    doubleArray();   // doubleArray are private
	    
	backIndex = (backIndex + 1) % queue.length;
	queue[backIndex] = newEntry;
    } // end enqueue

    // 24.13
    public T getFront() {
	T front = null;
	  
	if (!isEmpty())
	    front = queue[frontIndex];
	    
	return front;
    } // end getFront
	
    // 24.14
    public T dequeue() {
	T front = null;
	  
	if (!isEmpty())
	    {
		front = queue[frontIndex];
		queue[frontIndex] = null;
		frontIndex = (frontIndex + 1) % queue.length;
	    } // end if
	  
	return front;
    } // end dequeue

    // 24.16
    public boolean isEmpty() {
	return frontIndex == ((backIndex + 1) % queue.length);
    } // end isEmpty

   public void clear() {
      int initialCapacity = DEFAULT_INITIAL_CAPACITY;
      queue = (T[]) new Object[initialCapacity + 1];
	frontIndex = 0;
	backIndex = initialCapacity;
   }
   
    // 24.16
    private boolean isArrayFull() {
	return frontIndex == ((backIndex + 2) % queue.length);
    } // end isArrayFull

    // 24.15
    private void doubleArray() {
	T[] oldQueue = queue;
	int oldSize = oldQueue.length;
	  
	queue = (T[]) new Object[2 * oldSize];
	  
	for (int index = 0; index < oldSize - 1; index++)
	    {
		queue[index] = oldQueue[frontIndex];
		frontIndex = (frontIndex + 1) % oldSize;
	    } // end for
	  
	frontIndex = 0;
	backIndex = oldSize - 2;
    } // end doubleArray
}  // end ArrayQueue
