import java.util.Scanner;

/**
 * HumanPlayer
 */
public class HumanPlayer extends Player {

    
    /**
     * @param board this parameter is a board object that we will use to get the
     *              board rows and coulmns from
     * @return this will return the Move object after we modify the getting the random number
     */
    int makePlayerMove(BoardObject board){

        Scanner scannerObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Column you want to player at:");

        String fullinput = scannerObj.nextLine();  // Read user input

        char firstChar = fullinput.charAt(0);

        int numInput = firstChar - '0';
        
        // create the object that I will return
        // Move move = new Move(numInput);

        // return the object
        return numInput;
    };

    char getPlayerType(){
        return 'O';
    }
    
}