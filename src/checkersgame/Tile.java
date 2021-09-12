package checkersgame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Mariottini
 */
public class Tile extends Rectangle {

    public Tile(boolean light, int x, int y) {
        setWidth(CheckersGameApp.TILESIZE);
        setHeight(CheckersGameApp.TILESIZE);
        
        relocate(x * CheckersGameApp.TILESIZE, y * CheckersGameApp.TILESIZE);
        
        setFill(light ? Color.WHITESMOKE : Color.DARKSEAGREEN);
    }
    
    private Piece piece;
    
    public boolean hasPiece() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
