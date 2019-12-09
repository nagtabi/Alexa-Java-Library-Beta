package request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import utils.DateJsonSerializier;
import utils.JsonPartCreator;


/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
class AlexaRequestImpl implements AlexaRequest {

    String originalText;
    String version;
    Session session;
    Context context;
    Request request;

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public boolean isNewSession() {
        return session.newSession;
    }

    @Override
    public String getSessionId() {
        return session.sessionId;
    }

    @Override
    public String getApplicationId() {
        return session.application.applicationId;
    }

    @Override
    public String getContextUserId() {
        return context.system.user.userId;
    }

    @Override
    public String getSessionUserId() {
        return session.user.userId;
    }

    @Override
    public String getDeviceId() {
        return context.system.device.deviceId;
    }

    @Override
    public Object getSupportedInterfaces() {
        return context.system.device.supportedInterfaces;
    }

    @Override
    public String getApiAccessToken() {
        return context.system.apiAccessToken;
    }

    @Override
    public String getApiEndPoint() {
        return context.system.apiEndpoint;
    }

    @Override
    public List<Map<String, Object>> getExperiences() {
        return context.viewport.experiences;
    }

    @Override
    public String getShape() {
        return context.viewport.shape;

    }

    @Override
    public int getPixelWidth() {
        return context.viewport.pixelWidth;
    }

    @Override
    public int getPixelHeight() {
        return context.viewport.pixelHeight;

    }

    @Override
    public int getDpi() {
        return context.viewport.dpi;
    }

    @Override
    public int getCurrentPixelWidth() {
        return context.viewport.currentPixelWidth;

    }

    @Override
    public int getCurrentPixelHeight() {
        return context.viewport.currentPixelHeight;
    }

    @Override
    public List<String> getTouch() {
        return context.viewport.touch;
    }

    @Override
    public List<String> getCodecs() {
        return context.viewport.video.codecs;
    }

    @Override
    public RequestIntentType getRequestIntentType() {
        return request.type;
    }

    @Override
    public String getRequestId() {
        return request.requestId;
    }

    @Override
    public LocalDateTime getTimeStamp() {
        return request.timestamp;
    }

    @Override
    public String getLocale() {
        return request.locale;
    }

    @Override
    public boolean shouldLinkResultBeReturned() {
        return request.shouldLinkResultBeReturned;
    }

    @Override
    public String getIntentName() {
        if (request.type == RequestIntentType.LaunchRequest) {

        }
        switch (request.type) {
            case LaunchRequest:
                return "LaunchRequest";
            case SessionEndedRequest:
                return "SessionEndedRequest";
            default:
                return request.intent.name;
        }

    }

    @Override
    public ConfirmationStatus getIntentConfirmationStatus() {
        return request.intent.confirmationStatus;
    }

    @Override
    public List<Slot> getIntentSlots() {
        List<Slot> list = new ArrayList<>();
        Set<Entry<String, SlotImpl>> set = ((Map<String, SlotImpl>) request.intent.slots).entrySet();
        for (Entry<String, SlotImpl> entry : set) {

            list.add(entry.getValue());
        }
        return list;
    }

    static AlexaRequest fromJSON(String jsonText) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new DateJsonSerializier())
                .create();
        AlexaRequestImpl imp = gson.fromJson(jsonText, AlexaRequestImpl.class);
        imp.originalText=jsonText;
        return imp;

    }

    @Override
    public String toJSON() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new DateJsonSerializier())
                .create();
        return gson.toJson(this);
    }

    @Override
    public Slot getSlotByName(String slotName) {
        Map<String, SlotImpl> slots = (Map<String, SlotImpl>) request.intent.slots;
        if (slots.containsKey(slotName)) {
            return slots.get(slotName);
        }
        throw new NonExistentSlotException("We can't find your slot! Check its name.");

    }

    @Override
    public String getSessionEndedErrorType() {
        return request.error.type;
    }

    @Override
    public String getSessionEndedErrorMessage() {
        return request.error.message;
    }

    @Override
    public String getSessionEndedReason() {
        return request.reason;
    }

    @Override
    public Map<String, Object> getSessionAttributes() {
        return session.attributes;
    }

    @Override
    public LastIntent getOrCreateLastIntent(String lastIntentSessionAttrName) {
        LastIntentImpl lastIntent;
        if (session.attributes!=null && session.attributes.containsKey(lastIntentSessionAttrName)) {
           
            lastIntent = LastIntentImpl
                    .fromJson(originalText, lastIntentSessionAttrName);
            lastIntent.attemptCount++;
        } else {
            lastIntent=new LastIntentImpl();
            lastIntent.intent = request.intent;
            lastIntent.requestIntentType = request.type;
        }
        return lastIntent;
    }

    @Override
    public boolean hasRecognizedPerson() {
        return context.system.person !=null;
    }

    @Override
    public String getPersonId() {
        if (hasRecognizedPerson()) {
            return context.system.person.personId;
        }
        return null;
    }

    @Override
    public String getPersonAccessToken() {
        if (hasRecognizedPerson()) {
            return context.system.person.accessToken;
        }
        return null;
    }
    
    
    
    

    @Override
    public <T> T getCustomRequestAttrubite(String customAttributeName,
            Type typeOfCustomAttribute) {
        if (!originalText.contains(customAttributeName)) {
            throw new CustomAttributeException
        ("This attribute ("+customAttributeName+") does not exist!");
        }
        String jsonText=JsonPartCreator
                .getJsonPartByTagName(originalText, customAttributeName);
        Gson gson=new Gson();
        return gson.fromJson(jsonText, typeOfCustomAttribute);
    }

    @Override
    public String getSessionUserAccessToken() {
        return session.user.accessToken;
    }
    
    
    

}
