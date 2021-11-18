import java.util.Random;

//HARD: Given a function rand5() that returns a random int between 0 and 5, implement rand7()
public class General_13 {
  
  private static int[][] vals = new int[][] {
    {1,2,3,4,5,6},
    {7,8,1,2,3,4},
    {5,6,7,8,1,2},
    {3,4,5,6,7,8},
    {1,2,3,4,5,6},
    {7,8,0,0,0,0}
  };
  
  //values between 0 and 5
  private static int rand5() {
    return (int)(new Random().nextDouble() * 6);
  }
  
  //values between 0 and 7
  public static int rand7_mat() {
    int rand = 0;
    //get a number between 1 and 8
    while (rand == 0)
      rand = vals[rand5()][rand5()];
    return rand - 1;
  }
  
  //values between 0 and 7
  public static int rand7_arr() {    
    int startRangeLen = 6;
    int endRangeLen = 8;
    
    int i;
    do
    {
      // i is now uniformly random between [0,35]
      i = startRangeLen * rand5() + rand5();
    } while(i >= 32);
    //i is now uniformly random between [0,32)
    return i % endRangeLen;
  }
  
  public static void main(String[] args) {
    int[] results_mat = new int[8];
    int[] results_arr = new int[8];
    
    for (int i = 0; i < 1000; i++) {
      results_mat[rand7_mat()]++;
      results_arr[rand7_arr()]++;
    }
    
    for (int i = 0; i < results_mat.length; i++)
      System.out.println(i + ": " + results_mat[i]);
    
    System.out.println();
    
    for (int i = 0; i < results_arr.length; i++)
      System.out.println(i + ": " + results_arr[i]);
  }
}