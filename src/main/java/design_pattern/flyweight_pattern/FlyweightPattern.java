package design_pattern.flyweight_pattern;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {
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


    }

}
