public class SLL {
	
	private Node head;
	
	public SLL() {
		head = null;
	}
	 public Node head() {             //Returns value at head of list. Doesn't alter the list.
	        head.getData();
			return head;
	    }
	public void addFront(Object dataToAdd) {
		Node newNode = new Node(dataToAdd);
		if(head == null) {			
			head = newNode;
		}
		
		else {			
			newNode.setLink(head);
			head=newNode;
		}
	}
	public Object lastElement() {
        
        if (head == null) {
        	return null;
        	
        }
        else {          
            Node temp = head;
            while (temp.getLink() != null) {
                temp = temp.getLink();
            }
              
            return temp.getData();
        }
   
	}
	
	public void addLast(Object dataToAdd) {
		Node newNode = new Node(dataToAdd);
           
        if (head == null) {
            head = newNode;
        }
        else {          
            Node temp = head;
            while (temp.getLink() != null) {
                temp = temp.getLink();
            }
              
            temp.setLink(newNode);
        }
   
	}
	public void addIndex(Object dataToAdd) {
		
		Node previous = null;
		Node newNode = new Node(dataToAdd);
		if (head == null) {
			newNode.setLink(head);
            head = newNode;
        }
		else {
			Node temp = head;
			while (temp != null&&(int)dataToAdd > (int)temp.getData()) {
				 previous = temp;
	             temp = temp.getLink();
	         }
	           
	         if(temp == null) {	 
	        	 temp = head;
	             while (temp.getLink() != null) {
	                 temp = temp.getLink();
	             }
	               
	             temp.setLink(newNode);
	         }
	         
	         else {
	        	 if(previous!=null) {
		        	 newNode.setLink(temp);
		        	 previous.setLink(newNode);
	        	 }
	        	 else {
	        		 newNode.setLink(head);
	                 head = newNode;
	        	 }
	         }
        
		}
	}
	
	
	public void delete(Object dataToDelete) {
		if(head == null) {
			System.out.println("Linked list is empty!!");
		}
		else {
			while ((int)dataToDelete == (int)head.getData()) {
				head=head.getLink();
			}
			Node temp = head;
			Node previous = null;
			while (temp!=null) {
				if ((int)dataToDelete == (int)temp.getData()) {
					
		        	previous.setLink(temp.getLink());
		        	temp=previous;
				}
				previous = temp;
				temp=temp.getLink();
			}
		}
	}
	public boolean search(Object item) {
		boolean flag = false;
		  
		if (head == null) {
			System.out.println("linked list is empty");
		}
		else {
			Node temp = head;
		while (temp != null) {
			if (item == temp.getData()) {
				flag = true;
				
			}			
			temp = temp.getLink();
			}
		}
		
		return flag;
	}
	public void display() {		
		Node temp = head;		
		while(temp != null) {
			System.out.println(temp.getData()+" ");
			temp = temp.getLink();
		}			
		
	}
	public Object[] display2() {		
		Node temp = head;	
		Object[] ary = new Object[this.size()];
		int i=0;
		while(temp != null) {
			
			ary[i]=temp.getData();
			i++;
			temp = temp.getLink();
		}	
		return ary;
		
	}
	public int size() {
		int count = 0;
		
		if(head == null) {
			System.out.println("Linked list is empty!!");
		}
		else {
			Node temp = head;
			while(temp != null) {
				count++;
				temp = temp.getLink();
			}			
		}
		return count;				
		
	}
	public int count(Object cnt) {
		int count = 0;
		if(head == null) {
			
		}
		else {
			Node temp = head;
			while(temp != null) {
				if((int)temp.getData() ==(int) cnt) {
					count++;
					
				}
				temp = temp.getLink();
			}		
		}
		
		return count;
	}
	public Object deletelast() {
		Object returned=null;

		if(head == null) {
			System.out.println("Linked list is empty!!");
		}
		else {
			Node temp = head;
			Node previous = null;
			if (temp.getLink()==null && previous==null)
			{
				returned=temp.getData();
				temp=null;
				head=null;
			}
			while (temp!=null) {
				if (temp.getLink()==null) {
					
		        	previous.setLink(temp.getLink());
		        	returned = temp.getData();
		        	temp=null;
		        	break;
				}
				previous = temp;
				temp=temp.getLink();
				
			}
		}
		return returned;
	}
	
		
	}
	

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	


