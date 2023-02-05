public class DLL {
	private NodeDLL head;
	private NodeDLL tail;
	
	public DLL() {
		head = null;
		tail = null;
	}
	
	public void add(Object data) {
		NodeDLL newNode = new NodeDLL(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	public void addLast(Object dataToAdd) {
		NodeDLL newNode = new NodeDLL(dataToAdd);
           
        if (head == null) {
            head = newNode;
        }
        else {          
            NodeDLL temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
              
            temp.setNext(newNode);
        }
   
	}
	public Object lastElement() {
		          
        if (head == null) {
        	return null;
        	
        }
        else {          
            NodeDLL temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
              
            return temp.getData();
        }
   
	}
	public Object[] display2() {		
		NodeDLL temp = head;	
		Object[] ary = new Object[this.size()];
		int i=0;
		while(temp != null) {
			
			ary[i]=temp.getData();
			i++;
			temp = temp.getNext();
		}	
		return ary;
		
	}
	 public NodeDLL head() {             //Returns value at head of list. Doesn't alter the list.
	        head.getData();
			return head;
	    }
	 public Object deletelast() {
			Object returned=null;

			if(head == null) {
				System.out.println("Linked list is empty!!");
			}
			else {
				NodeDLL temp = head;
				NodeDLL previous = null;
				if (temp.getNext()==null && previous==null)
				{
					returned=temp.getData();
					temp=null;
					head=null;
				}
				while (temp!=null) {
					if (temp.getNext()==null) {
						
			        	previous.setNext(temp.getNext());
			        	returned = temp.getData();
			        	temp=null;
			        	break;
					}
					previous = temp;
					temp=temp.getNext();
					
				}
			}
			return returned;
		}
	 public NodeDLL addInsertSort( NodeDLL newNode )
		{
		    if( head == null )
		    {
		        head = newNode;
		        
		    }
		    else
		    {
		        NodeDLL curNode = head , preNode = null;
		       
		        while( curNode != null && (int)(((Player) newNode.getData()).getPlayerScore()) <(int)(((Player) curNode.getData()).getPlayerScore()) )
		        {
		            preNode = curNode;
		            curNode = curNode.getNext();
		        }
		 
		        if( curNode == head )
		        {
		            newNode.setNext(head);
		            head = newNode;
		        }
		        else 
		        {
		            if( curNode != null && preNode != null ) 
		            {
		                newNode.setNext(curNode);
		                preNode.setNext(newNode);
		            }
		            else if( curNode == null ) 
		            {
		                preNode.setNext(newNode);
		                 
		            }
		        }
		    }
		    return newNode; 
		}
public void delete(Object dataToDelete) {
		
		if(head==null) {
			
			System.out.println("list is emtpy");
		}
		
		else if(head==tail && head.getData()==dataToDelete) {
			
			head=null;
			tail=null;
			}
		
		else {
			
			while ((int)dataToDelete == (int)head.getData()) {
				head=head.getNext();
			}
			
			NodeDLL temp=head;
			NodeDLL previous = null;
			while(temp!=null) {
				if((int) temp.getData()==(int) dataToDelete) {
					previous.setNext(temp.getNext());
		        	temp=previous;
				
				}
				previous = temp;
				temp=temp.getNext();
			}
			
		}
		}
	public int size() {
		int count = 0;
		if(head == null) {
			
		}
			
		else {
			NodeDLL temp = head;
			while(temp != null) {
				count++;
				temp = temp.getNext();
			}
		}
		return count;
	}
	
	public boolean search(int number) {
		if(head == null)
		{
			System.out.println("List is empty");
		}
		else {
			NodeDLL temp = tail;
			while(temp != null) {
				if((int)temp.getData() == number) {
					return true;
				}
				temp = temp.getPrev();
			}
		}
		return false;
	}
	
	public void display1() {
		if(head == null)
			System.out.println("List is empty");
		else {
			NodeDLL temp = head;
			while(temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
			System.out.println();
		}
	}
	

	public Object getElement(int x) {
		if(head == null)
		{
			System.out.println("List is empty");
			return null;
		}
		else if(x > size() || x < 0 ){
			System.out.println("Index is out of range");
			return null;
		}
		else {
			NodeDLL temp = head;
			int count = 1;
			while(temp != null) {
				if(x == count)
					return temp.getData();
				temp = temp.getNext();
				count++;
			}
			return null;
		}
	}
	
	public void swap(int x) {
		if(head == null)
		{
			System.out.println("List is empty");
		}
		else if(x > size() || x < 0 ){
			System.out.println("Index is out of range");
		}
		else {
			int element1 = -1;
			NodeDLL temp1 = head;
			int count = 1;
			while(temp1 != null) {
				if(count == x) {
					element1 = (int)temp1.getData();
					break;
				}
				temp1 = temp1.getNext();
				count++;
			}
			int element2 = -1;
			NodeDLL temp2 = tail;
			count = 1;
			while(temp2 != null) {
				if(count == x) {
					element2 = (int)temp2.getData();
					temp2.setData(element1);
					break;
				}
				temp2 = temp2.getPrev();
				count++;
			}			
			temp1.setData(element2);			
		}
	}

}
