//strivers method of o(h) space is best nd easy 
import java.util.Stack;
class BSTIterator
{
    TreeNode temp;
    Stack<TreeNode> s = new Stack<TreeNode>();

    public  BSTIterator(TreeNode root)
    {
        this.temp = root;
        pushall(root);

    }

    public int next()
    {
        TreeNode temp = s.pop();
        int ans = temp.val;
        if(temp.right != null)
        pushall(temp.right);
        return ans;



    }

    public boolean hasNext()
    {
        boolean g = false;
        if(  s.isEmpty() != true)
          g = true;

          return g;

    }
    public void pushall(TreeNode root)
    {
        while(root != null)
        {
            s.push(root);
            root = root.left;
        }
    }

}


//2nd method
class BSTIterator {
    TreeNode temp;
    Stack<TreeNode> stk = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.temp = root;
    }
    
    public int next() {
        int var = 0;
        while (true) {
            if (temp != null) {
                stk.push(temp);
                temp = temp.left;
            } else if (stk.isEmpty() && temp == null){
                break;
            }else {
                temp = stk.isEmpty() ? null : stk.pop();
                if(temp!=null) var = temp.val;
                temp = temp.right;
                break;
            }
        }
        return var;  
    }

    public boolean hasNext() {
        return temp!=null || (temp==null && !stk.isEmpty());
    }
}


//3rd

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    List<Integer> l;
    int len;
    int curr;

    public BSTIterator(TreeNode root) {
        BST1 B = new BST1();
        B.inOrder(root);
        this.l = B.l;
        len = this.l.size();
        this.curr = 0;

    }

    public int next() {
        int data = -1;
        if (curr < len) {
            data = l.get(curr);
            curr++;
        }

        return data;

    }

    public boolean hasNext() {
        return curr < len;

    }
}

class BST1 {

    List<Integer> l = new ArrayList<>();

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        l.add(root.val);
        inOrder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
