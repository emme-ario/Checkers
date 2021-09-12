/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkersgame;

import static checkersgame.CheckersGameApp.TILESIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Mariottini
 */
public class Piece extends StackPane {
    
    private PieceType type;
    
    public Piece(PieceType type, int x, int y) {
        this. type = type;
        
        relocate(x * TILESIZE, y * TILESIZE);
        
        Ellipse bg = new Ellipse(TILESIZE * 0.3125, TILESIZE * 0.26);
        bg.setFill(Color.BLACK);
        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(TILESIZE * 0.03);
        bg.setTranslateX((TILESIZE - TILESIZE * 0.3125 * 2) / 2);
        bg.setTranslateY((TILESIZE - TILESIZE * 0.26 * 2) / 2 + TILESIZE * 0.07);
        
        Ellipse ellipse = new Ellipse(TILESIZE * 0.3125, TILESIZE * 0.26);
        ellipse.setFill(type == PieceType.PURPLE ? Color.BLUEVIOLET : Color.ORANGE);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILESIZE * 0.03);
        ellipse.setTranslateX((TILESIZE - TILESIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((TILESIZE - TILESIZE * 0.26 * 2) / 2);
        
        getChildren().addAll(bg, ellipse);
    }
    
    public PieceType getType() {
        return type;
    }
}
