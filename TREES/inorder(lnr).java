class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inorderRecursive(node.left, result);

        // Visit the current node
        result.add(node.val);

        // Traverse the right subtree
        inorderRecursive(node.right, result);
    }
}

//Stack Approach
class Solution {
    public List<Integer> inorderTraversal(TreeNode root)
     {
         List<Integer> result = new ArrayList<>();
         Stack<TreeNode> s1 = new Stack<TreeNode>();
        inorder(root, result,s1);
        return result;
    }
    public void inorder(TreeNode root, List<Integer> result, Stack<TreeNode> s1)
    {
          TreeNode node = root;

          while(true)
          {
              if(node != null)
              {
                  s1.push(node);
                  node = node.left;
              }

              else
              {
                  if(s1.isEmpty() == true)
                  {
                      break;
                  }

                  node = s1.pop();
                  result.add(node.val);
                  node = node.right;
              }
          }
        
    }
}
