// my code
// Ahead of 5 prcnt
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root)
     {
        List<List<widNODE>> fd = new ArrayList<>();
          int ans =0;
         Queue<widNODE> q=  new LinkedList<>();
           widNODE _firstnode = new widNODE(root,  1);
        q.offer(_firstnode);
        
         while(!q.isEmpty())
         {
            int vv= q.size();
             List<widNODE> each_level = new ArrayList<>();
    
             for(int i=0; i<vv;i++)
              {
                 widNODE temp = q.poll();
                 if(temp != null)
                 {
                    each_level.add(temp);
                 }

                 if(temp.node.left != null)
                 {
                    q.offer(new widNODE(temp.node.left, 2*(temp.nodeheapvalue)));
                 }

                 if(temp.node.right != null)
                 {
                    q.offer(new widNODE(temp.node.right,  (2*(temp.nodeheapvalue)+1)));
                 }

              }   
              fd.add(each_level); 
              
             
         }
         for(List<widNODE> k : fd)
         {
              int pp = k.size()-1;
          widNODE first = k.get(0);
          widNODE last = k.get(pp);
          ans = Math.max (ans,((last.nodeheapvalue - first.nodeheapvalue)+1));
         }
         return ans;      
    }
}

// my approach again ahead of 36 prcnt
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root)
     {
        List<List<widNODE>> fd = new ArrayList<>();
          int ans =0;
         Queue<widNODE> q=  new LinkedList<>();
           widNODE _firstnode = new widNODE(root,  1);
        q.offer(_firstnode);
        
         while(!q.isEmpty())
         {
            int vv= q.size();
             List<widNODE> each_level = new ArrayList<>();
    
             for(int i=0; i<vv;i++)
              {
                 widNODE temp = q.poll();
                 if(temp != null)
                 {
                    each_level.add(temp);
                 }

                 if(temp.node.left != null)
                 {
                    q.offer(new widNODE(temp.node.left, 2*(temp.nodeheapvalue)));
                 }

                 if(temp.node.right != null)
                 {
                    q.offer(new widNODE(temp.node.right,  (2*(temp.nodeheapvalue)+1)));
                 }

              }   
              //fd.add(each_level); 
               int pp = each_level.size()-1;
          widNODE first = each_level.get(0);
          widNODE last = each_level.get(pp);
          ans = Math.max (ans,((last.nodeheapvalue - first.nodeheapvalue)+1));    
             
         }
        //  for(List<widNODE> k : fd)
        //  {
        //       int pp = k.size()-1;
        //   widNODE first = k.get(0);
        //   widNODE last = k.get(pp);
        //   ans = Math.max (ans,((last.nodeheapvalue - first.nodeheapvalue)+1));
        //  }
         return ans;      
    }
}

// gpt approach
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class widNODE {
    TreeNode node;
    int nodeheapvalue;

    widNODE(TreeNode node, int nodeheapvalue) {
        this.node = node;
        this.nodeheapvalue = nodeheapvalue;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int max_width = 0;
        Queue<widNODE> q = new LinkedList<>();
        q.offer(new widNODE(root, 1));

        while (!q.isEmpty()) {    
            int size = q.size();
            int left = q.peek().nodeheapvalue;// the first element for next level becomes the left bpundary
            int right = 0;

            for (int i = 0; i < size; i++) {
                widNODE temp = q.poll();
                right = temp.nodeheapvalue; // as the elemenst will be pushed in the same , each time the widht will be calculated and updated as maximum

                if (temp.node.left != null) {
                    q.offer(new widNODE(temp.node.left, 2 * temp.nodeheapvalue));
                }

                if (temp.node.right != null) {
                    q.offer(new widNODE(temp.node.right, 2 * temp.nodeheapvalue + 1));
                }
            }

            max_width = Math.max(max_width, right - left + 1);
        }

        return max_width;
    }
}
