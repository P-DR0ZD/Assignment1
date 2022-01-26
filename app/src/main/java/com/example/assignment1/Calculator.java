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
        int sum = 0;
        if (expression.size() % 2 == 0)
            throw new Exception("Not an Operator");

        while (!expression.isEmpty()) {

            try {
                int num1 = Integer.parseInt(expression.get(0));
                String operator = expression.get(1);
                int num2 = Integer.parseInt(expression.get(2));
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


            expression.subList(0, 3).clear();


            if (!expression.isEmpty()) {
                String tmp = Integer.toString(sum);
                expression.add(0,tmp);
            }
        }
        return sum;
    }
}
