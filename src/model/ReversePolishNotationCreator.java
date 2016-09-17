package model;

import java.util.Locale;
import java.util.Stack;

public class ReversePolishNotationCreator
{
	public String toReversePolishNotation(String expression) throws Exception
	{
		expression = normalize(expression);
		Locale.setDefault(Locale.ENGLISH);
		StringBuilder input = new StringBuilder(expression.replaceAll(" ", "").replaceAll(",", "."));
		StringBuilder output = new StringBuilder();
		Stack<String> stack = new Stack<>();
		boolean isNegative = false;
		while (input.length() != 0)
		{
			String a = input.substring(0, 1);
			if (!a.matches("\\d|[-+*/)(^]"))
			{
				for (int i = 6; i > 1; i--)
				{
					if (input.length() > i && RpnHelper.isFunction(input.substring(0, i)))
					{
						a = input.substring(0, i);
						input.delete(0, i - 1);
						break;
					}
				}
			}
			input.delete(0, 1);
			if (RpnHelper.isOperation(a))
			{
				while (!stack.isEmpty())
				{
					String b = stack.peek();
					if (isNegative)
					{
						output.append("0");
						isNegative = false;
					}
					if (RpnHelper.isOperation(b) && (RpnHelper.operationPriority(a) <= RpnHelper.operationPriority(b)))
					{
						if (RpnHelper.operationPriority(a) == 3 && RpnHelper.operationPriority(b) == 3) break;
						output.append(" ").append(b);
						stack.pop();
					}
					else break;
				}
				stack.push(a);
				if (output.length() == 0 && a.equals("-"))
				{
					isNegative = true;
				}
				else if (output.length() != 0)
				{
					output.append(" ");
				}
			}
			else if ("(".equals(a))
			{
				if (isNegative)
				{
					output.append("0 ");
				}
				stack.push(a);
				if (input.charAt(0) == '-')
					isNegative = true;
			}
			else if (")".equals(a))
			{
				String c = stack.pop();
				while (!"(".equals(c))
				{
					output.append(" ").append(c);
					c = stack.pop();
				}

			}
			else
			{
				if (isNegative)
				{
					if (output.length() == 0 && !stack.isEmpty())
						output.append("0 ").append(a);
					isNegative = false;
				}
				else
					output.append(a);
			}
		}
		while (!stack.isEmpty())
		{
			String b = stack.pop();
			output.append(" ").append(b);
		}
		return output.toString().toLowerCase().replaceAll("\\s+", " ");
	}

	private String normalize(String expression)
	{
		StringBuilder sb = new StringBuilder(expression.replaceAll("ctg", "1/tan"));
		return sb.toString();

	}
}
