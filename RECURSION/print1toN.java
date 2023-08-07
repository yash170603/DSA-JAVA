import java.util.*;

class rec2 {
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        int n = 17;
        
        print(1, n); // Print numbers from 1 to n
    }

    public static void print(int c, int n) {
        if (c <= n) {
            System.out.println(c);
            print(c + 1, n); // Recursive call to print the next number
        }
    }
}



// i am not able to write print statement inside the main class, there is something wrong,
//     ai is also not helping these times.








//now n to 1

import java.util.*;

class rec3 {
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        
        print(17, n); // Print numbers from 1 to n
    }

    public static void print(int c, int n) {
        if (c >= n) {
            System.out.println(c);
            print(c - 1, n); // Recursive call to print the next number
        }
    }
}
 
