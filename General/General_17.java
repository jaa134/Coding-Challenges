//Slide values in a matrix an arbitrary amount up/down and left/right
public class General_17 {
  
  public static int[][] slideDir(int[][] mat, int x, int y) {
    int m_height = mat.length;
    int m_width = mat[0].length;
    int[][] slide = new int[m_height][m_width];
    
    if (Math.abs(x) >= m_width || Math.abs(y) >= m_height)
      return slide;
    
    for (int r = 0; r < m_height; r++) {
      for (int c = 0; c < m_width; c++) {
        boolean isWithinRange_V = r - y >= 0 && r - y < m_height;
        boolean isWithinRange_H = c + x >= 0 && c + x < m_width;
        if (isWithinRange_V && isWithinRange_H)
          slide[r-y][c+x] = mat[r][c];
      }
    }
    
    return slide;
  }
  
  public static void main(String[] args) {
    int[][] mat = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
    int[][] slide = slideDir(mat, 2, -1);
    printMats(mat, slide);
  }
  
  private static void printMats(int[][] mat, int[][] slide) {
    int m_height = mat.length;
    int m_width = mat[0].length;
    for (int r = 0; r < m_height; r++) {
      for (int c = 0; c < m_width; c++) {
        System.out.print(mat[r][c] + " ");
      }
        System.out.println();
    }
    
    System.out.println();
    
    int s_height = slide.length;
    int s_width = slide[0].length;
    for (int r = 0; r < s_height; r++) {
      for (int c = 0; c < s_width; c++) {
        System.out.print(slide[r][c] + " ");
      }
        System.out.println();
    } 
  }
}