import java.util.HashSet;
import java.util.LinkedList;

//Find pairs in an integer array whose sum is equal to 10 (bonus: do it in linear time)
public class General_2 {
  
  private static class Pair<K,V> {
  
    private K key;
    private V value;
    
    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }
    
    public K getKey() {
      return key;
    }
    
    public V getValue() {
      return value;
    }
    
    public void setValue(V value) {
      this.value = value;
    }
    
    @Override
    public boolean equals(Object obj) {
      return obj instanceof Pair 
        && ((Pair)obj).getKey().equals(this.getKey())
        && ((Pair)obj).getValue().equals(this.getValue());
    }
  }
  
  //can avoid duplicate pairs by using hashmap instead where the key is 
  //an integer and the value is if the integer has already been used or not as a pair
  public static LinkedList<Pair<Integer, Integer>> addsTo10(int[] arr) {
    HashSet<Integer> hs = new HashSet<Integer>();
    LinkedList<Pair<Integer, Integer>> pairs = new LinkedList<>();
    for (int i : arr) {
      if (hs.contains(10 - i))
        pairs.add(new Pair<Integer, Integer>(i, 10 - i));
      hs.add(i);
    }
    return pairs;
  }
  
  public static void main(String[] args) {
    int[] arr = new int[] {-1,0,1,2,3,4,5,6,7,8,9,10,11};
    LinkedList<Pair<Integer, Integer>> pairs = addsTo10(arr);
    for (Pair p : pairs)
      System.out.println(p.getKey() + " + " + p.getValue());
  }
}