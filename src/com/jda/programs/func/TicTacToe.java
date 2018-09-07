package com.jda.programs.func;

import static com.jda.programs.func.TicTacToe.Cell.O;
import static com.jda.programs.func.TicTacToe.Cell.X;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.jda.util.Printer;

public class TicTacToe {
  enum Cell {
    EMPTY, X, O;
    
    public boolean isNonEmpty() {
      return this != EMPTY;
    }
    
    @Override
    public String toString() {
      switch (this) {
        case EMPTY:
          return "-";
        case X:
          return "X";
        case O:
          return "O";
      }
      return " ";
      
    }
  }
  
  static class TTTGame {
    public static final int BOARD_SIZE = 3;
    boolean                 pxTurn     = true;
    Cell[][]                board;
    int                     turnCount;
    Cell                    winner;
    private Cell            lastPlayer;
    private int             lastPlayedX;
    private int             lastPlayedY;
    
    TTTGame() {
      turnCount = 0;
      winner = Cell.EMPTY;
      board = new Cell[BOARD_SIZE][BOARD_SIZE];
      for (int i = 0; i < BOARD_SIZE; i++) {
        for (int j = 0; j < BOARD_SIZE; j++) {
          board[i][j] = Cell.EMPTY;
        }
      }
    }
    
    private Cell cellAt(int cell) {
      return board[cell / BOARD_SIZE][cell % BOARD_SIZE];
    }
    
    void declareResult() {
      if (winnerFound()) {
        System.out.println("The winner is " + X);
      } else {
        System.out.println("The game ended in a draw");
      }
    }
    
    private void displayBoard() {
      Printer.printArray(board, BOARD_SIZE, BOARD_SIZE);
    }
    
    private boolean downwardWin() {
      return IntStream.range(0, BOARD_SIZE).allMatch(i -> board[i][i].equals(lastPlayer));
    }
    
    private boolean horizontalWin() {
      return IntStream.range(0, BOARD_SIZE).allMatch(i -> board[lastPlayedX][i].equals(lastPlayer));
    }
    
    private int location(int row, int column) {
      return row * BOARD_SIZE + column;
    }
    
    boolean playNext() {
      if (turnCount == 9) return false;
      if (pxTurn) {
        playX();
      } else {
        playO();
      }
      displayBoard();
      switchTurn();
      return true;
    }
    
    void playO() {
      int step = takeInput();
      set(step, O);
      if (winningPosition(O, step)) {
        winner = O;
      }
    }
    
    void playX() {
      int step = randomCell();
      set(step, X);
      if (winningPosition(X, step)) {
        winner = X;
      }
    }
    
    private int randomCell() {
      Random random = new Random();
      int cell;
      do {
        cell = random.nextInt(BOARD_SIZE * BOARD_SIZE);
      } while (cellAt(cell).isNonEmpty());
      return cell;
    }
    
    private void set(int i, Cell cell) {
      board[i / BOARD_SIZE][i % BOARD_SIZE] = cell;
    }
    
    private void switchTurn() {
      pxTurn = !pxTurn;
    }
    
    private int takeInput() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter row : ");
      int row = scanner.nextInt();
      System.out.println("Enter column : ");
      int column = scanner.nextInt();
      return location(row, column);
    }
    
    private boolean upwardWin() {
      return IntStream.range(0, BOARD_SIZE)
          .allMatch(i -> board[i][BOARD_SIZE - i - 1].equals(lastPlayer));
    }
    
    private boolean verticalWin() {
      return IntStream.range(0, BOARD_SIZE).allMatch(i -> board[i][lastPlayedY].equals(lastPlayer));
    }
    
    // public isCompleted()
    private boolean winnerFound() {
      return winner.isNonEmpty();
    }
    
    private boolean winningPosition(Cell cell, int step) {
      lastPlayer = cell;
      lastPlayedX = step / BOARD_SIZE;
      lastPlayedY = step % BOARD_SIZE;
      return verticalWin() || horizontalWin() || downwardWin() || upwardWin();
    }
  }
  
  public static void main(String[] args) {
    TTTGame game = new TTTGame();
    while (game.playNext())
      if (game.winnerFound()) {
        break;
      }
    game.declareResult();
  }
}
