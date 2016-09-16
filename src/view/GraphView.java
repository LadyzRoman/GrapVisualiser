package view;

import model.Axis;
import model.Coordinate;
import model.Graph;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Сергей on 12.07.2016.
 */
public class GraphView extends JPanel
{
    private View view;

    GraphView(View view)
    {
        this.view = view;
        init();
    }

    private void init()
    {
        setPreferredSize(new Dimension(Graph.SIZE, Graph.SIZE));
    }

    @Override
    public void paint(Graphics g)
    {
        java.util.List<Coordinate> coordinates = getCoordinates();
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, getWidth(), getHeight());
        getAxis().draw(g);
        coordinates.forEach(c -> c.draw(g));
    }

    private java.util.List<Coordinate> getCoordinates()
    {
        return view.getController().getCoordinates();
    }

    private Axis getAxis()
    {
        return view.getController().getAxis();
    }
}
