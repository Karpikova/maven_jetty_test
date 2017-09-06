package maven_jetty_test;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IntegrationJerseyIT extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(Resource.class);
    }

    @Test
    public void ordersPathParamTest() {
        int countToCheck = 10;
        Set<String> randoms = new HashSet<String>();
        for (int i = 0; i < countToCheck; i++) {
            String response = target("home/hello/1").request().get(String.class);
            randoms.add(response);
            Assert.assertEquals("Result = ", response.substring(0, 9));
        }
        assertEquals(countToCheck, randoms.size(), (countToCheck*0.1));
    }


}
