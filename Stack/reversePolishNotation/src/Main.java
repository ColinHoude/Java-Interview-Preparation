import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//        Evaluate the expression. Return an integer that represents the value of the expression.

        String [] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        evalRPN(tokens);

    }

    public static int evalRPN(String[] x){
        Stack<Integer> staa = new Stack<>();
        for(String  c: x){
            if("+-*/".contains(c)){
                // this represents an operator
                staa.push(solveThat(staa.pop(), staa.pop(), c));
            }
            else{
                staa.push(Integer.parseInt(c));
            }
        }
        System.out.println("answer is: " + staa.pop());
        return -1;
    }

    public static int solveThat(int y, int x, String operand){
        System.out.println("got passed " + y + operand + x);
        if("+".equals(operand)){
            return x+y;
        }
        else if("-".equals(operand)){
            return x-y;
        }
        else if("*".equals(operand)){
            return x*y;
        }
        else {
            return x/y;
        }
    }
}