package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Сергей on 08.07.2016.
 */
public class View extends JFrame
{
    private Controller controller;
    private MenuPanel menu = new MenuPanel(this);
    private GraphView graph = new GraphView(this);

    Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public View()
    {
        init();
    }

    private void init()
    {
        addKeyListener(new KeyAdapterImpl());
        setTitle("Визуализатор графиков");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(menu, BorderLayout.SOUTH);
        add(graph, BorderLayout.CENTER);
        setFocusable(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class KeyAdapterImpl extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_ADD:
                    controller.resize(-10);
                    break;
                case KeyEvent.VK_SUBTRACT:
                    controller.resize(10);
                    break;
                case KeyEvent.VK_RIGHT:
                    controller.move(-1, 0);
                    break;
                case KeyEvent.VK_LEFT:
                    controller.move(1, 0);
                    break;
                case KeyEvent.VK_UP:
                    controller.move(0, 1);
                    break;
                case KeyEvent.VK_DOWN:
                    controller.move(0, -1);
                    break;
            }
        }
    }

    public String getFunction()
    {
        return menu.getFunction();
    }

    public String getMinX()
    {
        return menu.getMinX();
    }


    public String getMaxX()
    {
        return menu.getMaxX();
    }

    public String getStep()
    {
        return menu.getStep();
    }


    public void update()
    {
        graph.repaint();
    }

    public void requestFunction()
    {
        menu.requestFunction();
    }

}
