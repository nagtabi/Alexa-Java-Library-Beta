package request;

/**
 *
 * @author --G--
 */
public interface Slot {

    /**
     * The name of the slot
     *
     * @return
     */
    String getName();

    /**
     * A string that represents the value the user spoke for the slot. This is
     * the actual value the user spoke, not necessarily the canonical value or
     * one of the synonyms defined for the entity.
     *
     * @return
     * @throws SlotNullValueException
     */
    String getStringValue() throws SlotNullValueException;

    /**
     * An enumeration indicating whether the user has explicitly confirmed or
     * denied the value of this slot. Possible values:
     *
     * NONE CONFIRMED DENIED
     *
     * @return
     */
    ConfirmationStatus getConfirmationStatus();

    String getSource();

    int getIntegerValue() throws SlotNullValueException, SlotParseException;

    long getLongValue() throws SlotNullValueException, SlotParseException;

    double getDoubleValue() throws SlotNullValueException, SlotParseException;

    float getFloatValue() throws SlotNullValueException, SlotParseException;

    byte getByteValue() throws SlotNullValueException, SlotParseException;

    boolean getBooleanValue() throws SlotNullValueException;

    short getShortValue() throws SlotNullValueException, SlotParseException;

    <T extends CustomSlotType> T getCustomSlotTypeValue() throws SlotNullValueException, SlotParseException;

    /**
     * An array of objects representing each possible authority for entity
     * resolution. An authority represents the source for the data provided for
     * the slot. For a custom slot type, the authority is the slot type you
     * defined.
     *
     * @param <T>
     * @return
     */
    <T extends ResolutionPerAuthority> T getResolutionPerAuthority();
}
