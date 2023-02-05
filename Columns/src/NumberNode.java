
public class NumberNode {
	private Object data;
	private NumberNode next;
	private NumberNode prev;
	
	public NumberNode(Object data) {
		this.setData(data);
		this.setNext(null);
		prev = null;
	}

	public NumberNode getPrev() {
		return prev;
	}

	public void setPrev(NumberNode prev) {
		this.prev = prev;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public NumberNode getNext() {
		return next;
	}

	public void setNext(NumberNode next) {
		this.next = next;
	}
}