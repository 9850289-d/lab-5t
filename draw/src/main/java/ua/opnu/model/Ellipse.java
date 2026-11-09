package ua.opnu.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends DrawShape {

    public Ellipse() {}

    public Ellipse(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    // Для відтворення еліпса використовуємо клас Ellipse2D.Double
    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        return new Ellipse2D.Double(
                Math.min(startPoint.getX(), endPoint.getX()),
                Math.min(startPoint.getY(), endPoint.getY()),
                Math.abs(startPoint.getX() - endPoint.getX()),
                Math.abs(startPoint.getY() - endPoint.getY())
        );
    }
}