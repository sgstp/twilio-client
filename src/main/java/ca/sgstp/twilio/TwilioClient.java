package ca.sgstp.twilio;


import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Base64;
import java.util.Collections;

public class TwilioClient {

    private final String DEFAULT_URL = "https://api.twilio.com/2010-04-01/Accounts/";

    private final String baseUrl;
    private final String accountSid;
    private final String apiSid;
    private final String apiKey;

    private ServiceMessage serviceMessage;

    public TwilioClient(String baseUrl, String accountSid, String apiSid, String apiKey) {
        this.baseUrl = baseUrl;
        this.accountSid = accountSid;
        this.apiSid = apiSid;
        this.apiKey = apiKey;
    }

    public TwilioClient(String accountSid, String apiSid, String apiKey) {
        this.baseUrl = DEFAULT_URL;
        this.accountSid = accountSid;
        this.apiSid = apiSid;
        this.apiKey = apiKey;
    }

    public ServiceMessage getServiceMessage() {
        if (serviceMessage == null) {
            serviceMessage = getService(ServiceMessage.class);
        }
        return serviceMessage;
    }


    private <T> T getService(Class<T> classeInterface) {
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString((apiSid + ":" + apiKey).getBytes()));
        ClientConfig cc = new ClientConfig().register(classeInterface);
        Client resource = ClientBuilder.newClient(cc);
        resource.register(FormBodyWriter.class);
        T service = WebResourceFactory.newResource(classeInterface, resource.target(baseUrl + accountSid + "/"), false, headers, Collections.emptyList(), new Form());
        return service;
    }

}
