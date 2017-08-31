package maven_jetty_test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        maven_jetty_test.Server server = new maven_jetty_test.Server(2222);
        server.startServer();
    }


}
