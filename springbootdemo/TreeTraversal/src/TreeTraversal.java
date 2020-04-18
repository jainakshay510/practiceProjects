import java.util.HashMap;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TreeTraversal {

	public static void main(String[] args) {
		
		BinaryTree tree=new BinaryTree();
		
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.left.left.left=new Node(6);
		
		tree.printInOrder();
		System.out.println();
		tree.printPostOrder();
		System.out.println();
		tree.printPreOrder();
		System.out.println();
		System.out.println(tree.heightOfTree());
		
		System.out.println();
		
		tree.BreadthFirstTraversal();
		
		System.out.println("Value found "+tree.findNodeValue(3));
		
		System.out.println();
		
		tree.zigzagTraversal();
		
		
		
	}
}



//Post Order LRN
//PreOrder NLR
//InOrder LNR

class BinaryTree{
	
	Node root;
	public BinaryTree() {
		root=null;
	}
	
	private void printPostOrder(Node node) {
		
		if(node==null)
			return;
		
		printPostOrder(node.left);
		
		printPostOrder(node.right);
		
		System.out.print(node.key+"->");
		
		
	}
	
	private void printInOrder(Node node) {
		if(node==null)
			return;
		
		printInOrder(node.left);
		
		System.out.print(node.key+"->");
		
		printInOrder(node.right);
		
		
	}
	
	private void printPreOrder(Node node) {
		
		if(node==null)
			return;
		System.out.print(node.key+"->");
		
		printPreOrder(node.left);
		
		printPreOrder(node.right);
		
	}
	
	public void BreadthFirstTraversal() {
		int height=heightOfTree(root);
		for(int i=1;i<=height;i++) {
			printNodesAtaGivenLevel(root,i);
		}
		
		
	}
	
	private void printNodesAtaGivenLevel(Node node,int level) {
		if(node==null) {
			return;
		}
		if(level==1) {
			System.out.print(node.key+" ");
		}
		else if(level>1) {
			printNodesAtaGivenLevel(node.left, level-1);
			printNodesAtaGivenLevel(node.right, level-1);
		}
	}
	
	
	
	
	private int heightOfTree(Node node) {
		if(node==null)
			return 0;
		else { 
			int lheight=heightOfTree(node.left);
			int rheight=heightOfTree(node.right);
			
		if(lheight>rheight)
			return lheight+1;
		else 
			return rheight+1;
		}
	}
	
	private int findNodeValue(Node node,int value) {
		
		if(node==null)
			return 0;
		
		if(node.key==value)
			return value;
		int result=findNodeValue(node.left,value);
		
		if(result==value)
			return value;
		
		result=findNodeValue(node.right,value);
		
		if(result==value)
			return value;
		
		return 0;
	}
	
	private void zigzagTraversal(Node node) {
		
		if(node==null)
			return;
		
		Stack<Node> currrentLevel=new Stack<>();
		Stack<Node> nextLevel=new Stack<>();
		
		currrentLevel.push(node);
		
	boolean leftToRight=true;
	
	while(!currrentLevel.isEmpty()) {
		
		Node n=currrentLevel.pop();
		
		System.out.println(n.key);
		
		if(leftToRight) {
			if(n.left!=null)
				nextLevel.push(n.left);
			if(n.right!=null)
			nextLevel.push(n.right);
		}
		else {
			if(n.right!=null)
				nextLevel.push(n.right);
			if(n.left!=null)
				nextLevel.push(n.left);
		}
		
		if(currrentLevel.isEmpty()) {
			leftToRight=!leftToRight;
			Stack<Node> tempStack=currrentLevel;
			currrentLevel=nextLevel;
			nextLevel=tempStack;
		}
	}
	
		
	}
	
	void printPostOrder()  {     printPostOrder(root);  } 
    void printInOrder()    {     printInOrder(root);   } 
    void printPreOrder()   {     printPreOrder(root);  } 
    
    int heightOfTree() {	return 	heightOfTree(root);}
    
    int findNodeValue(int value) {return findNodeValue(root, value);};
    
    void zigzagTraversal() {zigzagTraversal(root);}
}

class Node{
	  Node left;
	  Node right;
	  int key;
	public Node(int key) {
		
		this.left = null;
		this.right = null;
		this.key = key;
	}
	  
	
	  
}