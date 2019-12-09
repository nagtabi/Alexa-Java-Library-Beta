
package reponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bug!
 * In my code?
 * Bitch! That is a feature.
 * @author G
 */
class CanFulfillIntent {

    CanFulfillResponse canFulfill;
    Map<String, CanFulfillSlot> slots;

    
    
    public CanFulfillIntent(CanFulfillResponse canFulfillIntent) {
        this.canFulfill=canFulfillIntent;
        slots=new HashMap<>();
    }
    
    
}
