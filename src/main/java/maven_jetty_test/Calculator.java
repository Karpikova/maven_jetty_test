package maven_jetty_test;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int addition(int a, int b) {
        return a+b;
    }
}
