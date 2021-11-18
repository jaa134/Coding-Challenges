public class General_16 {

  public static int[][] rotate(int[][] mat) {
    int m_height = mat.length;
    int m_width = mat[0].length;
    
    int r_width = m_height;
    int r_height = m_width;
    
    int[][] rot = new int[r_height][r_width];
    for (int r = 0; r < m_height; r++) {
      for (int c = 0; c < m_width; c++) {
        rot[c][m_height - 1 - r] = mat[r][c];
      }
    }
    
    return rot;
  }
  
  public static void main(String[] args) {
    int[][] mat = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
    int[][] rot = rotate(mat);
    printMats(mat, rot);
  }
  
  private static void printMats(int[][] mat, int[][] rot) {
    int m_height = mat.length;
    int m_width = mat[0].length;
    for (int r = 0; r < m_height; r++) {
      for (int c = 0; c < m_width; c++) {
        System.out.print(mat[r][c] + " ");
      }
        System.out.println();
    }
    
    System.out.println();
    
    int r_height = rot.length;
    int r_width = rot[0].length;
    for (int r = 0; r < r_height; r++) {
      for (int c = 0; c < r_width; c++) {
        System.out.print(rot[r][c] + " ");
      }
        System.out.println();
    } 
  }
}