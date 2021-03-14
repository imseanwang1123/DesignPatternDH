package design_pattern.template_method_pattern;

public class TemplateMethodPattern {
    public abstract static class TestPaper {
        private void question1() {
            System.out.println("question1");
            answer1();
        }

        public abstract void answer1();


        private void question2() {
            System.out.println("question2");
            answer2();
        }

        public abstract void answer2();


        private void question3() {
            System.out.println("question3");
            answer3();
        }

        public abstract void answer3();
    }

    public static class TestPaperA extends TestPaper {
        @Override
        public void answer1() {
            System.out.println("A");
        }

        @Override
        public void answer2() {
            System.out.println("A");
        }

        @Override
        public void answer3() {
            System.out.println("A");
        }
    }

    public static class TestPaperB extends TestPaper {
        @Override
        public void answer1() {
            System.out.println("B");
        }

        @Override
        public void answer2() {
            System.out.println("A");
        }

        @Override
        public void answer3() {
            System.out.println("A");
        }
    }

}
