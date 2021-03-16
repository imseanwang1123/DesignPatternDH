package design_pattern.facade_pattern;

public class FacadePattern {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }

    public static class Facade {
        private SubSystemOne one = new SubSystemOne();
        private SubSystemTwo two = new SubSystemTwo();
        private SubSystemThree three = new SubSystemThree();
        private SubSystemFour four = new SubSystemFour();

        public void methodA() {
            one.methodOne();
            three.methodThree();
        }

        public void methodB() {
            two.methodTwo();
            four.methodFour();
        }


    }

    public static class SubSystemOne {
        public void methodOne() {
            System.out.println(1);
        }
    }

    public static class SubSystemTwo {
        public void methodTwo() {
            System.out.println(2);
        }
    }

    public static class SubSystemThree {
        public void methodThree() {
            System.out.println(3);
        }
    }

    public static class SubSystemFour {
        public void methodFour() {
            System.out.println(4);
        }
    }


}
