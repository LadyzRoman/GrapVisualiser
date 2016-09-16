package model;


public class RpnHelper
{
    static byte operationPriority(String operation)
    {
        if (isFunction(operation))
            return 4;
        switch (operation)
        {
            case "^":
                return 3;
            case "*":
            case "/":
                return 2;
        }
        return 1;
    }

    static boolean isFunction(String function)
    {
        switch(function)
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

    static boolean isOperation(String operation)
    {
        switch (operation)
        {
            case "-":
            case "+":
            case "*":
            case "/":
            case "^":
                return true;
        }
        return isFunction(operation);
    }
}
