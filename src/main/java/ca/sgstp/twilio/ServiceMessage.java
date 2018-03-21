package ca.sgstp.twilio;

    import javax.ws.rs.Consumes;
    import javax.ws.rs.POST;
    import javax.ws.rs.Path;
    import javax.ws.rs.Produces;
    import javax.ws.rs.core.MediaType;

@Path(ServiceMessage.PATH)
public interface ServiceMessage {

    String PATH = "Messages.json";

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    EmptyResult envoyerMessage(Message message);
}
