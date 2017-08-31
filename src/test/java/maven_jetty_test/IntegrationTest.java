package maven_jetty_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class IntegrationTest {

    @Test
    public void app(){
        maven_jetty_test.Server server = new maven_jetty_test.Server(2222);
        server.startServer();

        RestHandler restHandler = new RestHandler();

        URL url = null;
        HttpURLConnection connection = null;

        try {
            url = new URL("http://localhost:2222/home/hello/7");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Wrong remote URL");
        }

        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Connection trouble");
        }
        restHandler.fetchRemoteGet(connection);
    }
}