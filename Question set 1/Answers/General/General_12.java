//Write a multiply function that multiples 2 integers without using *
public class General_12 {
  
  public static int multiply(int a, int b) {
    if (a == 0 || b == 0)
      return 0;
    
    int sum = 0;
    for (int i = Math.abs(a); i > 0; i--)
      sum += Math.abs(b);
    
    if ((a > 0) ^ (b > 0))
      sum *= -1;
    
    return sum;
  }
  
  public static void main(String[] args) {
      System.out.println(multiply(0,4));
      System.out.println(multiply(1,1));
      System.out.println(multiply(3,2));
      System.out.println(multiply(4,-7));
      System.out.println(multiply(-7,4));
      System.out.println(multiply(-7,-4));
  }
}