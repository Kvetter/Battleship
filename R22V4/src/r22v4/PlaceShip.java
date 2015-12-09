/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r22v4;

import battleship.interfaces.Board;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Ship;
import java.util.Random;

/**
 *
 * @author kaspe_000
 */
public class PlaceShip {

    private int[][] myBoard;
    private int sizeX;
    private int sizeY;
    private Random rng = new Random();

    public PlaceShip(Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        myBoard = new int[board.sizeX()][board.sizeY()];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                myBoard[i][j] = 1;
            }
        }
        
        }

    public void updateBoard(int[][] board){
        myBoard = board;
    }
    
    public Position placeShip(Ship ship, boolean vertical) {

        int i;
        int j;
        while (true) {
            if (vertical) {
                i = rng.nextInt(sizeX);
                j = rng.nextInt(sizeY - (ship.size() - 1));
            } else {
                i = rng.nextInt(sizeX - (ship.size() - 1));
                j = rng.nextInt(sizeY);
            }

            if (vertical) {
                boolean canPlace = true;
                if (myBoard[i][j] != 0 && myBoard[i][j + ship.size() - 1] <= sizeY) {
                    for (int l = 0; l < ship.size(); l++) {
                        if (myBoard[i][j + l] == 0) {
                            canPlace = false;
                        }
                    }
                } else {
                    canPlace = false;
                }
                if (canPlace) {
                    for (int l = 0; l < ship.size(); l++) {
                        myBoard[i][j + l] = 0;
                    }
                    return new Position(i, j);
                }
            } else {
                boolean canPlace = true;
                if (myBoard[i][j] != 0 && myBoard[i + ship.size() - 1][j] <= sizeX) {
                    for (int l = 0; l < ship.size(); l++) {
                        if (myBoard[i + l][j] == 0) {
                            canPlace = false;
                        }
                    }
                } else {
                    canPlace = false;
                }
                if (canPlace) {
                    for (int l = 0; l < ship.size(); l++) {
                        myBoard[i + l][j] = 0;
                    }
                    return new Position(i, j);
                }
            }
        }
    }
}
