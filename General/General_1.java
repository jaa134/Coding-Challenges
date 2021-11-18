import java.util.Random;
import java.util.HashMap;

//Find the most frequent integer in an array
public class General_1 {
  
  private static final int arr_len = 100;
  
  public static int[] randomArray() {
    Random r = new Random(System.currentTimeMillis());
    int[] arr = new int[arr_len];
    for (int i = 0; i < arr.length; i++)
      arr[i] = (int)(r.nextDouble() * arr.length);
    return arr;
  }
  
  public static void findMostCommon(int[] arr) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i : arr) {
      int occurences = hm.containsKey(i) ? (hm.get(i).intValue() + 1) : 1;
      hm.put(i, occurences);
    }
    
    int max_val = 0;
    int max_occurences = 0;
    for (int i : hm.keySet()) {
      int occurences = hm.get(i);
      if (occurences > max_occurences) {
        max_val = i;
        max_occurences = occurences;
      }
    }
    
    System.out.println("Number: " + max_val);
    System.out.println("Occurences: " + max_occurences);
  }
  
  public static void main(String[] args) {
    int[] arr = randomArray();
    findMostCommon(arr);
  }
}