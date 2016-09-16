package model;

import java.util.Locale;
import java.util.Stack;

public class ReversePolishNotationCreator
{
    public static String tRpn(String expression) throws Exception
    {
        Locale.setDefault(Locale.ENGLISH);
        StringBuilder input = new StringBuilder(expression.replaceAll(" ", "").replaceAll(",", "."));
        StringBuilder rpn = new StringBuilder();
        Stack<String> stack = new Stack<>();
        boolean isNegative = false;
        while (input.length() != 0)
        {
            String a = input.substring(0, 1);
            for (int i = 6; i > 1; i--)
            {
                if (input.length() > i && RpnHelper.isFunc(input.substring(0, i)))
                {
                    a = input.substring(0, i);
                    input.delete(0, i - 1);
                    break;
                }
            }
            input.delete(0, 1);
            if (RpnHelper.isOp(a))
            {
                while (!stack.isEmpty())
                {
                    String b = stack.peek();
                    if (isNegative)
                    {
                        rpn.append("0");
                        isNegative = false;
                    }
                    if (RpnHelper.isOp(b) && (RpnHelper.opPrior(a) <= RpnHelper.opPrior(b)))
                    {
                        if (RpnHelper.opPrior(a) == 3 && RpnHelper.opPrior(b) == 3) break;
                        rpn.append(" ").append(b);
                        stack.pop();
                    } else break;
                }
                stack.push(a);
                if (rpn.length() == 0 && stack.peek().equals("-"))
                {
                    isNegative = true;
                } else if (rpn.length() != 0)
                {
                    rpn.append(" ");
                }
            } else if ("(".equals(a))
            {
                if (isNegative)
                {
                    rpn.append("0 ");
                }
                stack.push(a);
                if (input.charAt(0) == '-')
                    isNegative = true;
            } else if (")".equals(a))
            {
                String c = stack.pop();
                while (!"(".equals(c))
                {
                    rpn.append(" ").append(c);
                    c = stack.pop();
                }

            } else
            {
                if (isNegative)
                {
                    if (rpn.length() == 0 && !stack.isEmpty())
                        rpn.append("0 ").append(a);
                    isNegative = false;
                } else
                    rpn.append(a);
            }
        }
        while (!stack.isEmpty())
        {
            String b = stack.pop();
            rpn.append(" ").append(b);
        }
        return rpn.toString().toLowerCase().replaceAll("\\s+", " ");
    }
}
