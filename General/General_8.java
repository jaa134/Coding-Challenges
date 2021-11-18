import java.util.LinkedList;
import java.util.Collections;

//Write a function that prints out the binary form of an int
public class General_8 {
  
  public static String toBinary(int num) {
    if (num == 0)
      return "0";
    
    int sum = 0;
    int part = num; 
    String out = "";
    for (int i = 0; sum != num; i++) {
      out += part % 2;
      sum += (part % 2) * (Math.pow(2, i));
      part /= 2;
    }
    
    return out;
  }
  
  public static void main(String[] args) {
      System.out.println(toBinary(0));
      System.out.println(toBinary(1));
      System.out.println(toBinary(2));
      System.out.println(toBinary(3));
      System.out.println(toBinary(4));
      System.out.println(toBinary(5));
      System.out.println(toBinary(6));
      System.out.println(toBinary(7));
  }
}