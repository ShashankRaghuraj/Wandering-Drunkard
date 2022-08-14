import java.lang.Math;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
      //creates a map
      int count = 0;
      char[][] map = new char[11][11];
      //cool box thingy
      char box = '.';
      int row = 5;
      int col = 5;
      Scanner reader = new Scanner(System.in);
      String direction = "static";
      int[] endPosition = new int[2];
      int[] startPosition = {col+1,row+1};
      //For loop logic
      while(true)
      {
        System.out.println("Direction Moved: " + direction + "\nAmount of Times Moved: " + count);
        count++; 
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i != row || j != col) {
                    map[i][j] = box;
                } else {
                    map[row][col] = 'X';
                }
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        int range = (3) + 1;
        int randomNumber = (int) (Math.random() * range) + 1;
        switch (randomNumber) {
            case 1:
                direction = "North";
                row -= 1;
                break;
            case 2:
                direction = "South";
                row += 1;
                break;
            case 3:
                direction = "East";
                col += 1;
                break;
            case 4:
                direction = "West";
                col -= 1;
                break;
            default:
                direction = "static";
          }
          System.out.println("Press enter to continue: ");
          reader.nextLine();
        if(row > map.length-2 || col > map[0].length-2 || row < 0 || col < 0)
        {
          for (int i = 0; i < map.length; i++) 
          {
            for (int j = 0; j < map[0].length; j++) {
                if (i != row || j != col) {
                    map[i][j] = box;
                } else {
                    endPosition[0] = col+1;
                    endPosition[1] = row+1;
                    map[row][col] = 'X';
                }
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
          }
          break;
        }
      }
      double y = Math.abs(endPosition[0] - startPosition[0]);
      double x = Math.abs(endPosition[1] - startPosition[1]); 
      double distance = Math.hypot(y, x);
      System.out.println("It took " + (count-1) + " times for the drunk man to move out of the map");
      System.out.println("It should have taken approximately " + Math.round(distance) + " steps to get outside");
    }
}
