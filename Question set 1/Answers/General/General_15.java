//Transpose a matrix of integers
public class General_15 {

  //using copy
  public static int[][] transpose(int[][] mat) {
    int m_height = mat.length;
    int m_width = mat[0].length;
    
    int t_width = m_height;
    int t_height = m_width;
    
    int[][] trans = new int[t_height][t_width];
    for (int r = 0; r < m_height; r++) {
      for (int c = 0; c < m_width; c++) {
        trans[c][r] = mat[r][c];
      }
    }
    
    return trans;
  }
  
  public static void main(String[] args) {
    int[][] mat = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
    int[][] trans = transpose(mat);
    printMats(mat, trans);
  }
  
  private static void printMats(int[][] mat, int[][] trans) {
    int m_height = mat.length;
    int m_width = mat[0].length;
    for (int r = 0; r < m_height; r++) {
      for (int c = 0; c < m_width; c++) {
        System.out.print(mat[r][c] + " ");
      }
        System.out.println();
    }
    
    System.out.println();
    
    int t_height = trans.length;
    int t_width = trans[0].length;
    for (int r = 0; r < t_height; r++) {
      for (int c = 0; c < t_width; c++) {
        System.out.print(trans[r][c] + " ");
      }
        System.out.println();
    } 
  }
}