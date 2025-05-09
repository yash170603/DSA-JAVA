this is the binary exponentiation, finding x^y, where y is too fucking large.

```java
final int MOD = (int) 1e9 + 7;

int findPower(int base, int power) {
    if (power == 0) return 1;

    long half = findPower(base, power / 2);
    long ans = (half * half) % MOD;

    if (power % 2 == 1) {
        ans = (ans * base) % MOD;
    }

    return (int) ans;
}
```

now what about fermat’s little theorem?

say u have to find , nCr %M =⇒ n!/(r! * (n-r)!) %M

 which can we written as **`n! *   Inverse[(r! * (n-r)!)]  %M`**

 now we dont have any way of finding this inverse, so we fnd, its multiplicative or modulo inverse with m ..

 say **`n! *   Inverse[(r! * (n-r)!)]  %M`  == a *Inverse[b] %M ,**

 and  b = **`Inverse[(r! * (n-r)!)]`**

  so its like  — this is fermat little theorem,

![image.png](attachment:d2e66922-ad1c-4deb-9fd3-ebf1d0311140:image.png)

this binary exponentiation is explained above.

ans now finding nCr  using fermat little theorem and binary expo/findPower method

![image.png](attachment:856c9d77-09b0-4c68-b5a0-f3dbf1dc4701:image.png)

# This is the final code. for nCr.

```java
import java.util.*;

public class Main {
static long mod = 1000000007;
public static void main(String[] args) {
    int n = 10, r = 3;
    System.out.println("nCr(" + n + ", " + r + ") % " + mod + " = " + fermat(n, r));
}

// Recursive binary exponentiation
static long findpower(long base, long power) {
    if (power == 0) return 1;

    long half = findpower(base, power / 2);
    long ans = (half * half) % mod;
    if (power % 2 == 1) {
        ans = (ans * base) % mod;
    }
    return ans;
}

// Fermat's theorem-based nCr % mod
static long fermat(int n, int r) {
    if (r < 0 || r > n) return 0;

    long a = factorial(n);
    long bb = factorial(r);
    long cc = factorial(n - r);

    long b = (bb * cc) % mod;
    long bInverse = findpower(b, mod - 2);

    return (a * bInverse) % mod;
}

// Factorial under modulo
static long factorial(int n) {
    long ans = 1;
    for (int i = 1; i <= n; i++) {
        ans = (ans * i) % mod;
    }
    return ans;
  }
}// main class ends here
```
