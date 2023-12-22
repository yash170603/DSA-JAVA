/*  BSF no ki list ka jo viaited item hai , vo agar uske parent se diff hua toh cycle h*/

class solution
{

public boolean iscycle( int v, ArrayList<ArrayList<Integer>> adj)
{

if( v == 0)
return false;

        Boolean vis[]= new boolean [v];
    Arrays.fill(vis,false);

int [] parent = new int[v];

for(int i =0;i<v;i++)
{
if(vis[i] == false)
{
if(check(i,vis,parent,adj))
return true;
}
}
return false;
}


public boolean checks( int node, boolean [] vis, int [] parent,  ArrayList<ArrayList<Integer>> adj)
{
  Queue<node> q = new LinkedList<>();
if( q.is Empty() == true)
{
q.offer( new node(node, -1));
}

while( !q.isEmpty())
{
int node = q.peek().child;
int par = q,peek().parent;
q.poll();
for( int x : adj.get(node))
{
if(vis[x] == false)
{
    vis[x] = true;

q.offer( new node(x,node))


// if(vis[x] == true)
else if(par !=x) 
return true;
}

}
}
}// end of checks 
}//end of solution class


class node
{
Int child;
Int parent;

node(int child, int parent)
{
this.child= child;
This.parent = parent;
}
}




