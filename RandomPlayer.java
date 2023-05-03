import java.util.*; //importing the util labrairy to be able to use random objects

/**
 * RandomPlayer
 */
public class RandomPlayer extends Player {

    /**
     * @param board this parameter is a board object that we will use to get the
     *              board rows and coulmns from
     * @return this will return the Move object after we modify the getting the random number
     */
    int makePlayerMove(BoardObject board){
        Random random = new Random();//creating a Random object
        int randomIndex = random.nextInt(board.getColumnSize());//geeting a random number that the range with respect to the coumns size of the board
        
        // // create the object that I will return
        // Move move = new Move(randomIndex);

        // return the object
        return randomIndex;
    };

    char getPlayerType(){
        return 'K';
    }
    
}
