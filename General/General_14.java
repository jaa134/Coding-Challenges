//Given a 2D array of 1s and 0s, count the number of "islands of 1s" (e.g. groups of connecting 1s)
public class General_14 {
  
  public static int countIslands(int[][] map) {
    int numRows = map[0].length;
    int numCols = map.length;
    
    int sum = 0;
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        if (map[r][c] == 1) {
          boolean isTopOne = r > 0 && map[r - 1][c] == 1;
          boolean isLeftOne = c > 0 && map[r][c - 1] == 1;
          boolean isBottomOne = r < numRows - 1 && map[r + 1][c] == 1;
          boolean isRightOne = c < numCols - 1 && map[r][c + 1] == 1;
          //if alone 1's are counted, then we wouldnt have to check if the right or bottom is also a one
          if (!(isTopOne || isLeftOne) && (isRightOne || isBottomOne))
            sum++;
        }
      }
    }
    return sum;
  }
  
  public static void main(String[] args) {
    int[][] map = new int[][] {
      {1,1,0,1},
      {0,1,0,0},
      {1,0,1,1},
      {1,0,0,1}
    };
    
    System.out.println(countIslands(map));
  }
  
}