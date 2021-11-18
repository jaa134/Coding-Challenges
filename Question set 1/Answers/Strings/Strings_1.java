//Find the first non-repeated character in a String1. Find the first non-repeated character in a String
public class Strings_1 {
  
  public static char findFirstNonRepeat(String s) {
    if (s.length() == 0)
      return 0;
    
    //checking first char
    if (s.length() == 1 || s.charAt(0) != s.charAt(1))
      return s.charAt(0);
    
    //checking inbetween characters
    for (int i = 1; i < s.length() - 1; i++) {
      //if the character after this one is NOT the same
      if (s.charAt(i - 1) != s.charAt(i) && s.charAt(i) != s.charAt(i + 1))
        return s.charAt(i);
    }
    
    //checking last characters
    if (s.charAt(s.length() - 2) != s.charAt(s.length() - 1))
      return s.charAt(s.length() - 1);
    
    return 0;
  }
  
  public static void main(String[] args) {
    System.out.println(findFirstNonRepeat("a"));
    System.out.println(findFirstNonRepeat("aa"));
    System.out.println(findFirstNonRepeat("ab"));
    System.out.println(findFirstNonRepeat("aab"));
    System.out.println(findFirstNonRepeat("aabb"));
    System.out.println(findFirstNonRepeat("aabc"));
  }
}