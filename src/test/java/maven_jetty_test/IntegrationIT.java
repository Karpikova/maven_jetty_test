package maven_jetty_test;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IntegrationIT {

    @Test
    public void app(){

        for (int i = 0; i < 10000; i++) {
            test();
        }
    }

    private void test() {
        int countToCheck = 0;
        Server server = new Server(2222);
        server.startServer();

        RestHandler_HttpURLConnection restHandler = new RestHandler_HttpURLConnection();
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
        server.stopServer();
    }
}