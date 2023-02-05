
public class ColumnNode {
	private Object data;
	private ColumnNode down;
	private NumberNode right;

	public ColumnNode(Object data) {
		this.setData(data);
		this.setDown(null);
		this.setRight(null);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ColumnNode getDown() {
		return down;
	}

	public void setDown(ColumnNode down) {
		this.down = down;
	}

	public NumberNode getRight() {
		return right;
	}

	public void setRight(NumberNode right) {
		this.right = right;
	}
}