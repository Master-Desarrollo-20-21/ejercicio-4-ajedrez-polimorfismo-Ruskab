package ikab.dev;

import ikab.dev.io.ConsoleReader;
import ikab.dev.io.ConsoleWritter;
import ikab.dev.pieces.PieceType;

public class Chess {

    private boolean isWhiteTurn;
    private Board board;
    private ConsoleReader consoleReader ;
    private ConsoleWritter consoleWritter ;


    public Chess() {
        this.board = new Board();
        this.isWhiteTurn = true;
        this.consoleReader = new ConsoleReader();
        this.consoleWritter = new ConsoleWritter();
    }

    public void play() {
        do {
            board.print();
            if (isWhiteTurn) {
                PlayerMovement playerMovement;
                do {
                    playerMovement = readPlayerMovement();
                } while (!playerMovement.isValidPlayerMovement(board));
                playerMovement.makePlayerMovement(board);
            } else {
                makeAutomaticRivalMove();
            }
            this.toggleTurn();
        } while (!isEndGame());
        this.printWinner();
    }

    private void toggleTurn() {
        isWhiteTurn = !isWhiteTurn;
    }

    private void printWinner() {
        if (isWinner(isWhiteTurn, false)) {
            consoleWritter.printPlayerIsWinner(false);
        } else {
            consoleWritter.printPlayerIsWinner(true);
        }
    }

    private void makeAutomaticRivalMove() {
        //TODO make IA random movement algorithm
    }

    private PlayerMovement readPlayerMovement() {
        Piece piece = consoleReader.readPiece();
        Position destination = consoleReader.readDestination();
        return new PlayerMovement(piece, destination);
    }

    private boolean isEndGame() {
        return isWinner(isWhiteTurn, false) || isWinner(!isWhiteTurn, true);
    }

    private boolean isWinner(boolean isWhiteTurn, boolean isWhitePiece) {
        return isWhiteTurn && !board.containsPiece(PieceType.KING, isWhitePiece);
    }

}

