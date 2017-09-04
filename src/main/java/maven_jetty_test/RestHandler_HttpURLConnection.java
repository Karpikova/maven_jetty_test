package maven_jetty_test;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Component
public class RestHandler_HttpURLConnection implements Rest{

    public String getRandom(String url_string) {
        URL url = null;
        HttpURLConnection connection = null;

        try {
            url = new URL(url_string);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Wrong remote URL";
        }

        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return "Connection trouble";
        }

        String result = fetchRemoteGet(connection);
        connection.disconnect();
        return (result);
    }

    public String fetchRemoteGet(HttpURLConnection connection){
        try {
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String output;
            String out = "";
            while ((output = br.readLine()) != null) {
                out = out.concat(output);
            }
            return out;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
