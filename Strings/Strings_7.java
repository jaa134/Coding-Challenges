import java.util.HashSet;

//HARD: Find the shortest palindrome in a String
public class Strings_7 {
  
  private final static int min_p_len = 2;
  
  //does not prioritize smallest values, below answer is more efficient
  //public static HashSet<String> shortestPalindrome(String s) {
  //  int sp_len = Integer.MAX_VALUE;
  //  HashSet<String> shortestPalindromes = new HashSet<>();
  //  
  //  s = s.replaceAll(" ", "");
  //  //shortest length palindrom is 2, so dont bother checking string lengths
  //  for (int i = 0; i <= s.length() - min_p_len; i++) {
  //    for (int j = i + min_p_len; j <= s.length(); j++) {
  //      String sub = s.substring(i, j);
  //      if (isPalindrome(sub)) {
  //        int sub_len = sub.length();
  //        if (sub_len < sp_len) {
  //          sp_len = sub_len;
  //          shortestPalindromes = new HashSet<>();
  //        }
  //        if (sub_len <= sp_len)
  //          shortestPalindromes.add(sub);
  //      }
  //    }
  //  }
  //  
  //  return shortestPalindromes;
  //}
  
  //prioritizes strings of length 2, then 3, then 4, and so on up until the entire string
  public static HashSet<String> shortestPalindrome(String s) {
    HashSet<String> shortestPalindromes = new HashSet<>();
    
    s = s.replaceAll(" ", "");
    
    int sub_len = min_p_len;
    while(sub_len <= s.length()) {
      for (int i = 0; i <= s.length() - sub_len; i++) {
        String sub = s.substring(i, i + sub_len);
        if (isPalindrome(sub))
          shortestPalindromes.add(sub);
      }
      
      if (shortestPalindromes.size() > 0)
        return shortestPalindromes;
      
      sub_len++;
    }
    
    return shortestPalindromes;
  }
  
  private static boolean isPalindrome(String s) {
    if (s.length() < min_p_len)
      return false;
    
    for (int i = 0; i < (s.length() / 2); i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1))
        return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    printExample(1, "");
    printExample(2, "a");
    printExample(3, "a a");
    printExample(4, "ab ab ab");
    printExample(5, "abcddcba");
    printExample(6, "aabcdefg");
    printExample(7, "abcdefgg");
    printExample(8, "abcbaqlmde");
  }
  
  private static void printExample(int num, String s) {
    System.out.println("\nExample: " + num);
    HashSet<String> shortestPalindrome = shortestPalindrome(s);
    printValues(shortestPalindrome);
  }
  
  private static void printValues(HashSet<String> vals) {
    if (vals.size() == 0)
      System.out.println("No values!");
    
    for (String s : vals)
      System.out.println(s);
  }
}