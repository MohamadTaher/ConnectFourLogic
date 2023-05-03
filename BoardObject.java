

public class BoardObject {

    //The defult two demntion boardData that holds players
    private Player boardData[][];

    //Storing the size of the rows and columns in the array (we get this one from constructor)
    private int rowSize;
    private int columnSize;

    // creating a default player 1, player 2 and player 3.
    Player player1;
    Player player2;
    Player player3;
    

    /**
     * This method is for making the move logic for when we use it inside the
     * connect four class
     * @param moveColumn the coulmn we will make the move at
     * @param player the player that will make the move for
     * @return true if it possible to make a move
     */
    boolean boardMakeMove(int moveInputColumn, Player player) {
        
        int moveColumn = moveInputColumn - 1; // the coulmn that we will use inside the board (the place we play at)
        int currentRow = rowSize - 1; // the value is the one we have inside the class

        // make sure we are in bound
        if (moveColumn < 0 || moveColumn >= columnSize) {
            return false;
        }

        if (boardData[currentRow][moveColumn] == null) { // check if the place to play is empty or not
            boardData[currentRow][moveColumn] = player; // if empty then play on the board by changing to player
            return true;
        } else {

            // the curent row to keep track on where we are on the board
            currentRow = rowSize - 1;


            while (currentRow >= 0 && !(boardData[currentRow][moveColumn] == null)) { // while the move postion is not empty

                // check if we are out of bounds
                if (currentRow <= 0) {
                    currentRow++;
                    return false;
                }

                // decrese the crurrent row by one to be used as counter to check the above row
                // if empty or not
                currentRow--;

                // after decreasing the current row by one, we need to check if the above row is
                // empty or not
                if (boardData[currentRow][moveColumn] == null) {
                    // if empty then the player move on the board
                    boardData[currentRow][moveColumn] = player;

                    return true; // the loop will stop after finding a none empty spot and printing the player
                    // move
                }
            }

            return false;
        
        }
    }


    /**
     * public constructor that doesn't take anything and only intulize boardData and set row/coulmns to default
     * @param rowSize   the rows I will take as the board length
     * @param columnSize the rows I will take as the board wideth
     */
    public BoardObject(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.boardData = new Player[rowSize][columnSize];
        initializeDefaultBoardData(boardData);
    }


    /**
     * This method will access the board to get the how many rows
     * @return the lenght of first demension of the array that represent rows
     */
    public int getRowSize() {
        return rowSize;
    }

    /**
     * This method will access the board to get the how many Columns
     * @return the lenght of second demension of the array that represent Columns
     */
    public int getColumnSize() {
        return columnSize;
    }

    /**
     * geting the player at the current location for boardshow to use as output
     * @param row    this one will return the row of the player at the current loaction
     * @param column this one will return the row of the player at the current loaction
     * @return player at location
     */
    public Player getPlayerAtLocation(int row, int column) {
        return boardData[row][column];
    }

    /**
     * intulizing the boardData to null
     * @param player the boardData we want to intulize as parameter
     */
    private void initializeDefaultBoardData(Player[][] player) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                player[i][j] = null;
            }
        }
    }

    public void printboardData() {

        // Irritat throgh all the elements inside the two dimantional
        // (rows and columns/ i for rows and j for coulmns) array and print them all
        for (int i = 0; i < rowSize; i++) {
            System.out.print(i+ ": ");

            for (int j = 0; j < columnSize; j++) {
                if (boardData[i][j] != null) {
                    System.out.print(" "+boardData[i][j].getPlayerType());
                } else{
                    System.out.print(" -");

                }
            }
            System.out.println();
        }

    }


    /**
     * This method is to check if any player won
     * 
     * @return return which player among the players won as player type
     */
    Player win() {
        // check for for any winning condtion by checking condtions
        // (horizantal/virtical/diagnal/invirse diagnal)
        
        
        // check for 4 pieces across for humanPlayer
        for (int i = 0; i < boardData.length; i++) {
            for (int j = 0; j < boardData[0].length - 3; j++) {
                if (boardData[i][j] == boardData[i][j + 1] && boardData[i][j] == boardData[i][j + 2] && boardData[i][j] == boardData[i][j + 3]
                        && boardData[i][j] != null) {
                    return boardData[i][j];
                }
            }
        }
        // check for 4 up and down
        for (int i = 0; i < boardData.length - 3; i++) {
            for (int j = 0; j < boardData[0].length; j++) {
                if (boardData[i][j] == boardData[i + 1][j] &&
                        boardData[i][j] == boardData[i + 2][j] &&
                        boardData[i][j] == boardData[i + 3][j] && boardData[i][j] != null) {
                    return boardData[i][j];
                }
            }
        }
        // check upward diagonal
        for (int i = 3; i < boardData.length; i++) {
            for (int j = 0; j < boardData[0].length - 3; j++) {
                if (boardData[i][j] == boardData[i - 1][j + 1] &&
                        boardData[i][j] == boardData[i - 2][j + 2] &&
                        boardData[i][j] == boardData[i - 3][j + 3] && boardData[i][j] != null) {
                    return boardData[i][j];
                }
            }
        }

        // check downward diagonal
        for (int i = 0; i < boardData.length - 3; i++) {
            for (int j = 0; j < boardData[0].length - 3; j++) {
                if (boardData[i][j] == boardData[i + 1][j + 1] &&
                        boardData[i][j] == boardData[i + 2][j + 2] &&
                        boardData[i][j] == boardData[i + 3][j + 3] && boardData[i][j] != null) {
                    return boardData[i][j];
                }
            }
        }
        return null;
    }



}
