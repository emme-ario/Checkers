package checkersgame;

/**
 *
 * @author Mariottini
 */
public class MoveResult {
    
    private MoveType type;
    
    public MoveResult(MoveType type) {
        this(type, null);
    }
    
    public MoveResult(MoveType type, Piece piece) {
        this.type = type;
        this.piece = piece;
    }
    
    public MoveType getType() {
        return type;
    }
    
    private Piece piece;
    
    public Piece getPiece() {
        return piece;
    }
}
