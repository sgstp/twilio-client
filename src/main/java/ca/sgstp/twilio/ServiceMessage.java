package ca.sgstp.twilio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(ServiceMessage.PATH)
public interface ServiceMessage {

    String PATH = "/Messages.json";

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    ResponseSendMessage sendMessage(Message message);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    ResponseFindMessage getAll();
}
