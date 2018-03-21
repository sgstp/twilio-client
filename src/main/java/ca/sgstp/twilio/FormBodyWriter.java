package ca.sgstp.twilio;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.URLEncoder;

@Provider
public class FormBodyWriter implements MessageBodyWriter {

    @Override
    public boolean isWriteable(Class aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return mediaType.equals(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
    }

    @Override
    public long getSize(Object o, Class aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(Object o, Class aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        Writer writer = new PrintWriter(outputStream);
        for (Field f : aClass.getFields()) {
            Object value;
            try {
                value = f.get(o);
            } catch (IllegalAccessException e) {
                throw new FormBodyWriteException();
            }
            if (value != null) {
                String nom = f.getName();
                nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
                writer.append(nom)
                    .append("=")
                    .append(URLEncoder.encode(value.toString(), "UTF-8"))
                    .append("&");
            }
        }
        writer.flush();
        writer.close();
    }
}
