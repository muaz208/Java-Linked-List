
public class SLLSet {
    private int size;
    private SLLNode head;

    public SLLSet() {
    	head=null;//head points to nothing as we have no elements
    	size=0; //size is 0 as we have 0 elements (empty list)
        
    }

    public SLLSet(int[] sortedArray) {
    	this.size=sortedArray.length; //the number of elements well have in this array is how many we will have in our linked list
    	if(size==0) {//check to see if we have a empty list
    		head=null;//if so the head will point to null 
    	}
    	else {
    		
    	
    	SLLNode temp= new SLLNode(sortedArray[size-1],null); //we start with the very last element which will be at the size-1 index, this node will point to null (as it is the last element)
    	
    	for(int i=size-2;i>=0;i--) {//loop to go through the rest of the elements (excluding the last one in the array)
    		temp=new SLLNode(sortedArray[i],temp); //create a new node each time with a value from the array and its reference will be the previous element 
    		
    	}
    	
    	head= temp; //at the very end, our temp will be the first element, so we make the head point to this
    }
        
    }

    public int getSize() {
		
        return (this.size); //return the instance variable of this class "size"
    }

    public SLLSet copy() {
    	SLLNode temp;
    	temp=head; //indexer to go through our linked list
    	int arr[]=new int[this.size]; //create a new array of the same size as our linked list
    	for(int i=0;i<size;i++) {//loop to go through all elements
    		arr[i]=temp.value;//the ith element in the array is the corresponding value of the linked list we are at
    		temp=temp.next;//move our list index to point to the next element
    	}
    	
    	SLLSet copy =new SLLSet(arr); //call the second constructor and pass in our array of values
        

        return copy;
    }

    public boolean isIn(int v) {
    	SLLNode temp;
    	temp=head;//list indexer
    	while(temp!=null) {//loop to go through the entire list 
    		if(temp.value==v) { //check if the value matches 
    			return true; //if so return true
    		}
    		temp=temp.next;//move our list indexer to point to the next element
    	}
        

        return false; //return false if we did not find the value
    }

    public void add(int v) {
    	
    	if(head==null) { //case for a empty list, then we need to add a new node with the value v to hold
    		SLLNode temp=new SLLNode(v,null);
    		head=temp;
    		this.size++;
    	}
    	else {
    		SLLNode temp; //set 1 index
    		SLLNode value;//set 2 index
    		SLLNode added;// the new set we are going to make (union) indexer
    		temp=head; //references the first element so that we have a reference to the previous element for when we want to insert a new value to make sure the chain isnt disturbed
    		value=temp.next; // references the second element, this will help determine when we need to insert between two elements  
    		
			if(head.value>v) { //case where we need to insert this value as the new first element 
				added=new SLLNode(v,head); // make a new node and its refernce will be the element head points to which was the previous first element
				head=added;// head will now reference this new node as this is now the new first element
				this.size++; //increase the size as we added a new element
				
			}
			else if(head.value<=v && (value==null || value.value>v)) { //speacial case for when there is only 2 elements and we need to insert between them or there is only 1 element ad we need to add a new one.
				if(head.value==v) {// if this case is true that means we need to insert between them, this will be handled by the code below in the next section
					//do nothing
				}
				else {
					
				
				added=new SLLNode(v,temp.next);
				temp.next=added;
				this.size++;
				}
			}
			else{
				
			
    		while(value.next!=null) { //case for when we need to insert between two elements 
    			 if(temp.value<v && value.value>v) {// need to check if the potential precedor is less than the value v and the element infront of it is larger then v, then that means this new element has to go in between 
    				

    				added=new SLLNode(v,temp.next); //create a new node that will refernce the element that held the value that was greator then v, in this case value is a refernce to that element or temp.next too
    				temp.next=added;//the new precdor now has to point to this new node 
    				this.size++;
    				break; //break bc the value has been added
    				
    				
    			}
     			temp=temp.next;
     			value=value.next;
     				if(value.next==null && value.value<v) { //case for we need to insert a new last element 
    				 added=new SLLNode(v,null); //new element will refernce null (nothing)
    				 value.next=added; //the previous "last" element now has to point to the new last element 
    				 this.size++;
    				 break;
    				 
    			 }
    			 
    		}
			}
    	}
        
    }

    public void remove(int v) {
    	SLLNode temp; //reference to the first element
    	SLLNode track; //reference to the second element
    	temp=head;
    	
    	
    	if(head==null) {//check to make sure we dont have a empty list
    		//do nothing
    	}
    	else {
	    		track=head.next;
	    	
	    	
	    	
	    	if(head.value==v) { //check if we need to remove the first element 
	    		head=head.next; // if so move the head to the next element 
	    		this.size--;
	    	}
	    	else if(track==null) { //speacial case, for when we only have one element and we find that we dont need to remove it (bc at this point track is suppose to ref the second element but there is no second element so its going to be null).
	    		//do nothing
	    	}
	    	else {
	    		
	        		if(size==2 &&  track.next==null && track.value==v) {//speacial case for when we only have two elements and we need to remove the second element (bc our second element ref will be null at this point so we need to check if that element needs to be removed)
	    				temp.next=null;
	    				this.size--;
	    			}
	    			
	    		else {
	    			
	    		
	    		
		    		while(track.next!=null) {
		    			if(track.value==v && track.next!=null) { //normal; case for if we find a value in the list we need to remove 
		    				temp.next=track.next;
		    				this.size--;
		    				break;
		    			}
		   
		        			temp=temp.next;
		        			track=track.next;
		    				
		
		        		if(track.next==null && track.value==v) { //case for when we need to remove the last element 
		    				temp.next=null;
		    				this.size--;
		    				break;
		    			}
		    				
		    			}
	    			}
	    		
	    		}
    	}
    	
        
    }

    public SLLSet union(SLLSet s) {
    	
    	SLLSet union = new SLLSet();
    	
    	SLLNode temp; // set 1 index
    	SLLNode tempS;// set 2 index
    	SLLNode both; // new set index
    	temp=this.head;
    	tempS=s.head;
    	union.head=new SLLNode(0,null); //initialize a random element to start out chain (so that the head does not point to null) this will later be removed from the list
    	both=union.head;
 
    		
    	
    	
    	while(temp!=null && tempS!=null) {

    		if(temp.value>tempS.value) {//if the first set element is bigger
    			both.next=new SLLNode(tempS.value,null);//create a new element with the value of the second set element (bc it is smaller)
    			both=both.next;
    			tempS=tempS.next;//move up the second set index because the value we compared it with in the first set may be smaller with the next element in the second set
    			union.size++; //increase the size of this new list
    			
    		}
    		else if(temp.value<tempS.value) {//if first set element is smaller
    			both.next=new SLLNode(temp.value,null);//create a new element with the value of the first set element (bc it is smaller)
    			both=both.next;
    			temp=temp.next;//move up the first set index because the value we compared it with in the second set may be smaller with the next element in the first set
    			union.size++;//increase the size of this new list
    			
    		}
    		else if(temp.value==tempS.value) {//if we find two equal values
    			both.next=new SLLNode(tempS.value,null);//create a new element with either of these values (there both the same, so it does not matter)
    			both=both.next;
    			temp=temp.next;//increment both indexes since we found a common value, we don't want to have the case also where it gets added more than once
    			tempS=tempS.next;
    			union.size++;//increase the size of this new list
    			
    		}
    		
    		//if one of the lists index's reaches the end of its list, we still may have values we need to copy
    	}
    	if(temp==null && tempS==null) {//if both set index's are null, this means we have copied all values (sets were same size)
    			//do nothing
    	}
    	else if(temp==null) {//if the first set index is null, we need to copy the remaining elements in set 2
    		while(tempS!=null) {

			both.next=new SLLNode(tempS.value,null);
			tempS=tempS.next;
			both=both.next;
			union.size++;
			
    		}
    	}
    	else { //otherwise we need to copy the remaining elements in set 1
    		while(temp!=null) {
			both.next=new SLLNode(temp.value,null);
			temp=temp.next;
			both=both.next;
			union.size++;
			
    		}
    	}
    	both=union.head;
    	union.head=(union.head).next; //move the head up one to get rid of the dummy element we started off with
    	both.next=null;//sets the dummy value we used to null, essentially gets rid of it
        

        return union;
    }

    public SLLSet intersection(SLLSet s) {
    	
    	SLLSet intersection = new SLLSet();
    	
    	SLLNode temp;
    	SLLNode tempS;
    	SLLNode both;
    	temp=this.head;
    	tempS=s.head;
    	intersection.head=new SLLNode(0,null); //initialize a random element to start out chain (so that the head does not point to null) this will later be removed from the list
    	both=intersection.head;
    	
    	while(temp!=null && tempS!=null) {
    		if(temp.value>tempS.value) {
    			tempS=tempS.next; //if the first set element is bigger, it for sure wont have the second set element as a common value (as the lists are ordered) but the second set might still have that first set element so we advnaced only that one 

    			
    		}
    		else if(temp.value<tempS.value) {
    			temp=temp.next; //if the first set element is smaller, the second set for sure wont have this value (as the lists are ordered) but the first set might still have that second set element so we advanced the first set index only
 
    			
    		}
    		else if(temp.value==tempS.value) {//if we find a match
    			both.next=new SLLNode(tempS.value,null);//make a new node with this value and it will point to null (as this could potentially be the last match)
    			both=both.next;//
    			temp=temp.next;//increment both our set indexes
    			tempS=tempS.next;
    			intersection.size++;
    			
    		}
    	}
    	
    	both=intersection.head;
    	intersection.head=(intersection.head).next; //move the head up one to get rid of the dummy element we started off with
    	both.next=null;//sets the dummy value we used to null, essentially gets rid of it
        

        return intersection;
    }

    public SLLSet difference(SLLSet s) {
    	
    	SLLSet diff = new SLLSet();
    	
    	SLLNode temp;//this lists indexer
    	SLLNode tempS;//the s sets indexer 
    	SLLNode both;//indexer to keep track of our new list 
    	temp=this.head;
    	tempS=s.head;
    	diff.head=new SLLNode(0,null); //initialize a random element to start out chain (so that the head does not point to null) this will later be removed from the list
    	both=diff.head;
    	
    	while(temp!=null && tempS!=null) {

    		if(temp.value>tempS.value) {//if the first set element is bigger
    			tempS=tempS.next; //we need to move the second set index to the next element because the value we compared it with may still be in the second set
    			
    		}
    		else if(temp.value<tempS.value) {//if first set element is smaller
    			both.next=new SLLNode(temp.value,null); //then we know for sure this element isnt in set 2, so we create a new node with that value
    			both=both.next; //move our new list index to point to this new element we made
    			temp=temp.next;//move our set 1 index up 
    			diff.size++;//increase the size of this new list
    			
    		}
    		else if(temp.value==tempS.value) {//if we find two equal values
    			temp=temp.next;//increment both indexes since we found a common value which means this can't be apart of the difference
    			tempS=tempS.next;

    			
    		}
    		
    		//if one of the lists index's reaches the end of its list, we still may have values we need to copy from the first set
    	}
    	if(temp==null && tempS==null) {//if both set index's are null, this means we have copied all values (sets were same size)
    			//do nothing
    	}
    	else if(temp!=null) { //otherwise we need to copy the remaining elements in set 1 (as these for sure wont be in set 2)
    		while(temp!=null) {
			both.next=new SLLNode(temp.value,null);
			temp=temp.next; // move set 1 index up
			both=both.next;// make the new set index point to the element we just made
			diff.size++;
			
    		}// we don't need to worry about if the first set index reaches the end first because any remaining elements in set 2 will for sure have not have been in set 1
    	}
    	
    	
    	both=diff.head;//move our new list index back to the head
    	diff.head=(diff.head).next; //move the head up one to get rid of the dummy element we started off with
    	both.next=null;//sets the dummy value we used to null, essentially gets rid of it
    	
    	
        

        return diff;
    }

    public static SLLSet union(SLLSet[] sArray) {
        SLLSet ss = new SLLSet();
        
       for(int i=0;i<sArray.length;i++) {//loop to go through all lists in the array of lists
    	   ss=ss.union(sArray[i]); //each time ss gets updated to a new set that was unionized with its previous set it was holding and the next list in the array
       }

        

        return ss;
    }

    @Override
    public String toString() {
    	SLLNode temp;
    	temp=head;
    	String value="";
    	
    	if(head==null) { //check to make sure we dont have a empty list 
    		return value;   
    	}
    	else {
    		
    	
    	
    	for(int i=0;i<size;i++){
    		if(temp.next==null) { //check to make sure we arnt at the last element
    			value=value +temp.value+"";//if so add that value to the string without a comma
    			break;//break out since we are at the last element 
    		}
    		else {
        		value=value+temp.value+", "; //add the value of the element plus a comma
        		temp=temp.next;//more our element index to the next element 
    		}
    	}
    	
		
        return value;
    	}
    }
}
