import java.util.HashMap;
import java.util.LinkedList;

//Find the elements in an array that only occurs once.
public class General_4 {
  
  public static LinkedList<Integer> uniques(int[] a) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i : a) {
      int occurences = hm.containsKey(i) ? (hm.get(i) + 1) : 1;
      hm.put(i, occurences);
    }
    
    LinkedList<Integer> uniqueValues = new LinkedList<Integer>();
    for (int i : hm.keySet()) {
      if (hm.get(i) == 1)
        uniqueValues.add(i);
    }
    
    return uniqueValues;
  }
  
  public static void main(String[] args) {
    int[] arr = new int[] {1,2,2,3,3,4};
    LinkedList<Integer> uniqueValues = uniques(arr);
    for (int i : uniqueValues)
      System.out.println(i);
  }
}