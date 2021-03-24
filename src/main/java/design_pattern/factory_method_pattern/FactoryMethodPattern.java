package design_pattern.factory_method_pattern;

import java.util.HashMap;
import java.util.Map;

public class FactoryMethodPattern {

    public static void main(String[] args) {
        Loader jsonLoader = new JsonLoaderFactory().createLoader();
        jsonLoader.load();

        Loader xmlLoader = new XmlLoaderFactory().createLoader();
        xmlLoader.load();

    }

    public interface LoaderFactory {
        Loader createLoader();
    }

    public interface Loader {
        void load();
    }

    public static class JsonLoaderFactory implements LoaderFactory {
        @Override
        public Loader createLoader() {
            return new JsonLoader();
        }
    }

    public static class XmlLoaderFactory implements LoaderFactory {
        @Override
        public Loader createLoader() {
            return new XmlLoader();
        }
    }

    public static class JsonLoader implements Loader {
        @Override
        public void load() {
            System.out.println("Load Json");
        }
    }

    public static class XmlLoader implements Loader {
        @Override
        public void load() {
            System.out.println("Load Xml");
        }
    }
}
