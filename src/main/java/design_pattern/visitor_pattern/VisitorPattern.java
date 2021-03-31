package design_pattern.visitor_pattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new HonestManElement());
        objectStructure.attach(new LieManElement());

        objectStructure.display(new MathVisitor());
    }

    public static class ObjectStructure {
        private List<Element> elements = new ArrayList<>();

        public void attach(Element element) {
            elements.add(element);
        }

        public void detach(Element element) {
            elements.remove(element);
        }

        public void display(Visitor visitor) {
            for (Element element : elements) {
                element.accept(visitor);
            }
        }
    }


    public static abstract class Element {
        public abstract String getName();

        public abstract void accept(Visitor visitor);
    }

    public static class HonestManElement extends Element {
        @Override
        public String getName() {
            return "聰明人";
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public static class LieManElement extends Element {
        @Override
        public String getName() {
            return "說謊人";
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public static abstract class Visitor {
        // 訪問誠實人的多載方法
        public abstract void visit(HonestManElement honestElement);

        // 訪問說謊人的多載方法
        public abstract void visit(LieManElement lieElement);
    }

    public static class MathVisitor extends Visitor {

        @Override
        public void visit(HonestManElement honestElement) {
            System.out.println(honestElement.getName() + " 說: 1 + 1 = 2");
        }

        @Override
        public void visit(LieManElement lieElement) {
            System.out.println(lieElement.getName() + " 說: 1 + 1 = 3");
        }
    }
}
