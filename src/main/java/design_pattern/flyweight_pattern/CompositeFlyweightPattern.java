package design_pattern.flyweight_pattern;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompositeFlyweightPattern {

    interface NameCard {
        void show(String message);
    }

    @AllArgsConstructor
    public static class ConcreteNameCard implements NameCard {

        private String key;

        @Override
        public void show(String message) {
            System.out.println("Hello! I'm " + this.key);
            System.out.println(message);
        }
    }

    public static class CompositeConcreteNameCard implements NameCard {
        private Map<String, NameCard> nameCards = new HashMap<>();

        @Override
        public void show(String message) {
            for (NameCard nameCard : nameCards.values()) {
                nameCard.show(message);
            }
        }

        public void add(String key,  NameCard nameCard) {
            nameCards.put(key, nameCard);
        }

        public void remove(String key) {
            nameCards.remove(key);
        }
    }

    public static class NameCardFactory {
        private static NameCardFactory instance;

        private Map<String, NameCard> nameCards = new HashMap<>();

        private static NameCardFactory getInstance() {
            if (instance == null) {
                instance = new NameCardFactory();
            }
            return instance;
        }

        public NameCard getNameCard(String key) {
            NameCard nameCard = nameCards.getOrDefault(key, null);
            if (nameCard == null) {
                nameCard = new ConcreteNameCard(key);
                nameCards.put(key, nameCard);
            }
            return nameCard;
        }

        public NameCard getNameCard(List<String> keys) {
            CompositeConcreteNameCard nameCard = new CompositeConcreteNameCard();
            for (String key : keys) {
                nameCard.add(key ,getNameCard(key));
            }
            return nameCard;
        }

    }
}
