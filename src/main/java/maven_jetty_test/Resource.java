package maven_jetty_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.beans.IntrospectionException;


@Component
@Path("home")
public class Resource {

    @Autowired
    Calculator calculator;

    @Autowired
    ClassPathXmlApplicationContext context;

    @Autowired
    public RestHandler restHandler;

    @GET
    @Path("hello/{arg1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcOnline(@PathParam("arg1") String arg1) {

        RestHandler restHandler1 = new RestHandler();
        Calculator calculator1 = new Calculator();
        String randomString = restHandler1.getRandom("http://localhost:3333/home/random");
        int random = Integer.valueOf(randomString);

        int resInt = calculator1.addition(Integer.valueOf(arg1), random);
        return "Result = " + resInt;
    }

}