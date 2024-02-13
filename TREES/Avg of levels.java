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
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
         if(root==null) return null;
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();  // this is the key  ....................
            double averageLevel=0;
            for(int i=0;i<levelSize;i++){
                TreeNode currentNode=queue.poll();
                averageLevel+=currentNode.val;
                if(currentNode.left!=null){
                   queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                   queue.offer(currentNode.right);
                }
            }
            averageLevel=averageLevel/levelSize;
            ans.add(averageLevel);
        }
        return ans;
    }
}



\\

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
class Solution {
    public List<Double> averageOfLevels(TreeNode root) 
    {
        TreeNode t = root;
        HashMap<Integer,List<Integer>> mp= new HashMap<>();
        List<Double> ans = new ArrayList<>();
        Queue<node> q  = new LinkedList<>();
        q.offer( new node( t,0));
        while( !q.isEmpty())
        {
            TreeNode k = q.peek().node;
            int level = q.peek().level;
            q.poll();
     
      if (!mp.containsKey(level)) {
                mp.put(level, new ArrayList<>());
            }
            mp.get(level).add(k.val);
            if( k.left != null)
            {
                q.offer( new node( k.left,level+1));
            }
          if(k.right !=null)
          {
            q.offer(new node(k.right,level+1));
          }
            
        }
    

         for( int w=0;w< mp.size();w++)
         {
            List<Integer> temp = mp.get(w);
            double h = avd(temp);
            ans.add(h);
         }
      return ans;

    }

    public double avd( List<Integer> p)
    {
        double avg =0;
        int n = p.size();
        for( int u:p)
        {
            avg += u;
        }

        return (double)avg/n;
    }
}
class node
{
    TreeNode node ;
    int level;

node( TreeNode node, int level)
{
    this.node=node;
    this.level=level;
}
}
