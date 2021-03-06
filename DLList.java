/*****************************************************
 * class DLList
 * Implements a linked list of DLLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class DLList implements List { //your List interface must be in same dir

    //instance vars
    private DLLNode _head;
    private int _size;
    private DLLNode _tail;

    // constructor -- initializes instance vars
    public DLList( ) {
	_head = null; //at birth, a list has no elements
	_size = 0;
	_tail = null;
    }


    //--------------v  List interface methods  v--------------
    public boolean add( String newVal ) { 
	DLLNode tmp = new DLLNode( null, newVal, _head );
	_head = tmp;
	_size++;
	return true;
    } 


    public String get( int index ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	if (index < size()/2){
	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo(); }
	else {
	DLLNode tmp = _tail; //create alias to tail

	//walk to desired node
	for( int i=0; i > index; i-- )
	    tmp = tmp.getPre();

	//check target node's cargo hold
	retVal = tmp.getCargo(); }
	return retVal;
    } 


    public String set( int index, String newVal ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();
	
	//modify target node's cargo
	tmp.setCargo( newVal );
	
	return oldVal;
    } 


    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    //insert a node containing newVal at position index
    //add-at-index
    
    public void add( int index, String newVal ) {

	//check if possible
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode newNode = new DLLNode( null, newVal, null );

	//if index==0, insert node before head node
	if ( index == 0 ) 
	    add( newVal );
	    //if index is in the front half
	else if (index < size()/2) {
	    DLLNode tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //insert new node
	    newNode.setNext( tmp.getNext() );
	    tmp.setNext( newNode );

	    //increment size attribute
	    _size++;
	}
	//if index is in second half
	else {
		DLLNode tmp = _tail; //create alias to tail

	    //walk to node before desired node
	    for( int i=0; i > index-1; i-- )
		tmp = tmp.getNext();

	    //insert new node
	    newNode.setPre( tmp.getPre() );
	    tmp.setPre( newNode );

	    //increment size attribute
	    _size++;}
    }


    //remove node at pos index, return its cargo
    public String remove( int index ) {

	//check if index possible
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

	//if index==0, remove head node
	if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getNext();	    
	}
	//if index is in front half
	else if (index < size()/2) {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = tmp.getNext().getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
	} 
	else {
		tmp = _tail;
		//walk to node before desired node
	    for( int i=0; i > index-1; i-- )
		tmp = tmp.getPre();

	    //check target node's cargo hold
	    retVal = tmp.getPre().getCargo();

	    //remove target node
	    tmp.setPre( tmp.getPre().getPre() );
	}

	//decrement size attribute
	_size--;

	return retVal;
    }


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) {

	DLList james = new DLList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	System.out.println( "...and now 2nd item has been changed from: " + james.set(1,"got") + " -> " + james.get(1));
	System.out.println( james );

	james.add(0,"whut");
	System.out.println( "...after add(0,whut): " );
	System.out.println( james );

	james.add(4,"phat");
	System.out.println( "...after add(4,phat): " );
	System.out.println( james );

	System.out.println( "...after remove last: " 
			    + james.remove( james._size-1) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );
    }//end main

}//end class LList



