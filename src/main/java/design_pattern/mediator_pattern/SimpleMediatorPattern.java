package design_pattern.mediator_pattern;

import java.util.HashMap;
import java.util.Map;

public class SimpleMediatorPattern {
    enum Type {
        ENGINEERING, DESIGN, SERVICE, MARKETING
    }

    public static class SimpleProductManager {
        private static SimpleProductManager instance;

        public static SimpleProductManager getInstance() {
            if (instance == null) {
                instance = new SimpleProductManager();
            }
            return instance;
        }

        private Map<Type, SimpleColleague> colleagues = new HashMap<>();

        public void register(Type type, SimpleColleague colleague) {
            this.colleagues.put(type, colleague);
        }

        public void relay(Type type, String message) {
            this.colleagues.get(type).receive(message);
        }
    }

    public static abstract class SimpleColleague {
        public SimpleColleague(Type type) {
            SimpleProductManager.getInstance().register(type, this);
        }

        public abstract void receive(String message);

        public abstract void send(Type type, String message);
    }

    public static class SimpleEngineeringTeam extends SimpleColleague {
        public SimpleEngineeringTeam() {
            super(Type.ENGINEERING);
        }

        @Override
        public void receive(String message) {
            System.out.println("EngineeringTeam received : " + message);
        }

        @Override
        public void send(Type type, String message) {
            System.out.println("EngineeringTeam send : " + message);
            SimpleProductManager.getInstance().relay(type, message);
        }
    }

    public static class SimpleDesignTeam extends SimpleColleague {
        public SimpleDesignTeam() {
            super(Type.DESIGN);
        }

        @Override
        public void receive(String message) {
            System.out.println("DesignTeam received : " + message);
        }

        @Override
        public void send(Type type, String message) {
            System.out.println("DesignTeam send : " + message);
            SimpleProductManager.getInstance().relay(type, message);
        }
    }
}
