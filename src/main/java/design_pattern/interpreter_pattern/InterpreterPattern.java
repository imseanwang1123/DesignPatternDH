package design_pattern.interpreter_pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class InterpreterPattern {

    @AllArgsConstructor
    public static class Context {
        @Getter
        private String context;
    }

    interface Expression {
        int interpret(String expression);
    }

    public static class ExpressionImplA implements Expression {

        @Override
        public int interpret(String expression) {
            String str = expression.substring(1);
            return Integer.parseInt(str) * 2;
        }
    }


    public static class ExpressionImplB implements Expression {

        @Override
        public int interpret(String expression) {
            String str = expression.substring(1);
            return Integer.parseInt(str) / 2;
        }
    }

    public static void main(String[] args) {
        Context context = new Context("a123 B456");
        Expression expression = null;
        for (String sentence : context.getContext().split(" ")) {
            String first = sentence.substring(0, 1);
            if (first.matches("[a-z]")) {
                expression = new ExpressionImplA();
            } else {
                expression = new ExpressionImplB();
            }

            System.out.println(expression.interpret(sentence));
        }
    }
}
