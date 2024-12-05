  // logic -> 

order of L and R is important

the L can move only left,, and the target cant move,, so after traversing the underscores if i is left than j, then its a false,
because it shows  targets respective (in terms of order) L is in a right----> direction from start current L, and since starts L cant go right its invalid condition.
there fore false,,
eg  -its tough to imagine one,, please do a dry run of algo .from the site




func canChange(start string, target string) bool {
        i,j   :=0,0
     n :=len(start)
     for i<n || j< n{      // ---> this or operator is beciase of the casess handled by line 14,, ,,explained below
           
           for i<n && start[i]=='_'{
             i++
           }

           for j<n && target[j]=='_'{
            j++
           }

           if i==n || j==n{   // important edge case, explained below
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




suppose a case ->    s= _L and target = LL
                        ^               ^
                        |               |
                        i               j

after first while loop for underscore the i will be at L  in s,
,
no condition tending to false is true->
i++;j++

now i is out of bounds 2,, but j is still at 1
so j was not onlyoccuring,,, check hi nahi hua..
and for as the string to be of equal length and matching both indexes shludl be i==n && j==m
so for chceking this case we did line 14 if block( ki saare indexs cover hue)

and the intial i<n || j<n
 was for chceking this ki koi charcter baaki hai?  (kind of same thing to above))

