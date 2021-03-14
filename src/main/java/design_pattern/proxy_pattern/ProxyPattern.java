package design_pattern.proxy_pattern;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

public class ProxyPattern {
    public static void main(String[] args) {
        Subject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.service();
    }

    public interface Subject {
        void service();
    }

    public static class RealSubject implements Subject {

        @SneakyThrows
        @Override
        public void service() {
            System.out.println("Real Subject Start");
            Thread.sleep(3000);
            System.out.println("Real Subject Finish");
        }
    }

    @AllArgsConstructor
    public static class ProxySubject implements Subject {
        private RealSubject realSubject;

        @Override
        public void service() {
            System.out.println("Proxy Subject Finish");
            realSubject.service();
            System.out.println("Proxy Subject Finish");

        }
    }


}
