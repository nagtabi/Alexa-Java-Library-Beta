package request;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * When a user interacts with an Alexa skill, your service receives a POST
 * request containing a JSON body. The request body contains the parameters
 * necessary for the service to perform its logic and generate a JSON-formatted
 * response.
 *
 * @author --G--
 */
public interface AlexaRequest {

    /**
     * The version specifier for the request with the value defined as: "1.0"
     *
     * @return "1.0"
     */
    String getVersion();

    /**
     * A boolean value indicating whether this is a new session.
     *
     * @return true for a new session or false for an existing session.
     */
    boolean isNewSession();

    /**
     * A string that represents a unique identifier per a user's active session.
     *
     * @return session id string
     */
    String getSessionId();

    /**
     * A string representing the application ID for your skill.
     *
     * @return string
     */
    String getApplicationId();

    /**
     * A string that represents a unique identifier for the Amazon account for
     * which the skill is enabled. The length of this identifier can vary, but
     * is never more than 255 characters.
     *
     * @return
     */
    String getContextUserId();

    /**
     * A string that represents a unique identifier for the Amazon account for
     * which the skill is enabled. The length of this identifier can vary, but
     * is never more than 255 characters.
     *
     * @return
     */
    String getSessionUserId();

    /**
     * A token identifying the user in another system. This token is only
     * provided if the user has successfully linked their account.
     *
     * @return
     */
    String getSessionUserAccessToken();

    /**
     * The deviceId property uniquely identifies the device.
     *
     * @return
     */
    String getDeviceId();

    /**
     * The supportedInterfaces property lists each interface that the device
     * supports. For example, if supportedInterfaces includes AudioPlayer {},
     * then you know that the device supports streaming audio using the
     * AudioPlayer interface.
     *
     * @return
     */
    //TODO: ??? what the f is this ??? supported interface i have never seen one
    Object getSupportedInterfaces();

    /**
     * A string containing a token that can be used to access Alexa-specific
     * APIs. This token encapsulates:
     *
     * Any permissions the user has consented to, such as permission to access
     * the user's address with the Device Location API. Access to other
     * Alexa-specific APIs, such as the Progressive Response API
     *
     * This token is included in all requests sent to your skill. When using
     * this token to access an API that requires permissions, your skill should
     * call the API and check the return code. If a 403 (access denied) code is
     * returned, your skill can then take appropriate actions to request the
     * permissions from the user.
     *
     * @return
     */
    String getApiAccessToken();

    /**
     * A string that references the correct base URI to refer to by region, for
     * use with APIs such as the Device Location API and Progressive Response
     * API.
     *
     * @return
     */
    String getApiEndPoint();

    /**
     * Different modes in which the customer is expected to interact with the
     * viewport.
     *
     * @return
     */
    //TODO: make an experiences type
    List<Map<String, Object>> getExperiences();

    /**
     * ROUND or RECTANGLE
     *
     * @return
     */
    String getShape();

    /**
     * Width of the viewport in pixels.
     *
     * @return
     */
    int getPixelWidth();

    /**
     * Height of the viewport in pixels.
     *
     * @return
     */
    int getPixelHeight();

    /**
     * Pixel density of the viewport.
     *
     * @return
     */
    int getDpi();

    /**
     * Width of the viewport in pixels that is currently in use.
     *
     * @return
     */
    int getCurrentPixelWidth();

    /**
     * Height of the viewport in pixels that is currently in use.
     *
     * @return
     */
    int getCurrentPixelHeight();

    /**
     * Touch events that the viewport supports.
     *
     * @return
     */
    List<String> getTouch();

    List<String> getCodecs();

    /**
     * The Alexa service sends your service a request using one of the standard
     * request types when users engage with your skill by voice. There are
     * several request types:
     *
     * LaunchRequest: Sent when the user invokes your skill without providing a
     * specific intent. IntentRequest: Sent when the user makes a request that
     * corresponds to one of the intents defined in your intent schema.
     * SessionEndedRequest: Sent when the current skill session ends for any
     * reason other than your code closing the session. CanFulfillIntentRequest:
     * Sent when the Alexa service is querying a skill to determine whether the
     * skill can understand and fulfill the intent request with detected slots,
     * before actually asking the skill to take action.
     *
     * @return
     */
    RequestIntentType getRequestIntentType();

    /**
     * Represents a unique identifier for the specific request.
     *
     * @return
     */
    String getRequestId();

    /**
     * Provides the date and time when Alexa sent the request as a LocalDateTime
     * object.
     *
     * @return
     */
    LocalDateTime getTimeStamp();

    /**
     * This is a string code indicating the user's locale, such as en-US for
     * English (US). Use this to determine the language in which your skill
     * should respond.
     *
     * @return locale string
     * @example en-US
     */
    String getLocale();

    boolean shouldLinkResultBeReturned();

    /**
     * A string representing the name of the intent.
     *
     * @return
     */
    String getIntentName();

    /**
     * An enumeration indicating whether the user has explicitly confirmed or
     * denied the entire intent. Possible values:
     *
     * NONE CONFIRMED DENIED
     *
     * @return
     */
    ConfirmationStatus getIntentConfirmationStatus();

    /**
     * A list of slots that further describes what the user meant based on a
     * predefined intent schema. The list can be empty.
     *
     * The key is a string that describes the name of the slot. Type: string.
     * The value is an object of type slot. Type: object. See Slot Object.
     *
     * @return
     */
    List<? extends Slot> getIntentSlots();

    /**
     * Get a slot by its name
     *
     * @param slotName
     * @return slot
     * @throws NonExistentSlotException
     */
    Slot getSlotByName(String slotName) throws NonExistentSlotException;

    /**
     * a string indicating the type of error that occurred (INVALID_RESPONSE,
     * DEVICE_COMMUNICATION_ERROR, INTERNAL_SERVICE_ERROR, ENDPOINT_TIMEOUT).
     *
     * @return
     */
    String getSessionEndedErrorType();

    /**
     * a string providing more information about the error.
     *
     * @return
     */
    String getSessionEndedErrorMessage();

    /**
     * Describes why the session ended. Possible values:
     *
     * USER_INITIATED: The user explicitly ended the session. ERROR: An error
     * occurred that caused the session to end. EXCEEDED_MAX_REPROMPTS: The user
     * either did not respond or responded with an utterance that did not match
     * any of the intents defined in your voice interface.
     *
     * @return
     */
    String getSessionEndedReason();

    /**
     * A map of key-value pairs. The attributes map is empty for requests where
     * a new session has started with the property new set to true.
     *
     * The key is a string that represents the name of the attribute. Type:
     * string The value is an object that represents the value of the attribute.
     * Type: object
     *
     * When returning your response, you can include data you need to persist
     * during the session in the sessionAttributes property. The attributes you
     * provide are then passed back to your skill on the next request.
     *
     * @return
     */
    Map<String, Object> getSessionAttributes();

    /**
     * Get or create the last sent intent You can use it to add to the session
     * attributes for a conversation purpose.
     *
     * @param lastIntentSessionAttrName
     * @return
     */
    LastIntent getOrCreateLastIntent(String lastIntentSessionAttrName);

    /**
     * You can add your custom Java object as a session attribute and this method
     * will find it in the request.
     *
     * @param <T>
     * @param customAttributeName
     * @param typeOfCustomAttribute
     * @return Custom Java object
     * @example MyType t=request.getCustomRequestAttribute("attrName");
     */
    <T extends Object> T getCustomRequestAttrubite(String customAttributeName,
            Type typeOfCustomAttribute);

    boolean hasRecognizedPerson();

    /**
     * A string that represents a unique identifier for the person who is making
     * the request. The length of this identifier can vary, but is never more
     * than 255 characters. Alexa generates this string when a recognized
     * speaker makes a request to your skill. Normally, disabling and
     * re-enabling a skill generates a new identifier.
     *
     * @return
     */
    String getPersonId();

    /**
     * A token identifying the person in another system. This field only appears
     * in the request if the person has successfully linked their account with
     * their Alexa profile.
     *
     *
     * @return accessToken or null
     */
    String getPersonAccessToken();

    /**
     * Write the request to json object
     *
     * @return
     */
    String toJSON();

}
