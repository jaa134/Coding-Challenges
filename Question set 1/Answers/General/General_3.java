//Write fibbonaci iteratively and recursively
public class General_3 {
  
  public static long fib_iterative(long n) {
    if (n == 1 || n == 2)
      return 1;
    
    long v1 = 1;
    long v2 = 1;
    long sum = 2;
    for (int i = 3; i <= n; i++) {
      sum = v2 + v1;
      v1 = v2;
      v2 = sum;
    }
    
    return sum;
  }
  
  public static long fib_recursive(int n) {
    if (n == 1 || n == 2)
      return 1;
    
    n -= 3;
    return fib_recursive_acc(n, 2, 1);
  }
  
  public static long fib_recursive_acc(int n, long sum, long last) {
    if (n == 0)
      return sum;
    
    long newSum = sum + last;
    long newLast = sum;
    n -= 1;
    return fib_recursive_acc(n, newSum, newLast);
  }
  
  public static void main(String[] args) {
    System.out.println("Fib_iterative ==> n=50  ==>  " + fib_iterative(50));
    System.out.println("Fib_recursive ==> n=50  ==>  " + fib_recursive(50));
  }
}