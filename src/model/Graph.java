package model;


import exceptions.EmptyStringException;

import java.lang.reflect.Method;
import java.util.*;


public class Graph {
    private String rpn;
    private List<Coordinate> coordinates = new ArrayList<>();
    private List<Coordinate> currentCoordinates = new ArrayList<>();
    private double initStep;
    private double minX;
    private double maxX;
    public final static int SIZE = 600;
    private int x0 = 0;
    private int y0 = 0;
    private double d;
    private double x;
    private Axis axis;


    public List<Coordinate> getCurrentCoordinates() {
        return currentCoordinates;
    }

    public Axis getAxis() {
        return axis;
    }

    double getX() {
        return x;
    }

    int getX0() {
        return x0;
    }

    int getY0() {
        return y0;
    }

    double getD() {
        return d;
    }

    public String getRpn() {
        return rpn;
    }

    public void setRpn(String rpn) {
        this.rpn = rpn;
    }

    public Graph(double minX, double maxX, double initStep) {
        this.rpn = "";
        this.minX = minX;
        this.maxX = maxX;
        this.initStep = initStep;
        this.axis = new Axis(this);
        x = 20;
        d = SIZE / x;
        try {
            initCoordinates();
        } catch (Exception e) {

        }
    }

    public Graph() {
        this(-20, 20, 0.01);
    }

    public void initCoordinates() throws Exception {
        if (rpn.equals(""))
            throw new EmptyStringException();
        List<Coordinate> coordinates = new ArrayList<>();
        Coordinate prev = null;
        for (double i = minX; i <= maxX; i += initStep) {
            double y = (getY(i));
            Coordinate current = new Coordinate(i, y, prev, this);
            coordinates.add(current);
            prev = current;
        }
        this.coordinates = coordinates;
        initCurrentCoordinates();
    }

    private double getY(double x) throws Exception {
        Stack<Double> stack = new Stack<>();
        String[] array = rpn.split(" ");
        for (String a : array) {
            if (RpnHelper.isOp(a)) {
                Double x1 = stack.pop();
                if (RpnHelper.isFunc(a)) {
                    Method method = Math.class.getMethod(a, double.class);
                    x1 = (Double) method.invoke(Math.class, x1);
                } else {
                    Double x2 = stack.pop();
                    switch (a.charAt(0)) {
                        case '-':
                            x1 = x2 - x1;
                            break;
                        case '+':
                            x1 = x2 + x1;
                            break;
                        case '*':
                            x1 *= x2;
                            break;
                        case '/':
                            x1 = x2 / x1;
                            break;
                        case '^':
                            x1 = Math.pow(x2, x1);
                    }
                }
                stack.push(x1);
            } else {
                switch (a) {
                    case "e":
                        stack.push(Math.E);
                        break;
                    case "pi":
                        stack.push(Math.PI);
                        break;
                    case "x":
                        stack.push(x);
                        break;
                    default:
                        stack.push(Double.parseDouble(a));
                }
            }
        }
        return stack.pop();
    }

    public void resize(int value) {
        if (value > 0) {
            if (x + value / 5 <= 10)
                x += value / 5;
            else if (x + value <= 60)
                x += value;
        } else {
            if (x + value <= 0)
                if (x + value / 5 > 0)
                    x += value / 5;
                else return;
            else x += value;
        }
        double tX = x0 / d;
        double tY = y0 / d;
        d = SIZE / x;
        y0 = (int) (tY * d);
        x0 = (int) (tX * d);

        initCurrentCoordinates();
    }

    private void initCurrentCoordinates() {
        currentCoordinates.clear();
        Coordinate prev = null;
        for (Coordinate c : coordinates) {
            double x = (int) (getD() * (c.getX() + getX() / 2));
            double y = (int) (getD() * (-c.getY() + getX() / 2));
            Coordinate current = new Coordinate(x, y, prev, this);
            if (current.equals(prev)) continue;

            prev = current;
            currentCoordinates.add(current);
        }
    }

    public void move(double x, double y) {
        x0 += d * x;
        y0 += d * y;
    }
}
