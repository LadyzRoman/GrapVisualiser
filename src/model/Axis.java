package model;

import java.awt.*;

/**
 * Created by Сергей on 12.07.2016.
 */
public class Axis
{
    private Graph graph;

    Axis(Graph graph)
    {
        this.graph = graph;
    }

    public void draw(Graphics g)
    {
        int size = Graph.SIZE;
        int x = size / 2 + graph.getX0();
        int y = size / 2 + graph.getY0();
        //draw axis
        g.setColor(Color.DARK_GRAY);
        g.drawLine(x, 0, x, size);
        g.drawLine(0, y, size, y);
        //draw dots
        g.setColor(Color.BLACK);
        for (int i = x, number = 0; i < size; i += graph.getD(), number++)
            drawDot(g, i, y, number);

        for (int i = x, number = 0; i > 0; i -= graph.getD(), number--)
            drawDot(g, i, y, number);

        for (int i = y, number = 0; i > 0; i -= graph.getD(), number++)
            drawDot(g, x, i, number);

        for (int i = y, number = 0; i < size; i += graph.getD(), number--)
            drawDot(g, x, i, number);
    }

    private void drawDot(Graphics g, int x, int y, int number)
    {
        g.fillOval(x, y, 2, 2);
        if (graph.getD() < Graph.SIZE / 30 && number % 5 == 0 || graph.getD() >= Graph.SIZE / 30)
            g.drawString(String.valueOf(number), x, y);
    }
}
