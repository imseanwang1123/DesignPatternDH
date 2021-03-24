package design_pattern.state_pattern;

import lombok.Setter;

import java.util.Scanner;

public class StatePattern {

    public static void main(String[] args) {
        Context context = new Context();    //建立環境

        Scanner scanner = new Scanner(System.in);
        boolean end = false;

        System.out.println("申請已送出，請等待審核結果。");
        while (!end) {
            System.out.println("請輸入選項（1：審核通過；2：繼續審核；3：結束程式）：");
            int num = scanner.nextInt();
            if (num == 1) {
                end = context.handle(true);    //處理請求
            } else if (num == 2) {
                end = context.handle(false);    //處理請求
            } else if (num == 3) {
                end = true;
            } else {
                System.out.println("請輸入正確指令");
            }
        }

    }

    public static class Context {
        @Setter
        private State state;

        public Context() {
            this.state = new ConcreteStateA();
        }

        public boolean handle(boolean status) {
            return this.state.handle(this, status);
        }
    }

    public abstract static class State {
        public abstract boolean handle(Context context, boolean status);
    }

    public static class ConcreteStateA extends State {
        @Override
        public boolean handle(Context context, boolean status) {
            if (status) {
                System.out.println("資料填寫完整，業務審核通過，準備進入行員審核。");
                context.setState(new ConcreteStateB());
                return true;
            }

            System.out.println("業務審核中。");
            return false;
        }
    }


    public static class ConcreteStateB extends State {

        @Override
        public boolean handle(Context context, boolean status) {
            if (status) {
                System.out.println("行員審核通過，準備進入信用卡部審核。");
                context.setState(new ConcreteStateC());
                return true;
            }

            System.out.println("行員審核中。");
            return false;
        }
    }


    public static class ConcreteStateC extends State {

        @Override
        public boolean handle(Context context, boolean status) {
            if (status) {
                System.out.println("信用卡部審核通過，寄送信用卡。");
                return true;
            }

            System.out.println("信用卡部審核中。");
            return false;
        }
    }

}
