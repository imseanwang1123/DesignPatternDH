package design_pattern.mediator_pattern;

import java.util.HashMap;
import java.util.Map;

public class MediatorPattern {

    public enum Type {
        ENGINEERING, DESIGN, SERVICE, MARKETING
    }

    public static abstract class Mediator {
        public abstract void register(Type type, Colleague colleague);

        public abstract void relay(Type type, String message);
    }

    public static class ProductManager extends Mediator {

        private Map<Type, Colleague> map = new HashMap<>();

        @Override
        public void register(Type type, Colleague colleague) {
            this.map.put(type, colleague);
        }

        @Override
        public void relay(Type type, String message) {
            map.get(type).received(message);
        }
    }

    public static abstract class Colleague {
        protected Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }

        public abstract void received(String message);

        public abstract void send(Type type, String message);
    }

    public static class EngineeringTeam extends Colleague {

        public EngineeringTeam(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void received(String message) {
            System.out.println("EngineeringTeam received : " + message);
        }

        @Override
        public void send(Type type, String message) {
            System.out.println("EngineeringTeam send : " + message);
            mediator.relay(type, message);
        }
    }

    public static class DesignTeam extends Colleague {

        public DesignTeam(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void received(String message) {
            System.out.println("DesignTeam received : " + message);
        }

        @Override
        public void send(Type type, String message) {
            System.out.println("DesignTeam send : " + message);
            mediator.relay(type, message);
        }
    }

    public static class MarketingTeam extends Colleague {

        public MarketingTeam(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void received(String message) {
            System.out.println("MarketingTeam received : " + message);
        }

        @Override
        public void send(Type type, String message) {
            System.out.println("MarketingTeam send : " + message);
            mediator.relay(type, message);
        }
    }

    public static class CustomerService extends Colleague {

        public CustomerService(Mediator mediator) {
            super(mediator);
        }

        @Override
        public void received(String message) {
            System.out.println("CustomerService received : " + message);
        }

        @Override
        public void send(Type type, String message) {
            System.out.println("CustomerService send : " + message);
            mediator.relay(type, message);
        }
    }
}
