/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r22;

import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Ship;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kaspe_000
 */
public class NextHit implements HitChance {

    private final static Random rnd = new Random();
    private final int sizeX;
    private final int sizeY;
    private final int[][] board;

    public NextHit(int x, int y) {
        sizeX = x;
        sizeY = y;
        board = new int[y][x];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                board[i][j] = 1;
            }
        }

    }

    @Override
    public void assignValue() {

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (board[i][j] != 0) {
                    board[i][j] = 1;
                }

            }

        }

    }

    @Override
    public Position nextHit(Fleet enemyShips, boolean noTarget) {

        if (noTarget) {
            assignValue();
            for (Ship enemyShip : enemyShips) {
                enemyShipPlacement(enemyShip);
            }
        }

        ArrayList<Position> nextShot = new ArrayList();
        int highestValue = findHighestValue();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (board[i][j] >= highestValue && board[i][j] != 0) {

                    nextShot.add(new Position(i, j));

                }

            }

        }
        int index = rnd.nextInt(nextShot.size());
        board[nextShot.get(index).x][nextShot.get(index).y] = 0;

        return nextShot.get(index);
    }

    @Override
    public void assignHitValue(Position pos) {

        //board[pos.x][pos.y] = 0;
        if (pos.x < sizeX && pos.x >= 0) {
            if (board[pos.x + 1][pos.y] != 0) {
                board[pos.x + 1][pos.y] += 50;
            }
        }
        if (pos.x <= sizeX && pos.x > 0) {
            if (board[pos.x - 1][pos.y] != 0) {
                board[pos.x - 1][pos.y] += 50;
            }
        }
        if (pos.y <= sizeY && pos.y > 0) {
            if (board[pos.x][pos.y - 1] != 0) {
                board[pos.x][pos.y - 1] += 50;
            }
        }
        if (pos.y < sizeY && pos.y >= 0) {
            if (board[pos.x][pos.y + 1] != 0) {
                board[pos.x][pos.y + 1] += 50;
            }
        }

    }

    /*public static void main(String[] args) {
     HitChance hit = new NextHit(4, 4);
     hit.assignValue();
     hit.assignHitValue(new Position(0, 0));
     hit.print();
     Position pos = hit.nextHit();
     int x = pos.x;
     int y = pos.y;
     System.out.println(y);
     System.out.println(x);

     }*/
    private int findHighestValue() {
        int temp = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (board[i][j] > temp) {
                    temp = board[i][j];
                }
            }
        }
        return temp;
    }

    private void enemyShipPlacement(Ship ship) {
        int north = 0;
        int east = 0;
        int west = 0;
        int south = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {

                if (board[i][j] != 0) {
                    for (int n = ship.size() - 1; n > 0; n--) {
                        if (j + n < sizeY && board[i][j + n] != 0) {
                            north += 1;
                        }
                        if (i + n < sizeX && board[i + n][j] != 0) {
                            east += 1;
                        }
                        if (j - n > 0 && board[i][j - n] != 0) {
                            south += 1;
                        }
                        if (i - n > 0 && board[i - n][j] != 0) {
                            west += 1;
                        }
                        if (north == ship.size() - 1) {
                            board[i][j] += 10;
                            north = 0;
                        }
                        if (east == ship.size() - 1) {
                            board[i][j] += 10;
                            east = 0;
                        }
                        if (south == ship.size() - 1 ){
                            board[i][j] += 10;
                            south = 0;
                        }
                        if (west == ship.size() - 1 ){
                            board[i][j] += 10;
                            west = 0;
                        }
                    }
                }
            }
        }

    }

    @Override
    public void print() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {

                System.out.println(board[i][j]);
            }

        }
    }

}
