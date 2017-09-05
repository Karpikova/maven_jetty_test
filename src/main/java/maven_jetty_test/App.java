package maven_jetty_test;

public class App
{
    public static void main( String[] args )
    {
//!      ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        maven_jetty_test.Server server = new maven_jetty_test.Server(2222);
        server.startServer();
    }


}
