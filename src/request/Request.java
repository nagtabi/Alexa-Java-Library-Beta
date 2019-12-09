package request;

import java.time.LocalDateTime;

/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
class Request {
//enum or string?

    RequestIntentType type;
    String requestId;
    LocalDateTime timestamp;
    String locale;
    boolean shouldLinkResultBeReturned;
    Intent intent;
    String dialogState;
    String reason;
    Error error;

}
