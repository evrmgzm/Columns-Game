public class NodeDLL {
	private Object data;
	private NodeDLL prev;
	private NodeDLL next;
	
	public NodeDLL(Object dataToAdd) {
		data=dataToAdd;
		prev=null;
		next=null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public NodeDLL getPrev() {
		return prev;
	}
	public void setNext(NodeDLL next) {
		this.next = next;
	}
	public NodeDLL getNext() {
		return next;
	}
	public void setPrev(NodeDLL prev) {
		this.prev = prev;
	}
}
