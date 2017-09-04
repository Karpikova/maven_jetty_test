package maven_jetty_test;

import org.springframework.web.client.RestTemplate;

public class RestHandler_RestTemplate implements Rest{
    public String getRandom(String url_string) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url_string, String.class);
    }
}
