# Java-Linked-List
This java project implements  sets  of  integers  using sorted  singly linked lists. The elements of a set are stored in a singly linked list in increasing order. Therefore, after every operation the singly linked list remains SORTED. There are no repeated digits. 

The Java Class contains the following constructors and methods 

Constructors 

public SLLSet()- constructs an emptySLLSet (zero elements)

public SLLSet( int[] sortedArray )-  constructs an SLLSetobject that contains the integers in the input array. Note that the array is sorted in increasing order and it does not contain repetitions.

Methods

public int getSize()- returns the size of this set.

public SLLSet copy()- returns a deep copyofthis SLLSet.  The meaning of deep is that the two objects do not share any piece of memory.  Thus the copy represents a set with the  same  elements  as this set, but the two linked lists do not have node objects in common.

public boolean isIn(int v): - returns true if integer v is an element of this SLLSet.It returnsfalseotherwise.

public void add(int v):  - adds v to this SLLSet if v was not already an element of this SLLSet.  It does nothing otherwise.

public void remove(int v):  - removes v from this SLLSet if v was an element of this SLLSet. It does nothing otherwise.

public SLLSet union(SLLSet s):  - returns a newSLLSetwhich represents the unionofthis SLLSet and  the input SLLSet s.  


public SLLSet intersection(SLLSet s):  - returns a newSLLSet which represents the intersection of this SLLSetand the inputSLLSet s. 


public SLLSet difference(SLLSet s):  - returns a new SLLSetwhich represents the difference between this SLLSetand and the inputSLLSet s


public static SLLSet union( SLLSet[] sArray)- returns a new object representing the union of the sets in the array.

public String toString()- returns a string representing the set, with the elements listed in increasing order and separated by commas and a space. An exampl  is as follows:1, 2, 3, 4, 5

