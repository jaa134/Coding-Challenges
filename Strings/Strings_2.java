//Reverse a String iteratively and recursively
public class Strings_2 {
  
  public static String reverse_iterative(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }
  
  public static String reverse_recursive(String s) {
    if (s.length() <= 1)
      return s;
    
    String sub = s.substring(1, s.length());
    return reverse_recursive(sub) + s.charAt(0);
  }
  
  public static String reverse_recursive_acc(String s, StringBuilder acc) {
    if (s.length() == 0)
      return acc.toString();
    
    String sub = s.substring(0, s.length() - 1);
    char lastChar = s.charAt(s.length() - 1);
    return reverse_recursive_acc(sub, acc.append(lastChar));
  }
  
  public static void main(String[] args) {
    System.out.println(reverse_iterative(""));
    System.out.println(reverse_iterative("a"));
    System.out.println(reverse_iterative("ab"));
    System.out.println(reverse_iterative("abc"));
    
    System.out.println();
    
    System.out.println(reverse_recursive(""));
    System.out.println(reverse_recursive("a"));
    System.out.println(reverse_recursive("ab"));
    System.out.println(reverse_recursive("abc"));
    
    System.out.println();
    
    System.out.println(reverse_recursive_acc("", new StringBuilder()));
    System.out.println(reverse_recursive_acc("a", new StringBuilder()));
    System.out.println(reverse_recursive_acc("ab", new StringBuilder()));
    System.out.println(reverse_recursive_acc("abc", new StringBuilder()));
  }
}