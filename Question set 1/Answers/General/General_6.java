//Implement binary search of a sorted array of integers
public class General_6 {
  
  public static void search(int[] sorted_arr, int n) {
    int index = search_r(sorted_arr, n, 0, sorted_arr.length - 1);
    System.out.println("Value is found at index: " + index);
  }
  
  //inclusive bounds
  public static int search_r(int[] sorted_arr, int n, int lower, int upper) {
    if (lower == upper)
      return sorted_arr[lower] == n ? lower : -1;
    
    int middle = (lower + upper) / 2;
    if (sorted_arr[middle] == n)
      return middle;
    else if (sorted_arr[middle] < n)
      return search_r(sorted_arr, n, middle + 1, upper);
    else // (sorted_arr[middle] > n)
      return search_r(sorted_arr, n, lower, middle);
  }
  
  public static void main(String[] args) {
    int[] a1 = new int[] {1};
    int[] a2 = new int[] {1,2};
    int[] a3 = new int[] {1,2,3};
    int[] a4 = new int[] {1,2,3,4};
    
    search(a1, 0);
    search(a1, 1);
    search(a1, 2);
    
    System.out.println();
    
    search(a2, 0);
    search(a2, 1);
    search(a2, 2);
    search(a2, 3);
    
    System.out.println();
    
    search(a3, 0);
    search(a3, 1);
    search(a3, 2);
    search(a3, 3);
    search(a3, 4);
    
    System.out.println();
    
    search(a4, 0);
    search(a4, 1);
    search(a4, 2);
    search(a4, 3);
    search(a4, 4);
    search(a4, 5);
  }
}