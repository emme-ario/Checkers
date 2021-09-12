/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkersgame;

/**
 *
 * @author Mariottini
 */
public enum PieceType {
    PURPLE(1), YELLOW(-1);
    
    final int moveDir;

    private PieceType(int moveDir) {
        this.moveDir = moveDir;
    }
    
    
}
