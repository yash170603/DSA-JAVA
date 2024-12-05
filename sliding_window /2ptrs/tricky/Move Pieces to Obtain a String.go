func canChange(start string, target string) bool {
        i,j   :=0,0
     n :=len(start)
     for i<n || j< n{
           
           for i<n && start[i]=='_'{
             i++
           }

           for j<n && target[j]=='_'{
            j++
           }

           if i==n || j==n{
                return  i==n && j==n
           }

           if start[i]!=target[j]{
             return false  
           }

           if start[i]=='L' && i<j{
            return false
           }
           

           if start[i]=='R' && j<i{
            return false
           }
          

           i++
           j++
     }

     return true

}
