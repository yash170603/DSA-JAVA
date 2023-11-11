import java.util.*;
class TV
{
    //Function to return a list of TreeNodes visible from the top view 
    //from left to right in Binary Tree.
     public static void main(String args[])
    {
             TreeNode root = new TreeNode(1);
             root.left= new TreeNode(2);
             //root.left.left= new TreeNode(4);
             root.left.right= new TreeNode(4);
             root.left.right.left= new TreeNode(6);
              root.left.right.left.left= new TreeNode(8);
             root.right= new TreeNode(3);
             root.right.left= new TreeNode(5);
             root.right.left.left= new TreeNode(7);
             root.right.left.left.left= new TreeNode(9);
           List<Integer> anns= new ArrayList<>();
              anns = topView(root);
              for (Integer i : anns) 
              {
                System.out.print(i +" ");
              }
              System.out.println();
             
    }
    static ArrayList<Integer> topView(TreeNode root)
    {
        // add your code
        ArrayList<Integer> mainanswer= new ArrayList<>();
          List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        {
            return mainanswer;
            
        }
        
          TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> hm=new TreeMap<>();
      pass(root,0,0,hm);  
       for (int col : hm.keySet()) 
       {
          
           List<Integer> level = new ArrayList<>();
  
          for (int levelKey : hm.get(col).keySet())
      {
       
        List<Integer> values = hm.get(col).get(levelKey);
        
        
        Collections.sort(values);
        
        
        level.addAll(values);
    }
    ans.add(level);
   
}
 for( List<Integer> j:ans)
    {
        mainanswer.add(j.get(0));
    }
     
        return mainanswer;
    }
    public  static void pass(TreeNode root,int col,int level,TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> hm){
      
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
