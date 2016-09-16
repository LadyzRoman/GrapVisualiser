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
        while (input.length() != 0)
        {
            String a = "";
            for (int i = 6; i > 1; i--)
            {
                if (input.length() > i && RpnHelper.isFunc(input.substring(0, i)))
                {
                    a = input.substring(0, i);
                    input.delete(0, i - 1);
                    break;
                }
                a = input.substring(0, 1);
            }
            if (RpnHelper.isOp(a))
            {
                while (!stack.isEmpty())
                {
                    String b = stack.peek();
                    if (b.equals("?"))
                    {
                        b = stack.pop();
                        rpn.append("0");
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
                    stack.push("?");
                } else if (rpn.length() != 0)
                {
                    rpn.append(" ");
                }
            } else if ("(".equals(a))
            {
                if (!stack.isEmpty() && stack.peek().equals("?"))
                {
                    rpn.append("0 ");
                    stack.pop();
                }
                stack.push(a);
                if (input.charAt(1) == '-')
                    stack.push("?");
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
                if (!stack.isEmpty() && stack.peek().equals("?"))
                {
                    if (rpn.length() == 0 && !stack.isEmpty())
                        rpn.append("0 ").append(a);
                    stack.pop();
                } else
                    rpn.append(a);
            }
            input.delete(0, 1);
        }
        while (!stack.isEmpty())
        {
            String b = stack.pop();
            rpn.append(" ").append(b);
        }
        return rpn.toString().toLowerCase().replaceAll("\\s+", " ");
    }
}
