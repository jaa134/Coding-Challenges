import java.util.HashSet;

//Check if a String is composed of all unique characters
public class Strings_5 {
  
  public static boolean isUnique(String s) {
    HashSet<Character> hs = new HashSet<>();
    
    for (char c : s.toCharArray()) {
      if (hs.contains(c))
        return false;
      hs.add(c);
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(isUnique(""));
    System.out.println(isUnique("a"));
    System.out.println(isUnique("aa"));
    System.out.println(isUnique("ab"));
    System.out.println(isUnique("abb"));
  }
}