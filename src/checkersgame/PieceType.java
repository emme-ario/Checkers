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
