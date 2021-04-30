package ca.sgstp.twilio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ResponseSendMessage {
    public final String dateCreated;
    public final String dateSent;
    public final Integer num_media;
    public final Integer num_segments;
    public final Long price;
    public final String status;
}
