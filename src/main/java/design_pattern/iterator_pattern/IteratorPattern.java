package design_pattern.iterator_pattern;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add(1);
        aggregate.add(2);
        aggregate.add(3);
        aggregate.add(4);

        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println("next" + iterator.next());
        }

    }

    interface Aggregate {
        void add(Object obj);

        void remove(Object obj);

        Iterator getIterator();
    }

    public static class ConcreteAggregate implements Aggregate {

        private List<Object> list = new ArrayList<>();

        @Override
        public void add(Object obj) {
            list.add(obj);
        }

        @Override
        public void remove(Object obj) {
            list.remove(obj);
        }

        @Override
        public Iterator getIterator() {
            return new ConcreteIterator(list);
        }
    }


    interface Iterator {
        Object first();

        Object last();

        boolean hasNext();

        Object next();

    }

    public static class ConcreteIterator implements Iterator {

        private final List<Object> objects;

        private int current;

        public ConcreteIterator(List<Object> objects) {
            this.objects = objects;
        }

        @Override
        public Object first() {
            return !objects.isEmpty() ? objects.get(0) : null;
        }

        @Override
        public Object last() {
            return !objects.isEmpty() ? objects.get(objects.size() - 1) : null;
        }

        @Override
        public boolean hasNext() {
            return current < objects.size();
        }

        @Override
        public Object next() {
            Object result = null;
            if (current < objects.size()) {
                result = objects.get(current);
                current++;
            }

            return result;
        }

    }
}
