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
    
    private double mouseX, mouseY;
    private double oldX, oldY;
    
    public PieceType getType() {
        return type;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }
    
    public Piece(PieceType type, int x, int y) {
        this. type = type;
        
        move(x, y);
        
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
        
        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });
        
        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }
    
    public void move(int x, int y) {
        oldX = x * TILESIZE;
        oldY = y * TILESIZE;
        relocate(oldX, oldY);
    }
    
    public void abortMove() {
        relocate(oldX, oldY);
    }
}
