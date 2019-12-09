
package reponse;

/**
 * Bug!
 * In my code?
 * Bitch! That is a feature.
 * @author G
 */
class FulfillResponse {

    CanFulfillIntent canFulfillIntent;

    public FulfillResponse(CanFulfillResponse canFulfillResponse) {
        canFulfillIntent=new CanFulfillIntent(canFulfillResponse);
    }
    
    
}
