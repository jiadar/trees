package TreePackage;

/**
 * A class that implements the ADT stack by using an expandable array.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public class ArrayStack<T> implements StackInterface<T>,
                                      java.io.Serializable
{
    private T[] stack;    // array of stack entries
    private int topIndex; // index of top entry
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
	
    public ArrayStack() {
	this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor
	
    public ArrayStack(int initialCapacity) {
	stack = (T[]) new Object[initialCapacity];
	topIndex = -1;
    } // end constructor

    // 22.09
    public void push(T newEntry)
    {
	topIndex++;
		
  	if (topIndex >= stack.length) // if array is full,
	    doubleArray();              // expand array
    		
	stack[topIndex] = newEntry;
    } // end push

    // 22.10
    public T peek()
    {
	T top = null;
		
	if (!isEmpty())
	    top = stack[topIndex];
		
	return top;
    } // end peek

    // 22.11
    public T pop()
    {
	T top = null;
		
	if (!isEmpty())
	    {
		top = stack[topIndex];
		stack[topIndex] = null;
		topIndex--; 
	    } // end if
		
	return top;
    } // end pop

    // 22.12
    public boolean isEmpty()
    {
	return topIndex < 0;
    } // end isEmpty
	
    // (Question 7, Chapter 22)
    public void clear()
    {
	for (; topIndex > -1; topIndex--)
	    stack[topIndex] = null;
    } // end clear

    /** Task: Doubles the size of the array of stack entries. 
     *        Refer to Segment 5.18 */
    private void doubleArray()
    {
	T[] oldStack = stack;       // get reference to array of stack entries
	int oldSize = oldStack.length;    // get max size of original array
	   
	stack = (T[]) new Object[2 * oldSize]; // double size of array
	   
	// copy entries from old array to new, bigger array
  	System.arraycopy(oldStack, 0, stack, 0, oldSize);

	//  for (int index = 0; index < oldSize; index++)
	//    stack[index] = oldStack[index];
    } // end doubleArray	
} // end ArrayStack
