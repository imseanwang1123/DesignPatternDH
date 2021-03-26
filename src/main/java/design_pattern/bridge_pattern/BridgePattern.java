package design_pattern.bridge_pattern;

import lombok.Setter;

public class BridgePattern {
    interface Color {
        String getColor();
    }


    public static class Red implements Color {

        @Override
        public String getColor() {
            return "Red";
        }
    }

    public static class Blue implements Color {

        @Override
        public String getColor() {
            return "Blue";
        }
    }

    abstract static class Bag {
        @Setter
        protected Color color;

        public abstract String getName();

    }

    public static class BackPack extends Bag {

        @Override
        public String getName() {
            return "BackPack";
        }
    }

    public static class Wallet extends Bag {

        @Override
        public String getName() {
            return "Wallet";
        }
    }
}
