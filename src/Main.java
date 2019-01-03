import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static Scanner userInput = new Scanner(System.in);
    public static String[][] sea = new String[10][10];
    public static void main(String[] args) {

        System.out.println("***** Welcome to Battle Ships *****");

        //int x = 10;
        //int y = 10;
        displayOceanMap();
        for (int ship = 1; ship <= 5; ship++){
            System.out.println( "Enter");
            setCoordinates(ship);
        }

        displayOceanMap();
    }

    // DisplaySea will loop through a 2d Array
    // if x/y coordinate is a ship it will print @
    // if null it will print a space
    public static void displayOceanMap(){

        displayColumns(sea.length);
        for (int row = 0; row < sea.length; row++){
            System.out.print(row + " |");
            for (int col = 0; col < sea[row].length; col++){
                if (sea[row][col] == "1"){
                    System.out.print("@");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println("| " + row);
        }
        displayColumns(sea.length);
    }

    // Display Column will print the column index value to the console window
    public static void displayColumns(int numberOfColumns){
        System.out.print("   ");
        for (int col = 0; col < numberOfColumns; col++){
            System.out.print(col + "");
        }
        System.out.println();
    }

    public static void setCoordinates(int shipNumber){
        int xCoordinate;
        int yCoordinate;
        boolean check;

        do {
            System.out.print("Enter X coordinate for your ship " + shipNumber +": ");
            xCoordinate = userInput.nextInt();
            System.out.print("Enter Y coordinate for your ship " + shipNumber + ": ");
            yCoordinate = userInput.nextInt();
        } while (check = checkCoordinate(xCoordinate, yCoordinate));
        if (!check){
            sea[xCoordinate][yCoordinate] = "1";
        }
    }

    public static boolean checkCoordinate(int x, int y){
        if(x == y){
            return true;
        }
        else{
            return false;
        }

    }
}
