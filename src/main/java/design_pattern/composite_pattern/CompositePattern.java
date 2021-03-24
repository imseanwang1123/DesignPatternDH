package design_pattern.composite_pattern;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {

    interface Articles {
        void add(Articles articles);

        void remove(Articles articles);

        float calculation();

        void show();
    }


    @AllArgsConstructor
    public static class Commodity implements Articles {
        private String name;
        private int quantity;
        private int unitPrice;


        @Override
        public void add(Articles articles) {
        }

        @Override
        public void remove(Articles articles) {
        }

        @Override
        public float calculation() {
            return quantity * unitPrice;
        }

        @Override
        public void show() {
            System.out.println(name + " (quantity: " + quantity + ", unitPrice: NT " + unitPrice + ")");
        }
    }

    public static class Bags implements Articles {

        private String name;
        private List<Articles> bags = new ArrayList<>();
        public Bags(String name) {
            this.name = name;
        }

        @Override
        public void add(Articles articles) {
            this.bags.add(articles);
        }

        @Override
        public void remove(Articles articles) {
            this.bags.remove(articles);
        }

        @Override
        public float calculation() {
            float total = 0f;
            for (Articles article : this.bags) {
                total += article.calculation();
            }
            return total;
        }

        @Override
        public void show() {
            for (Articles bag : this.bags) {
                bag.show();
            }
        }
    }

}
