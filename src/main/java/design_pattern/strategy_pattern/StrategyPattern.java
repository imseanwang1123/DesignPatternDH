package design_pattern.strategy_pattern;

import lombok.AllArgsConstructor;

public class StrategyPattern {
    public static void main(String[] args) {
        double money = new CashContext(new CashNormal()).acceptCash(1000);
        System.out.println(money);
        money = new CashContext(new CashRebate(0.8)).acceptCash(1000);
        System.out.println(money);
        money = new CashContext(new CashReturn(300, 100)).acceptCash(1000);
        System.out.println(money);
    }

    public static abstract class CashStrategy {
        public abstract double acceptCash(double money);
    }

    public static class CashNormal extends CashStrategy {
        @Override
        public double acceptCash(double money) {
            return money;
        }
    }

    @AllArgsConstructor
    public static class CashRebate extends CashStrategy {
        private double rebate = 1;

        @Override
        public double acceptCash(double money) {
            return money * rebate;
        }
    }

    @AllArgsConstructor
    public static class CashReturn extends CashStrategy {

        private double moneyCondition = 1;
        private double moneyReturn = 0;

        @Override
        public double acceptCash(double money) {
            if (money < moneyCondition) {
                return money;
            }

            return money - Math.floor(money / moneyCondition) * moneyReturn;
        }
    }

    @AllArgsConstructor
    public static class CashContext {
        private CashStrategy cashStrategy;

        public double acceptCash(double money) {
            return cashStrategy.acceptCash(money);
        }

        public void changeStrategy(CashStrategy strategy) {
            this.cashStrategy = strategy;
        }
    }


}
