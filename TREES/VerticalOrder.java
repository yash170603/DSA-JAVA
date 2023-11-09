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
            Collections.sort(y);  //Line IMP*
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
