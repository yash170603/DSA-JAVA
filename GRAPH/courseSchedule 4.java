class Solution {
    public List<Boolean> checkIfPrerequisite(int num, int[][] prep, int[][] q) {
        List<Boolean> x= new ArrayList<>();
         // har node k liye ek set of new intgeres
          
          List<Set<Integer>> pre = new ArrayList<>();
          HashMap<Integer,Set<Integer>> adj= new HashMap<>();
          for(int i =0;i<num;i++){
               pre.add( new HashSet<>());
               //adj.add(new HashSet<>());
               adj.computeIfAbsent(i,k->new HashSet<>());
          }
          int [] indegree= new int[num];

          for( int [] pr:prep){   
               int u=pr[0];
               int v=pr[1];
               adj.get(u).add(v);
               indegree[v]++;
          }
           Queue<Integer> qq= new LinkedList<>();
          for(int i=0;i<num;i++){ // khans algo
             if(indegree[i]==0){
                qq.offer(i);
             }
          }
      

        while(! qq.isEmpty()){
             int node = qq.poll();
              for( int kid: adj.get(node)){  // get the neighbour
                     pre.get(kid).add(node);  // in neighbours list add the curr node
                     pre.get(kid).addAll(pre.get(node)); // // ab neigbour k pre, jo currNode ki pre hai vo bhi toh hoengi, so addAll
                     indegree[kid]--;  // thsi is bcs of khans algo
                     if(indegree[kid]==0)qq.offer(kid);
              }
        }

        for( int [] t:q){
               int find =t[0];
               int in=t[1];
               x.add( pre.get(in).contains(find)==true?true:false); // this works too x.add(pre.get(in).contains(find);)
        }


    return x;
    }
}
