public class General_10 {
  
  public static double sqrt(int x) {
    if (x == 0)
      return 0;
    
    double n = 1;
    for (int i = 0; i < 100; i++)
      n -= ((n * n) - x) / (2 * x);
    return n;
  }
  
  public static void main(String[] args) {
    System.out.println(sqrt(0));
    System.out.println(sqrt(1));
    System.out.println(sqrt(4));
    System.out.println(sqrt(5));
    System.out.println(sqrt(29));
  }
}