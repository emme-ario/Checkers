package checkersgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * CheckersGame application class
 * 
 * @author Mariottini
 */

public class CheckersGameApp extends Application {
  
    public static final int TILESIZE = 100; //field dimensions
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    
    private Tile[][] board = new Tile[WIDTH][HEIGHT];
    
    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();
    
    public Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILESIZE, HEIGHT * TILESIZE);
        root.getChildren().addAll(tileGroup, pieceGroup);
        
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile tile = new Tile((x + y) % 2 == 0, x, y);
                board[x][y] = tile;
                
                tileGroup.getChildren().add(tile);
                
                Piece piece = null;
                
                if (y <= 2 && (x + y) % 2 != 0) {
                    piece = makePiece(PieceType.PURPLE, x, y);
                }
                
                if (y >= 5 && (x + y) % 2 != 0) {
                    piece = makePiece(PieceType.YELLOW, x, y);
                }
                
                if (piece != null) {
                    tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
        }
        
        return root;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("CheckersGame");
        primaryStage.setScene(scene);
        primaryStage.show();
  }
    
    private Piece makePiece(PieceType type, int x, int y) {
        Piece piece = new Piece(type, x, y);
        
        return piece;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}