
public class MultiLinkedList {

	private ColumnNode head;

	public MultiLinkedList() {
		this.head = null;
	}

	public void display() {
		if (head == null) {
			System.out.println("There is no data to display.");
		} else {
			ColumnNode temp = head;
			while (temp != null) {
				System.out.println(temp.getData() + " : ");
				NumberNode tempP = temp.getRight();
				while (tempP != null) {
					System.out.println(tempP.getData().toString());
					tempP = tempP.getNext();
				}
				temp=temp.getDown();
				System.out.println();
			}
			
		}
	}
	public Object[] display2(String column) {
		Object[] ary = new Object[this.size(column)];
		if (head == null) {
			
		}
		else {
		ColumnNode temp = head;	
		
		int i=0;
		while(temp != null) {
			NumberNode temp2 = temp.getRight();
			if(column.equals(temp.getData().toString())) {
															
				while(temp2!=null) {	
					ary[i]=temp2.getData();
					i++;
					temp2=temp2.getNext();
										
				}							
			}		
				temp=temp.getDown();
			
		}	
		
		}
		return ary;
	}
	 public NumberNode columnFirstElement(String cn) {
		 	NumberNode temp2=null;			
			if (head == null) {
				System.out.println("Empty");
			}
			else {
			ColumnNode temp = head;	
					
			while(temp != null) {
				temp2 = temp.getRight();
				if(cn.equals(temp.getData().toString())) {
							return temp2;			
							
										
				}		
					temp=temp.getDown();
				
			}	
			
			}
			return temp2;
	   }
	public int size(String column) {
		int size =0;
		
		if (head == null) {
			
		}
		else {
		ColumnNode temp = head;	
		
		int i=0;
		while(temp != null) {
			NumberNode temp2 = temp.getRight();
			if(column.equals(temp.getData().toString())) {
															
				while(temp2!=null) {	
					size++;
					temp2=temp2.getNext();
										
				}							
			}		
				temp=temp.getDown();
			
		}	
		
		}
		return size;
	}
	 public Object deletelast(String column) {
			Object returned=null;
			
			if(head == null) {
				System.out.println("Linked list is empty!!");
			}
			else {
				ColumnNode temp = head;								
				while (temp != null && !temp.getData().toString().equals(column)) {
					temp = temp.getDown();
				}					
					NumberNode temp2 = temp.getRight();
					NumberNode previous = null;
										
						if (temp2.getNext()==null && previous==null)
						{
							returned=temp2.getData();
							temp2=null;
							temp.setRight(null);
							
						}
						while (temp2!=null) {
							if (temp2.getNext()==null) {								
					        	previous.setNext(temp2.getNext());
					        	returned = temp2.getData();
					        	temp2=null;
					        	break;
							}
							previous = temp2;
							temp2=temp2.getNext();
							
						}				
				
			}
			return returned;
		}
	public Object lastElement(String column) {
		int size =0;
		Object lastElement =null;
		if (head == null) {
			System.out.println("Empty");
		}
		else {
		ColumnNode temp = head;	
		
		int i=0;
		while(temp != null) {
			NumberNode temp2 = temp.getRight();
			if(column.equals(temp.getData().toString())) {
															
				while(temp2!=null) {	
					size++;
					lastElement=temp2.getData();
					temp2=temp2.getNext();
					
										
				}
				
			}		
				temp=temp.getDown();
				
		}	
		
		}
		return lastElement;
		
	}
	public int count(String column, Object cnt){
		int count = 0;

		if (head == null) {
			System.out.println("Empty");
		}
		else {
		ColumnNode temp = head;	
			
		while(temp != null) {
			NumberNode temp2 = temp.getRight();
			if(column.equals(temp.getData().toString())) {
				 										
				while(temp2 != null) {
						if((int)temp2.getData() ==(int) cnt) {
							count++;
							
						}
						temp2 = temp2.getNext();										
				}																				
				
		}	
			temp=temp.getDown();
		}
		}
		return count;
	}
	public void deleteNumber(String cn, int number) {

		if (head == null) {
			System.out.println("There is no column.");
		} else {
			ColumnNode temp = head;
			while (temp != null && !temp.getData().toString().equals(cn)) {
				temp = temp.getDown();
			}
			if (temp != null) {
				if (temp.getRight() == null) {
					System.out.println("There is no number to delete.");
				} else {
					if ((int)temp.getRight().getData()==number) {
						temp.setRight(temp.getRight().getNext());
					} else {
						NumberNode tempP = temp.getRight();
						NumberNode prevP = null;
						while (tempP != null && (int)(tempP.getData())!=number) {
							prevP = tempP;
							tempP = tempP.getNext();
						}
						if (tempP != null) {
							prevP.setNext(tempP.getNext());
						} else {
							System.out.println("There is no number like " + number);
						}
					}
				}
			}
		}
	}

	public void addColumn(String columnName) {
		ColumnNode newNode = new ColumnNode(columnName);
		if (head == null) {
			head = newNode;
		} else {
			ColumnNode temp = head;
			while (temp.getDown() != null) {
				temp = temp.getDown();
			}
			temp.setDown(newNode);
		}

	}
	public void addNumber(String cn, int number) {
				
		if (head == null) {
			System.out.println("Add column");
		} else {
			ColumnNode temp = head;
			while (temp != null) {
				if(cn.equals(temp.getData())) {
					NumberNode temp2 = temp.getRight();
					if(temp2==null) {
						NumberNode newnode = new NumberNode(number);
						temp.setRight(newnode);
					}
					else {
						while(temp2.getNext()!=null) {
							temp2=temp2.getNext();
						}
						NumberNode newnode = new NumberNode(number);
						temp2.setNext(newnode);
					}
				}
				temp=temp.getDown();
			}
			
		}

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}