import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
	System.out.println("***** Welcome to Battle Ships *****");
	int x = 10;
	int y = 10;


	DisplaySea(x, y);

    }
    public static void DisplaySea(int x, int y){
        char[][] sea = new char[x][y];
        displayColumns(sea.length);
        for (int row = 0; row < sea.length; row++){
            System.out.print(row + " |");
            for (int col = 0; col < sea[row].length; col++){
                System.out.print(" ");
            }
            System.out.println("| " + row);
        }
        displayColumns(sea.length);
    }
    public static void displayColumns(int numberOfColumns){
        System.out.print("   ");
        for (int col = 0; col < numberOfColumns; col++){
            System.out.print(col + "");
        }
        System.out.println();
    }


}
