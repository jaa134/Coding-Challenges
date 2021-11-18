//Determine if a String is an int or a double
public class Strings_6 {
  
  public static boolean isIntOrDouble(String s) {    
    try {
      Integer.parseInt(s);
    } catch(NumberFormatException eI) {
      try {
        Double.parseDouble(s);
      } catch(NumberFormatException eD) {
        return false;
      }
    } 
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(isIntOrDouble(""));
    System.out.println(isIntOrDouble("0"));
    System.out.println(isIntOrDouble("1"));
    System.out.println(isIntOrDouble("1.0"));
    System.out.println(isIntOrDouble("abc"));
  }
}