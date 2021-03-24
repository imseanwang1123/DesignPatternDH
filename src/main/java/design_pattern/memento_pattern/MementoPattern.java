package design_pattern.memento_pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class MementoPattern {

    @AllArgsConstructor
    public static class Memento {

        @Getter
        @Setter
        private String state;
    }

    public static class Originator {

        @Getter
        private String state;

        public void setState(String state) {
            System.out.println(state + "!");
            this.state = state;
        }

        public Memento createMemento() {
            return new Memento(this.state);
        }

        public void restoreMemento(Memento memento) {
            System.out.println("restore" + memento.getState());
            this.state = memento.getState();
        }
    }

    public static class Caretaker {

        @Getter
        @Setter
        private Memento memento;
    }


}
