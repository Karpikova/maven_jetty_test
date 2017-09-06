package maven_jetty_test;

import org.springframework.stereotype.Component;

@Component
public class RestCalculatorImpl implements RestCalculator {

    private String urlForRandom;
    private Rest restHandler;

    public RestCalculatorImpl(String urlForRandom, Rest restHandler) {
        this.urlForRandom = urlForRandom;
        this.restHandler = restHandler;
    }

    public int plusRandom(int a) {
        String randomString = restHandler.getRandom(urlForRandom);
        int random = Integer.valueOf(randomString);
        return (a + random);
    }
}
