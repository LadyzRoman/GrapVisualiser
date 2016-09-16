package controller;

import exceptions.EmptyStringException;
import model.Axis;
import model.Coordinate;
import model.Graph;
import model.ReversePolishNotationCreator;
import view.View;

import javax.swing.*;
import java.util.List;

/**
 * Created by Сергей on 12.07.2016.
 */
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
            String rpnFunction = ReversePolishNotationCreator.toReversePolishNotation(expression);
            model.setFunction(rpnFunction);
            model.initCoordinates();
            view.requestFocus();
        }
        catch (EmptyStringException e)
        {
            JOptionPane.showMessageDialog(view, "Не введена функция!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            view.requestFunction();
        }
        catch (Exception e)
        {
            model.setFunction(rpn);
            JOptionPane.showMessageDialog(view, "Введены некорректные данные!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            view.requestFunction();
        }
        view.update();
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
