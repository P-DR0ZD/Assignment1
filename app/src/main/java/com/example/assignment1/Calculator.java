package com.example.assignment1;

import java.util.ArrayList;

public class Calculator {

    ArrayList<String> expression;

    Calculator()
    {
        expression = new ArrayList<String>();
    }

    void push(String value)
    {
        expression.add(expression.size(), value);
    }

    void clear()
    {
        expression.clear();
    }

    int calculate() throws Exception {
        int sum = 0, num1, num2;
        String operator;
        if (expression.size() % 2 == 0)
            throw new Exception("Not an Operator");
        try {
            num1 = Integer.parseInt(expression.get(0));
            expression.subList(0, 1).clear();
        }catch (Exception e)
        {
            throw new Exception("Not an Operator");
        }

        while (!expression.isEmpty()) {
            try {
                operator = expression.get(0);
                num2 = Integer.parseInt(expression.get(1));
                expression.subList(0, 2).clear();
                switch (operator)
                {
                    case "+":
                        sum = num1 + num2;
                        break;
                    case "-":
                        sum = num1 - num2;
                        break;
                    case "*":
                        sum = num1 * num2;
                        break;
                    case "/":
                        sum = num1 / num2;
                        break;
                    case "%":
                        sum = num1 % num2;
                        break;
                    case "pow":
                        sum = (int) Math.pow(num1, num2);
                        break;
                    case "max":
                        sum = Math.max(num1, num2);
                        break;
                    case "min":
                        sum = Math.min(num1, num2);
                        break;
                    default:
                        throw new Exception("Not an Operator");
                }
            }catch (Exception e){
                throw new Exception("Not an Operator");
            }
            if (!expression.isEmpty()) {
                num1 = sum;
            }
        }
        return sum;
    }
}
