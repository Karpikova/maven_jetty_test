package maven_jetty_test;

import org.springframework.stereotype.Component;

@Component
public class RestCalculatorImpl implements RestCalculator{

    private String urlForRandom;

    public RestCalculatorImpl(String urlForRandom) {
        this.urlForRandom = urlForRandom;
    }

    public int plusRandom(int a) {
        RestHandler restHandler = new RestHandler();
        String randomString = restHandler.getRandom(urlForRandom);
        int random = Integer.valueOf(randomString);
        return (a+random);
    }
}
