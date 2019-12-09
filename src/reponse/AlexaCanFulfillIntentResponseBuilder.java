
package reponse;

/**
 * Bug!
 * In my code?
 * Bitch! That is a feature.
 * @author G
 */
public class AlexaCanFulfillIntentResponseBuilder {

    private AlexaCanFulfillIntentResponse alexaCanFulfillIntentResponse;
    public AlexaCanFulfillIntentResponseBuilder(CanFulfillResponse canFulfillIntent) {
      alexaCanFulfillIntentResponse=new AlexaCanFulfillIntentResponse(canFulfillIntent);
    }
    
     public AlexaCanFulfillIntentResponseBuilder addFulfillSlot(String slotName,
             CanFulfillResponse canUnderstand, CanFulfillResponse canFulfill){
         CanFulfillSlot slot=new CanFulfillSlot();
         slot.canFulfill=canFulfill;
         slot.canUnderstand=canUnderstand;
         alexaCanFulfillIntentResponse.response.canFulfillIntent.slots.put(slotName, slot);
               return this;  
     }    

    public AlexaResponse build(){
       return alexaCanFulfillIntentResponse;
    }
}
