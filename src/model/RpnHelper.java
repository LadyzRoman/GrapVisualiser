package model;


public class RpnHelper
{
    static byte opPrior(String op)
    {
        if (isFunc(op))
            return 4;
        switch (op)
        {
            case "^":
                return 3;
            case "*":
            case "/":
                return 2;
        }
        return 1;
    }

    static boolean isFunc(String op)
    {
        switch(op)
        {
            case "sin":
            case "cos":
            case "tan":
            case "abs":
            case "log":
            case "log10":
            case "signum":
            case "sqrt":
            case "cbrt":
            case "asin":
            case "acos":
            case "atan":
            case "exp":
                return true;
        }
        return false;
    }

    static boolean isOp(String op)
    {
        switch (op)
        {
            case "-":
            case "+":
            case "*":
            case "/":
            case "^":
                return true;
        }
        return isFunc(op);
    }
}
