package tree;

public class BinaryTree {
	
	private Node root;
   
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
         
            Node current = root;
          
            Node parent;
            while (true)
            {
                parent = current;
               
                if (data < current.getData()) {
                    current = current.getLeft();
                   
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public Node find(int data) {
        Node current = root;
        while (current.getData() != data) {
            if (current.getData() < data)
                current = current.getLeft();
            else
                current = current.getRight();
    
            if (current == null)
                return null;
        }

        return current;
    }

    public Node findMinNode() {
        Node current;
        Node parent;

        if (root == null) {
            return null;
        } else {
            parent = root;
            current = parent.getLeft();
            while (current != null) {
                parent = current;
                current = current.getLeft();
            }
            return parent;
        }
    }

    public Node findMaxNode() {
        Node current;
        Node parent;
        //
        if (root == null) {
            return null;
        } else {
            parent = root;
            current = parent.getRight();
            while (current != null) {
                parent = current;
                current = current.getRight();
            }
            return parent;
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;

        boolean isLeftChild = false;
   
        while (current.getData() != key) {
            parent = current;
            if (key < current.getData()) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null)
                return false;
        }
    
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.setLeft(null);
            else
                parent.setRight(null);
        }

        else if (current.getRight() == null) {
            if (current == root)
                root = current.getLeft();
            else if (isLeftChild)
                parent.setLeft(current.getLeft());
            else
                parent.setRight(current.getLeft());
        }
    
        else if (current.getLeft() == null) {
            if (current == root)
                root = current.getRight();
            else if (isLeftChild)
                parent.setLeft(current.getRight());
            else
                parent.setRight(current.getRight());
        }
        
        else
         {
            
             Node successor = getSuccessor(current);
             if(current == root)
                root = successor ;
             
             else if(isLeftChild)
                    parent.setLeft(successor);
             else
                    parent.setRight(successor);
             successor.setLeft(current.getLeft());
         }
        return true;
    }

    private Node getSuccessor(Node delNode)
    {
      
        Node successorParent = delNode;
       
        Node successor = delNode.getRight();
 
        Node current = successor.getLeft();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
       
        if (successor != delNode.getRight())
        {
            successorParent.setLeft(successor.getRight());
           
            successor.setRight(delNode.getRight());
        }
        return successor;
    }
    
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            localRoot.displayNode();
            preOrder(localRoot.getLeft());
            preOrder(localRoot.getRight());
        }
    }
    
    public void midOrder(Node localRoot) {
        if (localRoot != null) {
            preOrder(localRoot.getLeft());
            localRoot.displayNode();
            preOrder(localRoot.getRight());
        }
    }

    public void lastOrder(Node localRoot) {
        if (localRoot != null) {
            preOrder(localRoot.getLeft());
            preOrder(localRoot.getRight());
            localRoot.displayNode();
        }
    }

}
