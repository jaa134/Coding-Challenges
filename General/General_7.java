import java.util.LinkedList;

//Find the first X prime numbers
public class General_7 {
  
  public static LinkedList<Long> primes(int n) {
    LinkedList<Long> primes = new LinkedList<>();
    
    //primes start at 2
    for (long l = 2; primes.size() < n; l++) {
      if (isPrime(l))
        primes.add(l);
    }
      
    return primes;
  }
  
  //avoid divinding by 0 and 1
  private static boolean isPrime(long l) {
    for (long d = 2; d * d <= l; d++) {
      if (l % d == 0)
        return false;
    }
    return true;
  }
  
  
  public static void main(String[] args) {
    LinkedList<Long> primes = primes(50);
    for (long l : primes)
      System.out.println(l);
  }
}