package ca.sgstp.twilio;

import lombok.Builder;

/**
 * Représente un message texte à envoyer
 */
@Builder(builderClassName = "Builder", toBuilder = true)
public class Message {
    /**
     * The destination phone number. Format with a '+' and country code e.g., +16175551212 (E.164 format).
     */
    public final String to;

    /**
     * A Twilio phone number (in E.164 format) or alphanumeric sender ID enabled for the type of message you wish to send.
     * Phone numbers or short codes purchased from Twilio work here. You cannot (for example) spoof messages from your own cell phone number.
     */
    public final String from;


    /**
     * The text of the message you want to send, limited to 1600 characters.
     */
    public final String body;

    /**
     * The 34 character unique id of the Messaging Service you want to associate with this Message.
     * Set this parameter to use the Messaging Service Settings and Copilot Features you have configured.
     * When only this parameter is set, Twilio will use your enabled Copilot Features to select the From phone number for delivery.
     */
    public final String messagingServiceSid;

    /**
     * The URL of the media you wish to send out with the message. gif , png and jpeg content is currently supported
     * and will be formatted correctly on the recipient's device.
     * Other types are also accepted by the API. The media size limit is 5MB.
     * If you wish to send more than one image in the message body, please provide multiple MediaUrls values in the POST request.
     * You may include up to 10 MediaUrls per message.
     */
    public final String mediaUrl;


    /**
     * URL where Twilio will POST each time your message status changes to one of the following: queued, failed, sent, delivered, or undelivered.
     * Twilio will POST the MessageSid along with the other standard request parameters as well as MessageStatus and ErrorCode.
     * If this parameter passed in addition to a MessagingServiceSid, Twilio will override the Status Callback URL of the Messaging Service.
     * Non-relative URLs must contain a valid hostname (underscores are not allowed).
     */
    public final String statusCallback;


    /**
     * Twilio will POST MessageSid as well as MessageStatus=sent or MessageStatus=failed to the URL in the MessageStatusCallback property of this Application.
     * If the StatusCallback parameter above is also passed, the Application's MessageStatusCallback parameter will take precedence.
     */
    public final String applicationSid;

    /**
     * Set this value to true if you are sending messages that have a trackable user action and you intend to confirm
     * delivery of the message using the Message Feedback API.
     * This parameter is set to false by default.
     */
    public final String provideFeedback;

    /**
     * The total maximum price up to the fourth decimal (0.0001) in US dollars acceptable for the message to be delivered.
     * All messages regardless of the price point will be queued for delivery. A POST request will later be made to your
     * Status Callback URL with a status change of 'Sent' or 'Failed'. When the price of the message is above this value
     * the message will fail and not be sent. When MaxPrice is not set, all prices for the message is accepted.
     */
    public final String maxPrice;


    /**
     * The number of seconds that the message can remain in a Twilio queue. After exceeding this time limit, the message will fail and a
     * POST request will later be made to your Status Callback URL. Valid values are between 1 and 14400 seconds (the default).
     * Please note that Twilio cannot guarantee that a message will not be queued by the carrier after they accept the message.
     * We do not recommend setting validity periods of less than 5 seconds.
     */
    public final String validityPeriod;

}
