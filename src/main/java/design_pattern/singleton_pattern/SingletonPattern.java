package design_pattern.singleton_pattern;

public class SingletonPattern {

    public static class GreedSingleton {

        private static GreedSingleton instance = new GreedSingleton();

        private GreedSingleton() {
        }

        public static GreedSingleton getInstance() {
            return instance;
        }

    }

    public static class LazyInitializationSingleton {

        private static LazyInitializationSingleton instance = new LazyInitializationSingleton();

        private LazyInitializationSingleton() {
        }

        public static LazyInitializationSingleton getInstance() {
            if (instance == null) {
                instance = new LazyInitializationSingleton();
            }

            return instance;
        }
    }

    public static class DoubleCheckedLockingSingleton {
        private static DoubleCheckedLockingSingleton instance;

        private DoubleCheckedLockingSingleton() {
        }

        public DoubleCheckedLockingSingleton getInstance() {
            if (instance == null) {
                synchronized (this) {
                    if (instance == null) {
                        instance = new DoubleCheckedLockingSingleton();
                    }
                }
            }

            return instance;
        }
    }

    public static class StaticInnerClassSingleton {

        private static class InnerClass {
            private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
        }

        private StaticInnerClassSingleton() {

        }

        public StaticInnerClassSingleton getInstance() {
            return InnerClass.instance;
        }

    }

    public enum EnumSingleton {
        INSTANCE;
    }


}
