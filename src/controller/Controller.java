package controller;

import model.Axis;
import model.Coordinate;
import model.Graph;
import model.ReversePolishNotationCreator;
import view.View;

import javax.swing.*;
import java.util.List;


public class Controller
{
    private View view;
    private Graph model;

    public Controller()
    {
        this.model = new Graph();
        this.view = new View();
        view.setController(this);
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(view, e.getMessage(), "Ошибка!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args)
    {
        new Controller();
    }

    public void createFunction()
    {
        String rpn = model.getFunction();
        try
        {
            String expression = view.getFunction();

            if (validateData(expression))
            {
                double step = Double.parseDouble(view.getStep());
                double minX = Double.parseDouble(view.getMinX());
                double maxX = Double.parseDouble(view.getMaxX());
                String rpnFunction = new ReversePolishNotationCreator().toReversePolishNotation(expression);

                model.setMinX(minX);
                model.setMaxX(maxX);
                model.setInitialStep(step);
                model.setFunction(rpnFunction);
                model.initCoordinates();
                view.requestFocus();
            }
        }
        catch (UnsupportedOperationException e)
        {
            model.setFunction(rpn);
            JOptionPane.showMessageDialog(view, e.getMessage(), "Ошибка!", JOptionPane.ERROR_MESSAGE);
            view.requestFunction();
        }
        view.update();
    }

    private boolean validateData(String expression)
    {
        try
        {
            if (expression.equals(""))
            {
                JOptionPane.showMessageDialog(view, "Не введена функция", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (view.getMinX().equals(""))
            {
                JOptionPane.showMessageDialog(view, "Не введена нижняя граница", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (view.getMaxX().equals(""))
            {
                JOptionPane.showMessageDialog(view, "Не введена верхняя граница", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (view.getStep().equals(""))
            {
                JOptionPane.showMessageDialog(view, "Не введен шаг вычислений", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            double step = Double.parseDouble(view.getStep());
            double minX = Double.parseDouble(view.getMinX());
            double maxX = Double.parseDouble(view.getMaxX());

            if (maxX < minX)
            {
                JOptionPane.showMessageDialog(view, "Минимальное значение не может быть больше, чем максимальное", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (step <= 0)
            {
                JOptionPane.showMessageDialog(view, "Шаг вычислений должен быть положительным", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(view, "Значение одного из параметров задано не верно", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }



    public List<Coordinate> getCoordinates()
    {
        return model.getCurrentCoordinates();
    }

    public Axis getAxis()
    {
        return model.getAxis();
    }

    public void move(int x, int y)
    {
        model.move(x, y);
        view.update();
    }

    public void resize(int value)
    {
        model.resize(value);
        view.update();
    }
}
