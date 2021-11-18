import java.util.LinkedList;
import java.util.Arrays;

//Print all permutations of a string
public class Strings_8 {
  
  public static LinkedList<String> permutations(String s) {
    if (s.length() <= 1)
      return new LinkedList<String>(Arrays.asList(new String[] {s}));
      
    LinkedList<StringBuilder> permsBuilder = new LinkedList<>();
    permsBuilder.add(new StringBuilder(s.charAt(0) + ""));
    
    for (int i = 1; i < s.length(); i++) {
      
      LinkedList<StringBuilder> copy = new LinkedList<>();
      for (int j = 0; j <= i; j++) {
        for (StringBuilder sb : permsBuilder) {
          StringBuilder perm = new StringBuilder(sb.toString());
          perm.insert(j, s.charAt(i));
          copy.add(perm);
        }
      }
      permsBuilder = copy;      
    }
    
    LinkedList<String> perms = new LinkedList<>();
    for (StringBuilder sb : permsBuilder)
      perms.add(sb.toString());
    
    return perms;
  }
  
  private static int factorial(int n) {
    if (n == 0 || n == 1)
      return 1;
    
    int result = 1;
    for (int i = 2; i <= n; i++)
      result *= i;
    
    return result;
  }
  
  public static void main(String[] args) {
    String s = "abcde";
    
    int expectedNumResults = factorial(s.length());
    System.out.println("Expect " + expectedNumResults + " results...");
    
    LinkedList<String> permutations = permutations(s);
    for (int i = 0; i < permutations.size(); i++)
      System.out.println((i + 1) + ": " + permutations.get(i));
  }
}