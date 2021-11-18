//java.lang.IllegalArgumentException

//Implement parseInt
public class General_9 {
  
  public static int parseInt(String s) throws NumberFormatException {
    int result = 0;
    
    for (int i = 0; i < s.length(); i++) {
      int pos = s.length() - i - 1;
      if (pos == 0 && s.charAt(pos) == '-' && s.length() > 1)
        result *= -1; 
      else if (!(Character.isDigit(s.charAt(pos))))
        throw new NumberFormatException("Not an integer:" + s);
      else
        result += Math.pow(10, i) * toInt(s.charAt(pos));
    }
    
    return (int)result;
  }
  
  private static int toInt(char c) {
    return c - '0';
  }
  
  public static void main(String[] args) {
      System.out.println(parseInt("1"));
  }
  
}