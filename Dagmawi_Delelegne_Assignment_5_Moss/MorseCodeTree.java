package Assignment_5;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface{
	
	private TreeNode<String> root = new TreeNode<String>();
	
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	public TreeNode<String> getRoot(){
		return root;
	}
	
	@Override
	public void insert(Object code, Object result) {
		addNode(root,(String)code,(String)result);
	}

	@Override
	public Object fetch(String code) {
		return fetchNode(root,code);
		
	}
	
	
	@Override
	public LinkedConverterTreeInterface delete(Object data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		setRoot(new TreeNode<String>(""));
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	@Override
	public ArrayList<String> toArrayList() {
		
		ArrayList<String> str = new ArrayList<String>();
		LNRoutputTraversal(root, str);
		return str;
	}
	
	
	@Override
	public void setRoot(TreeNode newNode) {
		root = new TreeNode<>((String)newNode.getData());
		
	}

	@Override
	public void addNode(TreeNode root, Object code, Object letter) {
		if(((String) code).length() == 1) {
			if(code.equals(".")) {
				root.left = (new TreeNode<>(letter));
			}
			else if(code.equals("-")){
				root.right = (new TreeNode<>(letter));
			}
		}
		else {
			char dir = ((String) code).charAt(0);
			if(dir == '.') {
				addNode(root.left,((String) code).substring(1),letter);
			}
			if(dir == '-') {
				
				addNode(root.right, ((String) code).substring(1),letter);
			}
		}
	}

	@Override
	public Object fetchNode(TreeNode root, Object code) {
		String c = (String) code;
		if (c.isEmpty()) {
	        return null;  // Handle the case of an empty string
	    }

	    if (c.length() == 1) {
	        if (code.equals("-")) {
	            return (root.right != null) ? root.right.getData() : null;
	        }
	        if (code.equals(".")) {
	            return (root.left != null) ? root.left.getData() : null;
	        }
	    } else {
	        char firstChar = c.charAt(0);
	        if (firstChar == '-') {
	            return (root.right != null) ? fetchNode(root.right, c.substring(1)) : null;
	        }
	        if (firstChar == '.') {
	            return (root.left != null) ? fetchNode(root.left, c.substring(1)) : null;
	        }
	    }
	    return null;
	}

	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		if (root == null) {
			return;
		}
		LNRoutputTraversal(root.left, list);
		list.add(root.getData());
		LNRoutputTraversal(root.right, list);
		
	}
	
}
