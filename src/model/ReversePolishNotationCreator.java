package model;

import java.util.Locale;
import java.util.Stack;

public class ReversePolishNotationCreator
{
	public String toReversePolishNotation(String expression) throws UnsupportedOperationException
	{
		try {
			expression = normalize(expression);
			Locale.setDefault(Locale.ENGLISH);
			StringBuilder input = new StringBuilder(expression.replaceAll(" ", "").replaceAll(",", "."));
			StringBuilder output = new StringBuilder();
			Stack<String> stack = new Stack<>();
			boolean isNegative = false;
			while (input.length() != 0) {
				String currentSymbol = input.substring(0, 1);
				if (!currentSymbol.matches("\\d|[-+*/)(^]")) {
					for (int i = 6; i > 1; i--) {
						if (input.length() > i && RpnHelper.isFunction(input.substring(0, i))) {
							currentSymbol = input.substring(0, i);
							input.delete(0, i - 1);
							break;
						}
					}
				}
				input.delete(0, 1);
				if (RpnHelper.isOperation(currentSymbol)) {
					while (!stack.isEmpty()) {
						String currentOp = stack.peek();
						if (isNegative) {
							output.append("0");
							isNegative = false;
						}
						if (RpnHelper.isOperation(currentOp) && (RpnHelper.operationPriority(currentSymbol) <= RpnHelper.operationPriority(currentOp))) {
							if (RpnHelper.operationPriority(currentSymbol) == 3 && RpnHelper.operationPriority(currentOp) == 3)
								break;
							output.append(" ").append(currentOp);
							stack.pop();
						} else break;
					}
					stack.push(currentSymbol);
					if (output.length() == 0 && currentSymbol.equals("-")) {
						isNegative = true;
					} else if (output.length() != 0) {
						output.append(" ");
					}
				} else if ("(".equals(currentSymbol)) {
					if (isNegative) {
						output.append("0 ");
					}
					stack.push(currentSymbol);
					if (input.charAt(0) == '-')
						isNegative = true;
				} else if (")".equals(currentSymbol)) {
					String c = stack.pop();
					while (!"(".equals(c)) {
						output.append(" ").append(c);
						c = stack.pop();
					}

				} else {
					if (isNegative) {
						if (output.length() == 0 && !stack.isEmpty())
							output.append("0 ").append(currentSymbol);
						isNegative = false;
					} else
						output.append(currentSymbol);
				}
			}
			while (!stack.isEmpty()) {
				String b = stack.pop();
				output.append(" ").append(b);
			}
			return output.toString().toLowerCase().replaceAll("\\s+", " ");
		}
		catch (Exception e)
		{
			throw new UnsupportedOperationException("Строка не может быть распознана!");
		}
	}

	private String normalize(String expression)
	{
		StringBuilder sb = new StringBuilder(expression.replaceAll("ctg", "1/tan"));
		return sb.toString();
		//TODO create this method
	}
}
