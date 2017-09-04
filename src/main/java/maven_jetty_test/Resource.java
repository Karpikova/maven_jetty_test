package maven_jetty_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("home")
public class Resource {

    @Autowired
    RestCalculatorImpl calculator;

    @Autowired
    public Rest restHandler;

    @GET
    @Path("hello/{arg1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcOnline(@PathParam("arg1") String arg1) {
        //Работает любая из двух имплементаций:
        //RestCalculatorImpl calculator1 = new RestCalculatorImpl("http://localhost:3333/home/random", new RestHandler_HttpURLConnection());
        RestCalculatorImpl calculator1 = new RestCalculatorImpl("http://localhost:3333/home/random", new RestHandler_RestTemplate());
        int resInt = calculator1.plusRandom(Integer.valueOf(arg1));
        return "Result = " + resInt;
    }
}