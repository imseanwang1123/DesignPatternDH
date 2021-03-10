package design_pattern.simple_factory;

import lombok.Getter;
import lombok.Setter;

public class OperatorFactory {
    public static void main(String[] args) {
        Operator operator = OperatorFactory.getOperator(OperatorKinds.MUL);
        operator.setNumberA(1);
        operator.setNumberB(5);
        System.out.println(operator.getResult());
    }

    public static Operator getOperator(OperatorKinds kind) {
        Operator op = null;
        switch (kind) {
            case ADD:
                op = new Operator() {
                    @Override
                    public double getResult() {
                        return getNumberA() + getNumberB();
                    }
                };
                break;
            case SUB:
                op = new Operator() {
                    @Override
                    public double getResult() {
                        return getNumberA() - getNumberB();
                    }
                };
                break;
            case MUL:
                op = new Operator() {
                    @Override
                    public double getResult() {
                        return getNumberA() * getNumberB();
                    }
                };
                break;
            case DIV:
                op = new Operator() {
                    @Override
                    public double getResult() {
                        if (getNumberB() == 0) {
                            throw new RuntimeException("In Div Number B can not be 0!");
                        }
                        return getNumberA() / getNumberB();
                    }
                };
                break;
        }
        return op;
    }


    public enum OperatorKinds {
        ADD,
        SUB,
        MUL,
        DIV
    }

    @Getter
    @Setter
    public abstract static class Operator {
        private double NumberA;
        private double NumberB;

        public abstract double getResult();
    }
}
