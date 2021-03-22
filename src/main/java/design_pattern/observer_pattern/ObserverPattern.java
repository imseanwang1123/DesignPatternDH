package design_pattern.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    interface Observer {
        void update();
    }

    interface Subject {
        void attach(Observer observer);

        void detach(Observer observer);

        void doNotify();
    }


    public static class ConcreteSubject implements Subject {
        List<Observer> observers;
        private String state;

        public ConcreteSubject() {
            this.observers = new ArrayList<>();
        }

        @Override
        public void attach(Observer observer) {
            this.observers.add(observer);
        }

        @Override
        public void detach(Observer observer) {
            this.observers.remove(observer);
        }

        @Override
        public void doNotify() {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }

}
