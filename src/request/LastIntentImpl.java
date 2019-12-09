package request;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import utils.JsonPartCreator;

/**
 * Bug! In my code? Bitch! That is a feature.
 *
 * @author G
 */
class LastIntentImpl implements LastIntent {

    

   
    int attemptCount;
    RequestIntentType requestIntentType;
    Intent intent;

    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public Class getThisClass() {
        return this.getClass();
    }

    @Override
    public RequestIntentType getRequestLastIntentType() {
        return requestIntentType;
    }

    @Override
    public String getLastIntentName() {
        return intent.name;
    }

    @Override
    public ConfirmationStatus getLastIntentConfirmationStatus() {
        return intent.confirmationStatus;
    }

    @Override
    public List<? extends Slot> getLastIntentSlots() {
        List<Slot> list = new ArrayList<>();
        Set<Map.Entry<String, SlotImpl>> set = ((Map<String, SlotImpl>) intent.slots).entrySet();
        for (Map.Entry<String, SlotImpl> entry : set) {

            list.add(entry.getValue());
        }
        return list;
    }

    @Override
    public Slot getSlotByName(String slotName) {
        Map<String, SlotImpl> slots = (Map<String, SlotImpl>) intent.slots;
        if (slots.containsKey(slotName)) {
            return slots.get(slotName);
        }
        throw new NonExistentSlotException("We can't find your slot! Check its name.");

    }

    @Override
    public boolean isFirstAttemp() {
        return attemptCount == 0;
    }

    @Override
    public int getAttemptsCount() {
        return attemptCount;
    }

    
 static LastIntentImpl fromJson(String originalText, String lastIntentSessionAttrName) {
        String jsonText=JsonPartCreator
                .getJsonPartByTagName(originalText, lastIntentSessionAttrName);
        Gson gson = new Gson();
       return gson.fromJson(jsonText, LastIntentImpl.class);
    }

    
    

}
