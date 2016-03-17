/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode {

    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next LLNode
    private DLLNode _prevNode; //pointer to previous node


    // constructor -- initializes instance vars
    public DLLNode( DLLNode prev, String value, DLLNode next ) {
	_prevNode = prev;
	_cargo = value;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public DLLNode getPrev() { return _prevNode; }
    
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    
    public DLLNode setPrev (DLLNode newPrev) { 
	DLLNode foo = getPrev(); 
	_prevNode = newPrev; 
	return foo; 
    }

    public String setCargo( String newCargo ) {
	String foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args ) {

	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( null, "cat", null );

	//Create a new node after the first
	first.setNext( new DLLNode( first, "dog", null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( first.getNext() , "cow", null ) );

	/* A naive list traversal, has side effect of destroying list
	while( first != null ) {
	    System.out.println( first );
	    first = first.getNext();
	}
	*/

	//Q: when head ptr moves to next node in list, what happens to the node it just left?
	//A: garbage collector reclaims that memory

	//...so better: (w/o moving first pointer)
	DLLNode temp = first; //create ptr to first so JGC doesn't take it
	while( temp != null ) {
	    System.out.println( temp );
	    temp = temp.getNext();
	}

    }//end main

}//end class LLNode
