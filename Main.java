/**
 * Main
 */
public class Main {

    public static int rowSize = 3;
    public static int columnSize = 6;
    public static void main(String[] args) {
        //Storing the size of the rows and columns in the array (we get this one from constructor)

        BoardObject boardObject = new BoardObject(rowSize, columnSize);

        //defualt values and variables
        HumanPlayer humanPlayer1 = new HumanPlayer();
        HumanPlayer humanPlayer2 = new HumanPlayer();
        RandomPlayer ai = new RandomPlayer();
        int madeMove;

        
        while (boardObject.win()== null) {
            
            // make the human move
            while (true) {
                madeMove = humanPlayer1.makePlayerMove(boardObject);
                if (boardObject.boardMakeMove(madeMove, humanPlayer1) == true) {
                    break;
                }
            }

            if (boardObject.win()==  humanPlayer1) {
                boardObject.printboardData();
                break;
            }
            //make the ai move
            while (true) {
                madeMove = ai.makePlayerMove(boardObject);
                if (boardObject.boardMakeMove(madeMove + 1, ai) == true) {
                    break;
                }
            }
            
            boardObject.printboardData();
            

        }

        //check who won
        if (boardObject.win() == humanPlayer1) {
            System.out.println("First human player Won"); 
        } else if(boardObject.win() == humanPlayer2){
            System.out.println("Second human player Won"); 
        } else if(boardObject.win() == ai){
            System.out.println("AI player Won the game"); 
        }



    }



}