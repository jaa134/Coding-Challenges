import java.util.HashMap;

//Determine if 2 Strings are anagrams of eachother
public class Strings_3 {
  
  public static boolean isAnagram(String s1, String s2) {
    HashMap<Character, Integer> hm = new HashMap<>();
    
    for (char c : s1.toCharArray()) {
      int occurences = hm.containsKey(c) ? hm.get(c) + 1 : 1;
      hm.put(c, occurences);
    }
    
    for (char c : s2.toCharArray()) {
      if (!hm.containsKey(c) || hm.get(c) == 0)
        return false;
      else
        hm.put(c, hm.get(c) - 1);
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(isAnagram("",""));
    System.out.println(isAnagram("a","a"));
    System.out.println(isAnagram("abc","abc"));
    System.out.println(isAnagram("cba","abc"));
    System.out.println(isAnagram("abg","abd"));
    System.out.println(isAnagram("abc","def"));
  }
}