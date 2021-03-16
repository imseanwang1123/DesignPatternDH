package design_pattern.builder_pattern;

import lombok.*;

public class BuilderPattern {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    @Setter
    public static class Product {
        private String attr1;
        private String attr2;
        private String attr3;

        public interface Builder {
            Builder buildAttr1();

            Builder buildAttr2();

            Builder buildAttr3();

            Product build();
        }

        private static class ConcreteBuilder implements Builder {
            private Product product;

            public ConcreteBuilder() {
                this.product = new Product();
            }

            @Override
            public Builder buildAttr1() {
                String attr1 = "A";
                product.setAttr1(attr1);
                return this;
            }

            @Override
            public Builder buildAttr2() {
                String attr2 = "B";
                product.setAttr2(attr2);
                return this;
            }

            @Override
            public Builder buildAttr3() {
                String attr3 = "C";
                product.setAttr3(attr3);
                return this;
            }

            @Override
            public Product build() {
                System.out.println("build product...");
                return product;
            }
        }

        @AllArgsConstructor
        public static class Director {
            private Builder builder;

            public Product construct() {
                return builder.buildAttr1()
                        .buildAttr2()
                        .buildAttr3()
                        .build();
            }
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName()
                    + ":{"
                    + "attr1:" + attr1 + ","
                    + "attr2:" + attr2 + ","
                    + "attr3:" + attr3 + ","
                    + "}";
        }

    }
}
