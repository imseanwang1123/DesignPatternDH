package design_pattern.adapter_pattern;

import lombok.AllArgsConstructor;

public class AdapterPattern {

    interface Grandma {
        void snore();

        void sleep();
    }

    interface Wolf {
        void bark();

        void sleep();
    }

    public static class RedHatGrandma implements Grandma {
        @Override
        public void snore() {
            System.out.println("Grandma snore");
        }

        @Override
        public void sleep() {
            System.out.println("Grandma sleeping");
        }
    }

    public static class BigWildWolf implements Wolf {
        @Override
        public void bark() {
            System.out.println("BigWildWolf bark");
            System.out.println("BigWildWolf imitate Grandma snore");
        }

        @Override
        public void sleep() {
            System.out.println("BigWildWolf sleeping");
        }
    }

    @AllArgsConstructor
    public static class BigWildWolfAdapter implements Grandma {
        private final Wolf wolf;

        @Override
        public void snore() {
            wolf.bark();
        }

        @Override
        public void sleep() {
            wolf.sleep();
        }
    }

    public static class GrandmaHome {
        public void call(Grandma grandma) {
            grandma.snore();
        }
    }

    public static class RedHat {
        public static void main(String[] args) {
            GrandmaHome home = new GrandmaHome();

            Grandma redHatGrandma = new RedHatGrandma();

            home.call(redHatGrandma);

            Wolf wolf = new BigWildWolf();

            redHatGrandma = new BigWildWolfAdapter(wolf);

            home.call(redHatGrandma);
        }
    }
}
