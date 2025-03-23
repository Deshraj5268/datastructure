package interviewpractice.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {

   private static Grid grid;
   private Map<String, List<Corners>> shipBoard;
   private int size;

   private Grid(int size){
      this.size = size;
      this.shipBoard = new HashMap<>();
   }

   public static Grid initializeGrid(int size){
      if(grid == null){
         grid = new Grid(size);
      }
      return grid;
   }
}
