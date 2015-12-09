/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r22v4;

/**
 *
 * @author kaspe_000
 */
import battleship.interfaces.Board;
import battleship.interfaces.Position;

public class Heatmap {
    private int[][] board;

    public Heatmap(Board board) {
        this.board = new int[board.sizeX()][board.sizeY()];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.board[i][j] = 1;
            }
        }
    }
    public void heatArea (Position pos) {
        board[pos.x][pos.y] +=1;
    }
    
    public int[][] getBoard(){
        return board;
    }
    
}

