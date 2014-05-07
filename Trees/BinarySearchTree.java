public class BinarySearchTree{

    private class Node{

	private int data, count;
	private Node left, right;

	public Node(){
	    data=0;
	    count=1;
	    left=null;
	    right=null;
	}

	public Node(int d){
	    data=d;
	    count=1;
	    left=null;
	    right=null;
	}

	public void setData(int data){
	    this.data=data;
	}

	public void setLeft(Node left){
	    this.left=left;
	}

	public void setRight(Node right){
	    this.right=right;
	}

	public void increment(){
	    count++;
	}

	public void decrement(){
	    count--;
	}

	public int getData(){
	    return data;
	}

	public Node getLeft(){
	    return left;
	}

	public Node getRight(){
	    return right;
	}

	public String toString(){
	    return data+"";
	}

    }

    private Node root;

    /////
    public int size(){ //number of Nodes in tree
	return 0;        
    }

    public Node find(int target){
	return find(root,target);
    }

    public Node find(Node current, int target){
	if(current==null || target==current.getData()){
	    return current;
	}else{
	    if(target<current.getData()){
		return find(current.getLeft(),target);
	    }else{
		return find(current.getRight(),target);
	    }
	}
    }

    public void insert(int value){
	if(root==null)
	    root=new Node(value);
	else
	    insert(root,value);
    }

    public void insert(Node current, int value){
	if(value<current.getData()&&current.getLeft()==null){
	    current.setLeft(new Node(value));
	}else if(value>current.getData()&&current.getRight()==null){
	    current.setRight(new Node(value));
	}else if(value<current.getData()){
	    insert(current.getLeft(),value);
	}else if(value>current.getData()){
	    insert(current.getRight(),value);
	}else if(value==current.getData()){
	    current.increment();
	}
    }

    public boolean remove(int target){
        Node n=find(target);
	if(n==null)
	    return false;
	//INCOMPLETE
	return true;
    }

    public String list(){
	return list(root);
    }

    public String list(Node current){ //returns an ordered list of the elements in this BinarySearchTree
	return list(current.getLeft())+current+list(current.getRight());
    }

    public String display(){
	return display(root);
    }

    public String display(Node current){
	if(current.getLeft()==null&&current.getRight()==null)
	    return " <--"+current+"--> ";
	if(current.getLeft()==null)
	    return " <--"+current+"-->"+current.getRight()+"\n"+display(current.getRight());
	if(current.getRight()==null)
	    return current.getLeft()+"<--"+current+"--> \n"+display(current.getLeft());
	return current.getLeft()+"<--"+current+"-->"+current.getRight()+
	    "\n"+display(current.getLeft())+"\n"+display(current.getRight());
    }

    public String toString(){
	return display();
    }

}
