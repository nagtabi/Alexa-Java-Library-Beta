package request;

import interfaces.JsonAble;
import java.util.List;

/**
 *
 * @author --G--
 */
public interface LastIntent extends JsonAble {

    Class getThisClass();

    RequestIntentType getRequestLastIntentType();

    String getLastIntentName();

    ConfirmationStatus getLastIntentConfirmationStatus();

    List<? extends Slot> getLastIntentSlots();

    Slot getSlotByName(String slotName);

    boolean isFirstAttemp();

    int getAttemptsCount();
}
