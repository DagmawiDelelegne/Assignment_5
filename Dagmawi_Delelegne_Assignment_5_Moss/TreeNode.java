package Assignment_5;

public class TreeNode <T> {
	protected TreeNode<T> right;
	protected TreeNode<T> left;
	protected T data;
	
	public TreeNode(T dataNode) {
		right = null;
		left = null;
		this.data = dataNode;
	}
	
	public TreeNode(TreeNode<T> n) {
		right = n.right;
		left = n.left;
		data = n.data;
	}
	
	public TreeNode() {
		
	}

	public T getData() {
		return data;
	}

	
}
