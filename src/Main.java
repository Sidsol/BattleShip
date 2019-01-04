import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner userInput = new Scanner(System.in);
    public static String[][] sea = new String[10][10];
    public static Random random = new Random();
    public static int playerScore = 5;
    public static int npcScore = 5;

    public static void main(String[] args) {
        char pc = 'U';
        char npc = 'C';


        System.out.println("***U** Welcome to Battle Ships *****");

        displayOceanMap();

        deployShips(pc,5);
        deployShips(npc, 5);

        //game loop
        do {
            displayOceanMap();
            displayScore();
            takeTurn(pc);
            takeTurn(npc);

        }while ( playerScore > 0 || npcScore > 0 );
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
                else if (sea[row][col] == "2"){
                    System.out.print(sea[row][col]);
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

    //Set initial coordinates for ships
    public static void setCoordinates(char player, int xCoordinate,int yCoordinate){
            if(player == 'U'){
                sea[xCoordinate][yCoordinate] = "1";
            }
            else{
                sea[xCoordinate][yCoordinate] = "2";
            }
    }

    //
    public static boolean checkCoordinate(int x, int y){
        if (x < 10  && y < 10) {
            if (sea[x][y] == null) {
                return false;
            }
            else{
                return true;
            }
        }
        else{
            System.out.println("Coordinates are out of bounds, please choose again!");
            return true;
        }
    }

    //This function will determine the number of ships to be deployed and assigned to which player.
    public static void  deployShips(char player, int maxShips){
        int xCoordinate;
        int yCoordinate;

        //iterate through the number a ships and sets their coordinate accordingly
        for (int ship = 1; ship <= maxShips; ship++){

            do {
                //Asks the player character for each ships coordinates
                if (player == 'U') {
                    System.out.print("Enter X coordinate for your ship " + ship + ": ");
                    xCoordinate = userInput.nextInt();
                    System.out.print("Enter Y coordinate for your ship " + ship + ": ");
                    yCoordinate = userInput.nextInt();
                }
                //Uses random class to set coordinates for the non player characters ships
                else {
                    xCoordinate = random.nextInt(10);
                    yCoordinate = random.nextInt(10);
                }

            } while (checkCoordinate(xCoordinate, yCoordinate));
            setCoordinates(player, xCoordinate, yCoordinate);
        }
    }

    public static void takeTurn (char player){
        int xCoordinate;
        int yCoordinate;

        if (player == 'U'){
            System.out.println("YOUR TURN");
            System.out.print("Enter X coordinate: ");
            xCoordinate = userInput.nextInt();
            System.out.print("Enter Y coordinate: ");
            yCoordinate = userInput.nextInt();
            if (checkCoordinate(xCoordinate, yCoordinate)){
                if (sea[xCoordinate][yCoordinate] == "1"){
                    System.out.println("Oh no, you sunk your own ship :(");
                    sea[xCoordinate][yCoordinate] = "x";
                    npcScore--;
                }
                else {
                    System.out.println("Boom! You sunk the ship!");
                    sea[xCoordinate][yCoordinate] = "!";
                    playerScore--;
                }
            }
            else {
                System.out.println("You missed");
                sea[xCoordinate][yCoordinate] = "-";
            }
        }
        else {
            System.out.println("COMPUTER'S TURN");
            xCoordinate = random.nextInt(10);
            yCoordinate = random.nextInt(10);
            if (checkCoordinate(xCoordinate, yCoordinate)){
                if (sea[xCoordinate][yCoordinate] == "2"){
                    System.out.println("The Computer sunk one of its own ships.");
                    sea[xCoordinate][yCoordinate] = "!";
                    playerScore--;
                }
                else {
                    System.out.println("The Computer sunk one of your ships!");
                    sea[xCoordinate][yCoordinate] = "x";
                    npcScore--;
                }
            }
            else {
                System.out.println("Computer missed");
            }
        }
    }
    public static void displayScore(){
        System.out.println("Your ships: " + playerScore + " | Computer ships: " + npcScore);
        System.out.println("------------------------------------");
    }
}
