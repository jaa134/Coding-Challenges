import java.util.LinkedList;
import java.util.Random;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

//10. Ladder of strings, given dictionary of 5000, 5 letter strings
public class Strings_10 {
  
  private String startWord;
  private String endWord;
  private LinkedList<String> dictionary;
  private HashMap<String, LinkedList<Pair<String, Boolean>>> wordMap;
  private LinkedList<String> ladder;
  
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
  
  public static LinkedList<String> readWords() throws FileNotFoundException {
    LinkedList<String> words = new LinkedList<>();
    
    Scanner in = new Scanner(new FileReader("sgb-words.txt"));
    while(in.hasNext()) {
      words.add(in.next());
    }
    
    return words;
  }
  
  public static LinkedList<String> generateWords(int numWords, int numCharsPerWord) {
    final String allowedChars = "abcdefghijklmnopqrstuvwxyz";
    LinkedList<String> words = new LinkedList<>();
    
    Random rnd = new Random();
    int currWord = 0;
    while (currWord < numWords) {
      String s = "";
      for (int j = 0; j < numCharsPerWord; j++) {
        int index = (int)(rnd.nextFloat() * allowedChars.length());
        char c = allowedChars.charAt(index);
        s += c;
      }
      if (!words.contains(s)) {
        words.add(s);
        currWord++;
      }
    }
    
    return words;
  }
  
  public Strings_10(LinkedList<String> dictionary) {
    this.dictionary = dictionary;
    this.wordMap = new HashMap<String, LinkedList<Pair<String, Boolean>>>();
    preprocess(dictionary);
  }
  
  public void reset() {
    ladder = new LinkedList<String>();
    
    Random rnd = new Random();
    int w1 = (int)(rnd.nextFloat() * dictionary.size());
    int w2 = (int)(rnd.nextFloat() * dictionary.size());
    LinkedList<String> keys = new LinkedList<>(wordMap.keySet());
    startWord = keys.get(w1);
    endWord = keys.get(w2);
    
    for (String key : wordMap.keySet()) {
      LinkedList<Pair<String, Boolean>> los = wordMap.get(key);
      for (Pair<String, Boolean> p : los)
        p.setValue(false);
    }
  }
  
  private void preprocess(LinkedList<String> dictionary) {
    for (String s : dictionary) {
      LinkedList<Pair<String, Boolean>> listOfSimilars = new LinkedList<>();
      this.wordMap.put(s, listOfSimilars);
    }
    
    for (String s1 : dictionary) {
      for (String s2 : dictionary) {
        if (isSimilar(s1, s2)) {
          wordMap.get(s1).add(new Pair<>(s2, false));
          wordMap.get(s2).add(new Pair<>(s1, false));
        }
      }
    }
  }
  
  //returns true if characters are one letter apart
  private static boolean isSimilar(String s1, String s2) {
    if (s1.equals(s2))
      return false;
    else {
      int mistakesMade = 0;
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          mistakesMade++;
          if (mistakesMade > 1)
            return false;
        }
      }
      return true;
    }
  }
  
  public void solve() {
    LinkedList<String> ladder = new LinkedList<String>();
    ladder.add(startWord);
    markVisitedAll(startWord);
    
    String currentWord;
    while (!ladder.isEmpty() && (currentWord = ladder.getLast()) != endWord) {
      Pair<String, Boolean> nextWord = nextUnvisitedWord(wordMap.get(currentWord));
      if (nextWord != null) {
        ladder.add(nextWord.getKey());
        nextWord.setValue(true);
      }
      else {
        ladder.removeLast();
      }
    }
    
    if (!ladder.isEmpty()) {
      this.ladder = ladder;
      simplify();
    }
  }
  
  public Pair<String, Boolean> nextUnvisitedWord(LinkedList<Pair<String, Boolean>> listOfSimilars) {
    //prioritize words that are similar to the end word
    for (Pair<String, Boolean> p : listOfSimilars) {
      if (!p.getValue() && isSimilar(p.getKey(), endWord))
        return p;
    }
    for (Pair<String, Boolean> p : listOfSimilars) {
      if (!p.getValue())
        return p;
    }
    return null;
  }
  
  public void markVisitedAll(String word) {
    for (String key : wordMap.keySet()) {
      if (isSimilar(key, word)) {
        LinkedList<Pair<String, Boolean>> los = wordMap.get(key);
        for (Pair<String, Boolean> p : los) {
          if (p.getKey().equals(word)) {
            p.setValue(false);
            break;
          }
        }
      }
    }
  }
  
  //elliminate redundancies and similar words
  private void simplify() {
    for (int i = 0; i < ladder.size(); i++) {
      String currentWord = ladder.get(i);
      for (int j = ladder.size() - 1; j > i; j--) {
        String wordToCompare = ladder.get(j);
        if (currentWord.equals(wordToCompare) || isSimilar(currentWord, wordToCompare)) {
          ladder.subList(i + 1, j).clear();
          break;
        }
      }
    }
  }
  
  private static boolean isValidLadder(LinkedList<String> ladder) {
    for (int i = 0; i < ladder.size() - 1; i++) {
      if (!isSimilar(ladder.get(i), ladder.get(i + 1)))
        return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    try {
      LinkedList<String> words = readWords();
      Strings_10 tree = new Strings_10(words);
    
      while (true) {
        tree.reset();
        tree.solve();
        if (!tree.ladder.isEmpty() && tree.ladder.size() > 1) {
          if (!isValidLadder(tree.ladder))
            System.out.println("ERROR: Not a valid ladder!");
        
          System.out.println("The start word is: " + tree.startWord);
          System.out.println("The end word is: " + tree.endWord);
          System.out.println("Solution length: " + tree.ladder.size());
          
          for (int i = 0; i < tree.ladder.size(); i++)
            System.out.println(i + ": " + tree.ladder.get(i));
          break;
        }
      }
    } catch(FileNotFoundException e) {
      System.err.println(e.getMessage());
    }
  }
}