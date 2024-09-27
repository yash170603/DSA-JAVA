import java.util.HashSet;

class MyCalendar {

    HashSet<pair> x;

    public MyCalendar() {
        x = new HashSet<>();
    }

    public boolean book(int start, int end) {
        // If the set is empty, just add the event
        if (x.isEmpty()) {
            x.add(new pair(start, end));
            return true;
        }

        // Check if the event can be booked without overlapping
        if (!check(new pair(start, end))) {
            return false;
        }

        // Add the event if it passes the check
        x.add(new pair(start, end));
        return true;
    }

    // This method checks if the new event overlaps with any existing event
    public boolean check(pair t) {
        int a = t.a;  // Start of new event
        int b = t.b;  // End of new event

        // Loop through all existing events
        for (pair kid : x) {
            int rx = kid.a;  // Start of existing event
            int ry = kid.b;  // End of existing event

            // Check if the new event overlaps with the existing one
            if (!(b <= rx || a >= ry)) {
                return false;  // Overlap detected
            }
        }

        return true;  // No overlap, can be booked
    }

    // Helper class to store the events
    class pair {
        int a;
        int b;

        pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */




class MyCalendarTwo {
   
   List<int []> overLaps ;
   List<int []> doubleOverlap;
    public MyCalendarTwo() {
         overLaps = new ArrayList<>();
         doubleOverlap = new ArrayList<>();
    }

    public boolean checkOverlap(int s1, int e1, int s2, int e2){
           return    !( e1<=s2 || s1>=e2);
    }

    public int [] doubleRange( int s1, int e1, int s2, int e2){
             int a = Math.max( s1,s2);
             int b=Math.min(e1,e2);
               
               return new int [] { a,b};
    }
    
    public boolean book(int start, int end) {
            
            for( int  [] x: doubleOverlap){
                if(checkOverlap( start,end,x[0],x[1])) return false;
            }

            for( int [] y: overLaps ){
                if  (checkOverlap( start,end,y[0],y[1])) {
                      int []v = doubleRange(start,end,y[0],y[1] );
                      doubleOverlap.add(v);
                }
            }

            overLaps.add(new int [] { start,end});
            return true;

    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
