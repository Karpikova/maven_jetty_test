package maven_jetty_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Component
@Path("home")
public class Resource {

    @Autowired
    Calculator calculator;

    @Autowired
    public RestHandler restHandler;

    @GET
    @Path("hello/{action}/{arg1}/{arg2}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcOnline(@PathParam("action") String action, @PathParam("arg1") String arg1, @PathParam("arg2") String arg2) {
        int resInt = 0;

        String winAction = restHandler.winAction();

        if (winAction.equals(arg1.concat(action).concat(arg2))) {
            return "Congrats! You have win 100500 mln rub! Just send an sms to number +7 914 000 00 01";
        }

        if (action.equals("+")) {
            resInt = calculator.addition(Integer.valueOf(arg1), Integer.valueOf(arg2));
        } else if (action.equals("-")) {
            resInt = calculator.substraction(Integer.valueOf(arg1), Integer.valueOf(arg2));
        } else {
            return  "Wrong operation, sorry";
        }

        return "Result = " + resInt;
    }

}