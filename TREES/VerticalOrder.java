class Solution {
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){return ans;}
          TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> hm=new TreeMap<>();
      pass(root,0,0,hm);  
       for (int col : hm.keySet()) {
    List<Integer> level = new ArrayList<>();
    for (int levelKey : hm.get(col).keySet()) {
        List<Integer> values = hm.get(col).get(levelKey);
        
        // Sort the values in this level
        Collections.sort(values);
        
        // Add the sorted values to the current level list
        level.addAll(values);
    }
    ans.add(level);
}
        return ans;
    }
public void pass(TreeNode root,int col,int level,TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> hm){
      
       if (root == null) {
        return;
    }
        if(hm.containsKey(col)){
            if( hm.get(col).containsKey(level))
           hm.get(col).get(level).add(root.val);
            else{ ArrayList<Integer> temp=new ArrayList<>();
                hm.get(col).put(level,temp);
                 hm.get(col).get(level).add(root.val);
            }
        }
        else{
         TreeMap<Integer,ArrayList<Integer>> temp=new TreeMap<>();
            ArrayList<Integer> al=new ArrayList<>();
            hm.put(col,temp);
            hm.get(col).put(level,al);
            hm.get(col).get(level).add(root.val);
        }
        if(root.left!=null){pass(root.left,col-1,level+1,hm);}
        if(root.right!=null){pass(root.right,col+1,level+1,hm);}
    }
}



//Another solution is just using Tree<integer, arrayList> but this will not sort the elements level wise, it will sort elemensts in same level, 
// but 2nd level element may come before 1 level element after sorting in LINE IMP*


class Solution {
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){return ans;}
          TreeMap<Integer,ArrayList<Integer>> hm=new TreeMap<>();
      pass(root,0,0,hm);  
        
        for(int k: hm.keySet())
        {
            List<Integer> y= hm.get(k);
            Collections.sort(y);  //Line IMP* check last sol , same eroor
           ans.add(y);
        }
        return ans;
    }
public void pass(TreeNode root,int col,int level,TreeMap<Integer,ArrayList<Integer>> hm){
      
       if (root == null) {
        return;
    }     
        if(hm.containsKey(col)){
                     hm.get(col).add(root.val);
           
        }
        else{
       
            ArrayList<Integer> al=new ArrayList<>();
          
           hm.put(col,al);
           
            hm.get(col).add(root.val);
        }
        if(root.left!=null){pass(root.left,col-1,level+1,hm);}
        if(root.right!=null){pass(root.right,col+1,level+1,hm);}
    }
}

//
//
//


// this gave tle 
class NodeInfo {
    TreeNode node;
    int level;
    int vertical_line;

    NodeInfo(TreeNode node, int row, int col) {
        this.node = node;
        this.level = row;
        this.vertical_line = col;
    }
}
class Solution
 {   
      public   List<List<Integer>> verticalTraversal(TreeNode root)
     {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempp= new ArrayList<>();
            Map<Integer, ArrayList<Integer>> x = new HashMap<>();
        if( root == null)
        return ans;
        if(root.left == null && root.right ==null)
        {
            tempp.add(root.val);
            ans.add(tempp);
            return ans;
        }     
        solver(root, 0, 0, x);
        List<Integer> ff = new ArrayList<>(x.keySet());
        Collections.sort(ff);
        for(int y :ff)
        {
            List<Integer> kl = x.get(y);
            Collections.sort(kl);
            ans.add(kl);
            kl.clear();
        }
        return ans;
    }
     public   void solver(TreeNode root, int level, int vertical_line, Map<Integer, ArrayList<Integer>> x)
    {          
      Queue<NodeInfo> q = new LinkedList<>();
      NodeInfo node = new NodeInfo(root, level,vertical_line);
      q.offer(node);
      while(!q.isEmpty())
      {
        NodeInfo temp = q.poll();
        TreeNode NODE =temp.node;
        int LEVEL = temp.level;
        int VERTICAL_LINE = temp.vertical_line;
        if( !x.containsKey(VERTICAL_LINE))
        {
            x.put(VERTICAL_LINE, new ArrayList<>());
        }
        x.get(VERTICAL_LINE).add(NODE.val);
        if(root.left != null)
        {
            q.offer(new NodeInfo(root.left, level+1,vertical_line-1) );
        }
        if(root.right != null)
        {
            q.offer(new NodeInfo(root.right, level-1,vertical_line+1) );
        }
      }
    }   
}



// this  failed for
Input
root =
[3,1,4,0,2,2]
Output
[[0],[1],[2,2,3],[4]]
    Expected
[[0],[1],[3,2,2],[4]]
    
class Solution {
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){return ans;}
          TreeMap<Integer,ArrayList<Integer>> hm=new TreeMap<>();
      pass(root,0,0,hm);  
        // for(int k: hm.keySet()){
        //     List<Integer> level=new ArrayList<>();
        //     for(int ky: hm.get(k).keySet()){
        //     Collections.sort(hm.get(k).get(ky));
        //     for(int i=0;i<hm.get(k).get(ky).size();i++){
        //         level.add(hm.get(k).get(ky).get(i));             
        //     }       
        //     }
        //     ans.add(level);
        // }
        for(int k: hm.keySet())
        {
            List<Integer> y= hm.get(k);
            Collections.sort(y);
           ans.add(y);
        }
        return ans;
    }
public void pass(TreeNode root,int col,int level,TreeMap<Integer,ArrayList<Integer>> hm){
      
       if (root == null) {
        return;
    }     
        if(hm.containsKey(col)){
           // if( hm.get(col).containsKey(level))
          // hm.get(col).get(level).add(root.val);
          hm.get(col).add(root.val);
            // else{ ArrayList<Integer> temp=new ArrayList<>();
            //     hm.get(col).put(level,temp);
            //      hm.get(col).get(level).add(root.val);
            // }
        }
        else{
        // TreeMap<Integer,ArrayList<Integer>> temp=new TreeMap<>();
            ArrayList<Integer> al=new ArrayList<>();
           // hm.put(col,temp);
           hm.put(col,al);
            // hm.get(col).put(level,al);
            // hm.get(col).get(level).add(root.val);
            hm.get(col).add(root.val);
        }
        if(root.left!=null){pass(root.left,col-1,level+1,hm);}
        if(root.right!=null){pass(root.right,col+1,level+1,hm);}
    }
}
