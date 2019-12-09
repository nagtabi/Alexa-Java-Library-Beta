
package reponse;

import com.google.gson.Gson;

/**
 * Bug!
 * In my code?
 * Bitch! That is a feature.
 * @author G
 */
 class AlexaCanFulfillIntentResponse implements AlexaResponse{
       String version = "1.0";
       FulfillResponse response;

    public AlexaCanFulfillIntentResponse(CanFulfillResponse canFulfillIntent) {
        response=new FulfillResponse(canFulfillIntent);
    }
       
       
    @Override
    public String toJson() {
        Gson gson=new Gson();
        return gson.toJson(this);
    }

}
