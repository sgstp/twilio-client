package ca.sgstp.twilio;

import lombok.Builder;

/**
 * Représente un message texte à envoyer
 */
@Builder(builderClassName = "Builder", toBuilder = true)
public class Message {
    /**
     * The destination phone number in E.164 format for SMS/MMS or Channel user address for other 3rd-party channels.
     */
    public final String to;

    /**
     * The URL we should call using the status_callback_method to send status information to your application.
     * If specified, we POST these message status changes to the URL: queued, failed, sent, delivered, or undelivered.
     * Twilio will POST its standard request parameters as well as some additional parameters including MessageSid,
     * MessageStatus, and ErrorCode. If you include this parameter with the messaging_service_sid, we use this URL
     * instead of the Status Callback URL of the Messaging Service. URLs must contain a valid hostname and
     * underscores are not allowed.
     */
    public final String statusCallback;

    /**
     * The maximum total price in US dollars that you will pay for the message to be delivered.
     * Can be a decimal value that has up to 4 decimal places. All messages are queued for delivery
     * and the message cost is checked before the message is sent. If the cost exceeds max_price,
     * the message will fail and a status of Failed is sent to the status callback.
     * If MaxPrice is not set, the message cost is not checked.
     */
    public final String maxPrice;

    /**
     * Whether to confirm delivery of the message. Set this value to true if you are sending messages that have
     * a trackable user action and you intend to confirm delivery of the message using the
     * Message Feedback API. This parameter is false by default.
     */
    public final String provideFeedback;

    /**
     * A Twilio phone number in E.164 format, an alphanumeric sender ID, or a Channel Endpoint address that is enabled for
     * the type of message you want to send. Phone numbers or short codes purchased from Twilio also work here.
     * You cannot, for example, spoof messages from a private cell phone number. If you are using messaging_service_sid,
     * this parameter must be empty.
     */
    public final String from;

    /**
     * The SID of the Messaging Service you want to associate with the Message. Set this parameter to use the
     * Messaging Service Settings and Copilot Features you have configured and leave the from parameter empty.
     * When only this parameter is set, Twilio will use your enabled Copilot Features to select the from phone
     * number for delivery.
     */
    public final String messagingServiceSid;


    /**
     * The text of the message you want to send. Can be up to 1,600 characters in length.
     */
    public final String body;

    /**
     * The URL of the media to send with the message. The media can be of type gif, png, and jpeg and will be
     * formatted correctly on the recipient's device. The media size limit is 5MB for supported file types
     * (JPEG, PNG, GIF) and 500KB for other types of accepted media. To send more than one image in the message
     * body, provide multiple media_url parameters in the POST request. You can include up to 10 media_url
     * parameters per message. You can send images in an SMS message in only the US and Canada.
     */
    public final String mediaUrl;

}
