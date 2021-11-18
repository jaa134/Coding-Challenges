import java.util.LinkedList;

//Given a single-line text String and a maximum width value, 
//write the function 'String justify(String text, int maxWidth)' 
//that formats the input text using full-justification, i.e., 
//extra spaces on each line are equally distributed between the 
//words; the first word on each line is flushed left and the last 
//word on each line is flushed right
public class Strings_9 {
  
  public static String justify(String s, final int max_width) {
    //cleaning up the input
    s = s.replaceAll("\n", " ").replaceAll("\\s{2,}", " ").trim();
    
    LinkedList<String> lines = new LinkedList<>();
    int lineStart = 0;
    while (lineStart < s.length()) {
      
      //finding line start
      while(lineStart < s.length() && s.charAt(lineStart) == ' ')
        lineStart++;
      
      //finding line width
      int lineWidth;
      if (max_width < s.length() - lineStart) {
        lineWidth = max_width;
        while(lineWidth > 0 && s.charAt(lineStart + lineWidth) != ' ')
          lineWidth--;
        if (lineWidth == 0)
          lineWidth = Math.min(s.length() - lineStart, max_width);
      }
      else
        lineWidth = s.length() - lineStart;
      
      //finding the line
      String line = s.substring(lineStart, lineStart + lineWidth);
      
      //adding spaces
      line = addSpaces(line, max_width);
      
      lines.add(line);
      lineStart += lineWidth;
    }
    
    return String.join("\n", lines);
  }
  
  private static String addSpaces(String line, final int max_width) {
    //split line into words
    String[] words = line.split(" ");
    if (words.length == 1)
      return words[0];
    
    //find the number of characters to add
    int numCharsInLine = 0;
    for (String w : words)
      numCharsInLine += w.length();
    int numSpacesToAdd = max_width - numCharsInLine;
    
    //insert the spaces at the end of every word except the last
    int spacesAdded = 0;
    int posToAdd = 0;
    while (spacesAdded < numSpacesToAdd) {
      words[posToAdd] += ' ';
      spacesAdded++;
      posToAdd++;
      if (posToAdd == words.length - 1)
        posToAdd = 0;
    }
    
    //combine the words
    return String.join("", words);
  }
  
  public static void main(String[] args) {
    System.out.println(justify("abcd ef h i jklmnopq    rst   u v wxyzzzz", 5));
    System.out.println();
    System.out.println(justify("abcd efg hijklmnopq    rst   uvwxyzzzz", 10));
    System.out.println();
    System.out.println(justify("abcd efg hijklmnopq    rst   uvw xyz zzz", 20));
  }
}