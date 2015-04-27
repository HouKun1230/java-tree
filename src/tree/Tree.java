package tree;

public class Tree {
	
	 public int value;
	    public Tree left;
	    public Tree right;

	    public void store(int value) {
	        if (value < this.value) {
	            if (left == null) {
	                left = new Tree();
	                left.value = value;
	            } else {
	                left.store(value);
	            }
	        } else if (value > this.value) {
	            if (right == null)
	            {
	                right = new Tree();
	                right.value = value;
	            } else {
	                right.store(value);
	            }
	        }
	    }
	    public boolean find(int value) {
	        System.out.println("find happen " + this.value);
	        if (value == this.value) {
	            return true;
	        } else if (value > this.value) {
	            if (right == null)
	                return false;
	            return right.find(value);
	        } else {
	            if (left == null)
	                return false;
	            return left.find(value);
	        }
	    }
	   
	    public void preList() {
	        System.out.print(this.value + ",");
	        if (left != null)
	            left.preList();
	        if (right != null)
	            right.preList();
	    }
	             
	
	    public void middleList() {
	        if (left != null)
	            left.middleList();
	        System.out.print(this.value + ",");
	        if (right != null)
	            right.middleList();
	    }
	    
	    public void afterList() {
	        if (left != null)
	            left.afterList();
	        if (right != null)
	            right.afterList();
	        System.out.print(this.value + ",");
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] data = new int[256];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100) + 1;
            System.out.print(data[i] + ",");
        }
        System.out.println();
        Tree root = new Tree();
        root.value = data[0];
        for (int i = 1; i < data.length; i++) {
            root.store(data[i]);
        }
        
        root.find(data[19]);
        
        root.preList();
        System.out.println();
       
        root.middleList();
        System.out.println();
        
        root.afterList();

	}

}
