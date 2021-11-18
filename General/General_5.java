import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//5. Find the common elements of 2 int arrays
public class General_5 {
  
  private static final int arr_len = 100;
  
  public static int[] randomArray() {
    Random r = new Random(System.currentTimeMillis());
    int[] arr = new int[arr_len];
    for (int i = 0; i < arr.length; i++)
      arr[i] = (int)(r.nextDouble() * arr.length);
    return arr;
  }
  
  public static List<Integer> getCommonValues(int[] a, int[] b) {
    HashSet<Integer> aValues = new HashSet<>();
    for (int i: a)
      aValues.add(i);
    
    HashSet<Integer> commonValues = new HashSet<>();
    for (int i : b) {
      if (aValues.contains(i))
        commonValues.add(i);
    }
    
    return new LinkedList<Integer>(commonValues);
  }
  
  public static void main(String[] args) {
    int[] a = randomArray();
    int[] b = randomArray();
    LinkedList<Integer> commonValues = new LinkedList<>(getCommonValues(a, b));
    for (int i : commonValues)
      System.out.println(i);
  }
}