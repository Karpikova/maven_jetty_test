package maven_jetty_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IntegrationTest {

    @Test
    public void app(){

        int countToCheck = 0;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                maven_jetty_test.Server server = new maven_jetty_test.Server(2222);
                server.startServer();
            }
        });
        thread.start();

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

        Set<Integer> randoms = new HashSet<Integer>();
        for (int i = 0; i < countToCheck; i++) {
            randoms.add(Integer.valueOf(restHandler.fetchRemoteGet(connection)));
        }
        assertEquals(countToCheck, randoms.size(), (countToCheck*0.1));
    }
}