package checkersgame;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * CheckersGame controller class
 *
 * @author Mariottini
 */
public class CheckersGameController {

    @FXML
    Pane pane;
    
    private int size = 800; //field dimensions
    private int tiles = 8; //number of tiles in a row
    private int tileSize = size / tiles; //size of every single tile
            
    private int x = tileSize / 2, y = tileSize / 2; //start position for placing pieces
    
    private ArrayList<Piece> pieces;
    
    private Rectangle[][] grid;
    
    @FXML
    public void initialize() {
        //create checkboard
        grid = new Rectangle[tiles][tiles];
        for (int i = 0; i < size; i += tileSize) {
            for (int j = 0; j < size; j += tileSize) {
                Rectangle r = new Rectangle(i, j, tileSize, tileSize);
                grid[i / tileSize][j / tileSize] = r;
                if ((j / tileSize) % 2 == 0)
                    if ((i / tileSize) % 2 == 0)
                        r.setFill(Color.WHITE);
                    else
                        r.setFill(Color.GRAY);
                else
                    if ((i / tileSize) % 2 == 0)
                        r.setFill(Color.GRAY);
                    else
                        r.setFill(Color.WHITE);
                r.setStroke(Color.BLACK);
                pane.getChildren().add(r);
            }
        }
        pieces = new ArrayList<Piece>();
        
        //Black Team pieces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                
                //Created
                Circle c = new Circle();
                c.setFill(Color.BLACK);
                c.setStroke(Color.BLACK);
                double radius = tileSize / 3.0;
                if (j % 2 == 0)
                    if (i % 2 == 0)
                        x = tileSize + tileSize / 2 + tileSize * j;
                    else
                        x = tileSize / 2 + tileSize * j;
                else {
                    radius = 0;
                    c.setStroke(Color.TRANSPARENT);
                }
                Piece p = new Piece(x, y, radius, c);
                pieces.add(p);
                
                //Made draggable
                c.setOnMousePressed(event -> pressed(event, p));
                c.setOnMouseDragged(event -> dragged(event, p));
                c.setOnMouseReleased(event -> released(event, p));
                
                pane.getChildren().add(c);
                p.draw();
            }
            y += tileSize;
        }
        
        //White Team pieces
        y = size - tileSize / 2;
        int flag = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                
                //Created
                Circle c = new Circle();
                c.setFill(Color.WHITE);
                c.setStroke(Color.BLACK);
                double radius = tileSize / 3.0;
                if (j % 2 == 0)
                    if (i % 2 == 0)
                        x = tileSize / 2 + tileSize * j;
                    else
                        x = tileSize + tileSize / 2 + tileSize * j;
                else {
                    radius = 0;
                    c.setStroke(Color.TRANSPARENT);
                }
                Piece p = new Piece(x, y, radius, c);
                pieces.add(p);
                
                //Made draggable
                c.setOnMousePressed(event -> pressed(event, p));
                c.setOnMouseDragged(event -> dragged(event, p));
                c.setOnMouseReleased(event -> released(event, p));
                
                pane.getChildren().add(c);
                p.draw();
            }
            y -= tileSize;
        }
    }
        
    public void pressed(MouseEvent event, Piece p) {
        //do something
        /*********************************************************************/
        p.setColor(Color.HOTPINK);                     //(Just to try somthing)
        /*********************************************************************/
    }
    
    public void dragged(MouseEvent event, Piece p) {
        p.setX(p.getX() + event.getX());
        p.setY(p.getY() + event.getY());
        p.draw();
    }
    
    public void released(MouseEvent event, Piece p){
        int gridX = (int)p.getX() / tileSize;
        int gridY = (int)p.getY() / tileSize;
        p.setX(tileSize / 2 + tileSize * gridX);
        p.setY(tileSize / 2 + tileSize * gridY);
        /*********************************************************************/
        grid[gridX][gridY].setFill(Color.GREENYELLOW); //(Just to try somthing)
        /*********************************************************************/
        p.draw();
    }
}
