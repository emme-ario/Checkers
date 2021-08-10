package checkersgame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * CheckersGame pieces class
 * 
 * @author Mariottini
 */
public class Piece {
    
    private double x;
    private double y;
    private double radius;
    private Circle c;

    public Piece(double x, double y, double radius, Circle c) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.c = c;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void setColor(Color color) {
        c.setFill(color);
    }
    
    public void draw() {
        c.setRadius(radius);
        c.setTranslateX(x);
        c.setTranslateY(y);
        
    }
}
