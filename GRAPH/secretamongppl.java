// class Solution {
//     int [] parent ;
//     int [] size;    passed 33/60
//     public List<Integer> findAllPeople(int n, int[][] meetings, int firstperson)
//      {
//          parent = new int [n];
//          size = new int [n];
//          for( int i  =0;i< n;i++)
//          {
//              parent[i]=i;
//              size[i]=1;
//          }
//          union(0,firstperson);
//          Arrays.sort(meetings, (a, b) -> Integer.compare(a[a.length - 1], b[b.length - 1]));
//         // int prevtime=0;
//          List<Integer> ans = new ArrayList<>();
//          for( int [] arr:meetings)
//          {
//              int xx=arr[0];
//              int yy= arr[1];
//              int time = arr[2];

//              int xxx = find(xx);
//              int yyy= find(yy);

//              if( xxx != yyy &&( xxx == 0 || yyy ==0))
//              {
//                  union( xxx, yyy);
//              }
             
//             // prevtime = Math.max(prevtime, time);
//          }
 


//        for( int j=0;j<n;j++)
//        {
//            if(find(j) == 0)
//            {
//                ans.add(j);
//            }
//        }

//        return ans;

        
//     }
//     public void union( int x, int y)
//     {
//         int a = find(x);
//         int b = find( y);
//         if( a ==b)
//         {
//            return;
//         }

//         if( size[a]> size[b])
//         {
//             parent[b] =a;
//             size[a] += size[b];
//         }
//         else if( size[b]> size[a])
//         {
//             parent[a]=b;
//             size[b]+= size[a];
//         }
//         else
//         {
//              parent[b] =a;
//             size[a] += size[b];
//         }

//     }

//     public int find( int x)
//     {
//         if( parent[x]==x)
//         {
//             return x;
//         }
//         return parent[x] = find( parent[x]);

//     }
// }
class Solution {
    public List<Integer> findAllPeople(int n, int[][] rawMeetings, int firstPerson) {
    UnionFind disjointSet = new UnionFind(n);
    Map<Integer, List<Meeting>> meetings = groupByTimeAndSort(rawMeetings);

    disjointSet.union(0, firstPerson);
    for (List<Meeting> meetingsAtTime : meetings.values()) {
      for (Meeting meeting : meetingsAtTime) {
        disjointSet.union(meeting.first(), meeting.second());
      }
      for (Meeting meeting : meetingsAtTime) {
        if (!disjointSet.connected(meeting.first(), 0))
          disjointSet.reset(meeting.first(), meeting.second());
      }
    }

    List<Integer> peopleWithSecret = new ArrayList<>();
    for (int person = 0; person < n; ++person) {
      if (disjointSet.connected(person, 0))
        peopleWithSecret.add(person);
    }

    return peopleWithSecret;
  }

  private Map<Integer, List<Meeting>> groupByTimeAndSort(int[][] rawMeetings) {
    BinaryOperator<List<Meeting>> mergeOperator = (m1, m2) -> m1;
      return Arrays.stream(rawMeetings)
      .map(meeting -> new Meeting(meeting[0], meeting[1], meeting[2]))
      .collect(Collectors.groupingBy(Meeting::time))
      .entrySet().stream()
      .sorted(Map.Entry.comparingByKey())
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, mergeOperator, LinkedHashMap::new));
  }

  public class UnionFind {

    private final int[] parent;
    public UnionFind(int n) {
      this.parent = new int[n];
      for (int person = 0; person < n; ++person) {
        parent[person] = person;
      }
    }
    
    public void union(int first, int second) {
      parent[find(first)] = find(second);
    }
    
    public int find(int person) {
      return parent[person] == person ? person : (parent[person] = find(parent[person]));
    }

    public void reset(int first, int second) {
      parent[first] = first;
      parent[second] = second;
    }

    public boolean connected(int first, int second) {
      return find(first) == find(second);
    }
  }

  private record Meeting(int first, int second, int time) {
  }
}
