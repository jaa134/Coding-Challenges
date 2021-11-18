//Implement an exponent function (bonus: now try in log(n) time)11. Implement an exponent function (bonus: now try in log(n) time)
public class General_11 {
  
  //inefficient: O(sqrt(x))
  //x to the y, x > 0 && y > 0
  //public static int exponential(int x, int y) {
  //  if (y == 0)
  //    return 1;
  //  
  //  if (x == 0 || x == 1)
  //    return x;
  //  
  //  int result = x;
  //  int timesMultiplied = 1;
  // while (timesMultiplied <= (y / 2)) {
  //    result *= result;
  //    timesMultiplied *= 2;
  //  }
  //  
  //  return result * exponential(x, y - timesMultiplied);
  //}
  
  //More efficient O(log(n))
  public static int exponential(int x, int y) {
    if (y == 0)
      return 1;
    
    if (x == 0 || x == 1)
      return x;
      
    int halfN = exponential(x, y / 2);
    if (y % 2 == 1)
      return x * halfN * halfN;
    else
      return halfN * halfN;
  }
  
  public static void main(String[] args) {
    System.out.println(exponential(0,0));
    System.out.println(exponential(0,1));
    System.out.println(exponential(1,0));
    System.out.println(exponential(3,0));
    System.out.println(exponential(3,1));
    System.out.println(exponential(3,3));
    System.out.println(exponential(3,15));
  }
}