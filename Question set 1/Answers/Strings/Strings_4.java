//Check if String is a palindrome
public class Strings_4 {
  
  public static boolean isPalindrome(String s) {
    s = s.replaceAll(" ","").toLowerCase();
    for (int i = 0; i < (s.length() / 2); i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1))
        return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(isPalindrome(""));
    System.out.println(isPalindrome("a"));
    System.out.println(isPalindrome("a a"));
    System.out.println(isPalindrome("ab"));
    System.out.println(isPalindrome("ab ba"));
    System.out.println(isPalindrome("abba"));
    System.out.println(isPalindrome("abcba"));
  }
}