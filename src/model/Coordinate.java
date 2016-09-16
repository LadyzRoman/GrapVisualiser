package model;

import java.awt.*;

/**
 * Created by Сергей on 12.07.2016.
 */
public class Coordinate
{
    private double x;
    private double y;
    private Coordinate prev;
    private Graph graph;

    public Coordinate(double x, double y, Coordinate prev, Graph graph)
    {
        this.x = x;
        this.y = y;
        this.prev = prev;
        this.graph = graph;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        if (prev != null)
        {
            if (Double.isNaN(prev.y) || Double.isNaN(y))
                return;
            int x1 = (int) prev.x + graph.getX0();
            int y1 = (int) prev.y + graph.getY0();
            int x2 = (int) x + graph.getX0();
            int y2 = (int) y + graph.getY0();
            if (x2 < 0 || x1 > Graph.SIZE) return;
            if ((y1 > Graph.SIZE && y2 > Graph.SIZE)||(y1 < 0 && y2 < 0)) return;

            g.setColor(Color.DARK_GRAY);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (Double.compare(that.x, x) != 0) return false;
        return Double.compare(that.y, y) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
